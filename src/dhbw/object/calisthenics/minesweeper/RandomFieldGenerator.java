package dhbw.object.calisthenics.minesweeper;

import java.util.Random;

public class RandomFieldGenerator {

    private Random random = new Random();

    public Field next(Field previous, FieldGenerator fieldGenerator){
        double randomValue = random.nextDouble();

        if(randomValue <= 0.1){
            return new MineField(previous, fieldGenerator);
        }

        return new NeutralField(previous, fieldGenerator);
    }

}
