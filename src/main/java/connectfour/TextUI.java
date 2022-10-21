package connectfour;

import java.util.Scanner;

public class TextUI{
    private Scanner keyboardScanner = new Scanner(System.in);

    private String inputPromptString = "Enter the column you wish to insert into (1-7): ";
    private String invalidInputString = "Invalid or input. ";
    private String winnerString = "The winner is ";
    private String tieString = "It's a tie!\n";

    public  void turn(int currentPlayer, Board gameBoard){
        int userInput;

        System.out.println("============================================================");
        printBoard(gameBoard.toString());
        printPlayerTurnMessage(currentPlayer);
        
        userInput = collectInput();

        while (!isInputValid(userInput) || !gameBoard.updateBoard(userInput, currentPlayer)){
            printInvalidInputMessage();
            userInput = collectInput();   
        }
    }

    public void endOfGameMessage(Board gameBoard){
        printBoard(gameBoard.toString());

        if (gameBoard.checkWinner() == -1){
            printTieMessage();
        }else{
            printWinnerMessage(gameBoard.checkWinner());
        }
    }

    private void printBoard(String boardString){
        System.out.print(boardString);
    }

    private int collectInput(){
        int userInput;

        userInput = keyboardScanner.nextInt();  
        return userInput;
    }

    private boolean isInputValid(int input){
        return input <= 7 && input >= 1;
    }

    private void printPlayerTurnMessage(int currentPlayer){
        System.out.print("Player " + currentPlayer + "" + "'s turn. " + inputPromptString);
    }

    private void printInvalidInputMessage(){
        System.out.print(invalidInputString + inputPromptString);
    }

    private void printWinnerMessage(int winner){
        System.out.print(winnerString + winner + "");
    }

    private void printTieMessage(){
        System.out.print(tieString);
    }

}