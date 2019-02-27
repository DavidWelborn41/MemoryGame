package GameTest1;
import java.util.Scanner;

public class GameApp {

    public static void main(String args[]) {
        char playAgain;
        System.out.print("Enter number of rows: ");
        int r = getInput();
        System.out.print("Enter number of columns: ");
        int c = getInput();
        GameBoard userBoard = new GameBoard(r, c);
        GameBoard hiddenBoard = new GameBoard(r, c, 1);
        do {
            System.out.println(userBoard.toString());
            System.out.print("Enter a number to look for: ");
            int lookFor = getInput();
            System.out.println(hiddenBoard.toString());
            System.out.print("What is row of the number: ");
            int rowPos = getInput();
            System.out.print("What is the column of the number: ");
            int colPos = getInput();
            if (userBoard.checkPos(rowPos, colPos, lookFor) == true) {
                System.out.println("You're right!");
                hiddenBoard.applyToHidden(rowPos, colPos);
            } else {
                System.out.println("You're wrong dummy.");
            }
            System.out.println(hiddenBoard.toString());
            System.out.print("Keep going? y/n: ");
            Scanner reader = new Scanner(System.in);
            playAgain = reader.next().charAt(0);
        } while (playAgain == 'y');
    }

    public static int getInput() {
        Scanner input = new Scanner(System.in);
        int n;
        do {
            n = input.nextInt();
            if (n > 50 || n < 0) {
                System.out.println("must be between 0 and 50");
            } else {
                return n;
            }
        } while (n > 50 || n < 0);
        return 1;
    }

}

