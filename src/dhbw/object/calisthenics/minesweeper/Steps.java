package dhbw.object.calisthenics.minesweeper;

public class Steps {

    private int steps;

    public Steps(int steps){
        this.steps = steps;
    }

    public Field goLeft(Field origin, Field next, Field found){
        this.steps--;

        if(this.steps == 0){
            return found;
        }

        return next.goLeft(origin, this);
    }

    public Field goRight(Field origin, Field next, Field found){
        this.steps--;

        if(this.steps == 0){
            return found;
        }

        return next.goRight(origin, this);
    }

}