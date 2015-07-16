package dhbw.object.calisthenics.minesweeper;

import java.io.IOException;
import java.io.OutputStream;

public class MineField extends Field {

    private boolean covered = true;

    public MineField(Field previous, FieldGenerator fieldGenerator){
        super(previous, fieldGenerator);
    }

    public void print(OutputStream printer) throws IOException {
        if(covered){
            printer.write('#');
            if(next != null)next.print(printer);
            return;
        }

        printer.write('*');

        if(next != null)next.print(printer);
    }

    @Override
    public void isMine(Field field) {
        field.increment();
    }

    @Override
    public void increment() {

    }

    @Override
    public void neigbourUnconver() {

    }

    @Override
    public void neigbourCallUnconver() {

    }

    public void uncover(){
        this.covered = false;
    }

    @Override
    public void checkField() {

    }


}
