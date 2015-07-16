package dhbw.object.calisthenics.minesweeper;

public class FieldGenerator {

    private RandomFieldGenerator randomField = new RandomFieldGenerator();
    private int fieldCount = 0;

    public Field next(Field previous){
        fieldCount++;

        if(fieldCount > 20){
            return null;
        }

        if(fieldCount % 5 == 0){
            return new NewLineField(previous, this);
        }

        return randomField.next(previous, this);
    }

}
