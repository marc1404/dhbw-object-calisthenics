package dhbw.object.calisthenics.minesweeper;

import java.io.IOException;
import java.io.OutputStream;

public class NeutralField extends Field {

    private boolean covered = true;
    private int counter = 0;

    public NeutralField(Field previous, FieldGenerator fieldGenerator){
        super(previous, fieldGenerator);
    }

    public void print(OutputStream printer) throws IOException {
        if(covered){
            printer.write('#');
            if(next != null)next.print(printer);
            return;
        }

        printer.write(new String("" + counter).charAt(0));

        counter = 0;

        if(next != null)next.print(printer);
    }

    public void checkField() {
        Field bottom = this.getBottom();
        Field top = this.getTop();

        this.isMineNeighbors(this);
        if(bottom != null)bottom.isMineNeighbors(this);
        if(top != null) top.isMineNeighbors(this);

        if(counter == 0){
            if(bottom != null)bottom.uncover();
            if(top != null) top.uncover();
        }
        next.checkField();
    }

    @Override
    public void isMine(Field field) {}

    @Override
    public void increment() {
        counter++;
    }

    @Override
    public void neigbourUnconver(){
        next.neigbourCallUnconver();
        previous.neigbourCallUnconver();
    }

    @Override
    public void neigbourCallUnconver() {
        this.uncover();

    }

    public void uncover(){
        this.covered = false;
    }


}
