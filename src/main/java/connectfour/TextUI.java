package connectfour;

import java.util.Scanner;

public class TextUI{
    private Scanner keyboardScanner = new Scanner(System.in);

    private String invalidInpuString = "Invalid input. Enter the column you wish to insert into (1-7): ";

    public int turn(int currentPlayer, String boardString){
        int userInput;

        System.out.println("============================================================");
        printBoard(boardString);
        System.out.print(printPlayerTurnMessage(currentPlayer));
        
        userInput = collectInput();

        while (!isInputValid(userInput)){
            System.out.print(invalidInpuString);
            userInput = collectInput();   
        }

        return userInput;
    
    }

    private void printBoard(String boardString){
        System.out.print(boardString);
    }

    private String printPlayerTurnMessage(int currentPlayer){
        return "Player " + currentPlayer + "" + "'s turn. Enter the column you wish to insert into (1-7): ";
    }

    private int collectInput(){
        int userInput;

        userInput = keyboardScanner.nextInt();  
        return userInput;
    }

    private boolean isInputValid(int input){
        return input <= 7 && input >= 1;
    }

}