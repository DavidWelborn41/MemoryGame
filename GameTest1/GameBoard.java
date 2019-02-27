package GameTest1;

import java.util.Random;

public class GameBoard {
    /**
     * Game Board for a memory matching game
     * Should be able to be resized by the player before a new game
     * Multiple players possibly?
     */

    private int[][] boardArray;
    private int row;
    private  int col;

    public GameBoard(int r, int c) {
        boardArray = new int[r][c];
        int x;
        row = r;
        col = c;
        Random ran = new Random();
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                x = ran.nextInt((9-0)+1)+0;
                boardArray[i][j] = x;
            }
        }
    }

    public GameBoard(int r, int c, int random) {
        boardArray = new int[r][c];
        int x;
        row = r;
        col = c;
        Random ran = new Random();
        x = ran.nextInt((9-0)+1)+0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                boardArray[i][j] = x;
            }
        }
    }

    @Override
    public String toString(){
        String board = "   ";
        for(int i = 0; i < col; i++) {
            board += "|" + i;
        }
        board += "|\n";
        board += "  __";
        for(int i = 0; i < col; i++) {
            board += "__";
        }
        board += "\n";
        for(int i = 0; i < row; i++) {
            board += i + "| ";
            for (int j = 0; j < col; j++) {
                board += "|" + boardArray[i][j];
            }
            board += "|\n";
        }
        return board;
    }

    public boolean checkPos(int r, int c, int val) {
        if(boardArray[r][c] == val) {
            return true;
        }
        else {
            return false;
        }
    }

    public void applyToHidden(int r, int c) {
        boardArray[r][c] = 0;
    }
}
