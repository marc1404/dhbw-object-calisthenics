package dhbw.object.calisthenics.minesweeper;

import java.util.Scanner;

public class UserInput {

    private Scanner scanner = new Scanner(System.in);

    public int nextTarget(){
        return scanner.nextInt();
    }

}
