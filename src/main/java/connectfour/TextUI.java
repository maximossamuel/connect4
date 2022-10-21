package connectfour;

import java.util.Scanner;

public class TextUI{
    private Scanner keyboardScanner = new Scanner(System.in);

    public int turn(int currentPlayer, String boardString){
        System.out.println("============================================================");
        printBoard(boardString);
        System.out.print(printPlayerTurnMessage(currentPlayer));
        return collectInput();
    }

    private void printBoard(String boardString){
        System.out.print(boardString);
    }

    private String printPlayerTurnMessage(int currentPlayer){
        return "Player " + currentPlayer + "" + "'s turn. Enter the column you wish to insert into: ";
    }

    private int collectInput(){
        int userInput;

        userInput = keyboardScanner.nextInt();  
        return userInput;
    }

}