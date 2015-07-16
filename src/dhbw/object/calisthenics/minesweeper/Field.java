package dhbw.object.calisthenics.minesweeper;

import java.io.IOException;
import java.io.OutputStream;

public abstract class Field {

    protected Field previous;
    protected Field next;

    public Field(Field previous, FieldGenerator fieldGenerator){
        this.previous = previous;
        this.next = fieldGenerator.next(this);
    }

    public abstract void print(OutputStream printer) throws IOException;

    public abstract  void isMine( Field field);
    public abstract  void increment( );

    public void isMineNeighbors(Field field){
        this.isMine(field);

        if(previous != null) previous.isMine(field);
        if(next != null) next.isMine(field);
    }

    public Field goLeft(Field origin, Steps steps){
        if(this.previous == null){
            return null;
        }

        return steps.goLeft(origin, previous, this);
    }

    public Field goRight(Field origin, Steps steps){
        if(this.next == null){
            return null;
        }

        return steps.goRight(origin, next, this);
    }

    public Field getBottom(){
        return goRight(this, new Steps(5));
    }

    public Field getTop(){
        return goLeft(this, new Steps(5));
    }

    public void goUncover(int steps){
        if(steps == 1){
            this.uncover();
            return;
        }

        if(next != null){
            next.goUncover(--steps);
        }
    }

    public abstract void  neigbourUnconver();
    public abstract void  neigbourCallUnconver();

    public abstract void uncover();

    public abstract void checkField();
}