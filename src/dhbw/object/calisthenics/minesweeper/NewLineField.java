package dhbw.object.calisthenics.minesweeper;

import java.io.IOException;
import java.io.OutputStream;

public class NewLineField extends Field {

    public NewLineField(Field previous, FieldGenerator fieldGenerator){
        super(previous, fieldGenerator);
    }

    public void print(OutputStream printer) throws IOException {
        printer.write('\n');
        if(next != null)next.print(printer);
    }

    public void isMine(Field field) { }
    public void increment() {}
    public void uncover() {}

    @Override
    public void checkField() {

    }

    @Override
    public Field goLeft(Field origin, Steps steps){
        if(previous == null){
            return null;
        }

        return previous.goLeft(origin, steps);
    }

    @Override
    public Field goRight(Field origin, Steps steps){
        if(next == null){
            return null;
        }

        return next.goRight(origin, steps);
    }

    @Override
    public void goUncover(int steps) {
        next.goUncover(steps);
    }

    @Override
    public void neigbourUnconver() {

    }

    @Override
    public void neigbourCallUnconver() {

    }
}
