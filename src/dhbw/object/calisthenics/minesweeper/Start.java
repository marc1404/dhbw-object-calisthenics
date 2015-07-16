package dhbw.object.calisthenics.minesweeper;

import java.io.IOException;

public class Start {

    public static void main(String[] args) throws IOException {
        UserInput userInput = new UserInput();
        FieldGenerator fieldGenerator = new FieldGenerator();
        Field field = fieldGenerator.next(null);

        while(true){
            field.print(System.out);
            System.out.flush();

            int target = userInput.nextTarget();

            field.goUncover(target);
            field.checkField();
        }
    }

}
