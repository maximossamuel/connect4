package connectfour;

import java.util.Scanner;

/**
 * Handles all the output and input
 */
public class TextUI{
    private Scanner keyboardScanner;

    private String fileReadPrompt1 = "Would you like to load a previously saved game? (1 for yes, 2 for no): ";
    private String fileReadPrompt2 = "Enter the file you wish to load from (No need for .csv extension in input): ";
    private String fileReadError = "Sorry, this file either does not exist or is invalid. ";
    private String inputPromptString = "Enter the column you wish to insert into (1-7), 8 to save game or 9 to exit: ";
    private String fileSavePrompt = "Enter the name of the file you wish to save to: ";
    private String fileSaveError = "Sorry. But this file already exists. Try again. ";
    private String invalidInputString = "Invalid or illegal input. ";
    private String winnerString = "The winner is Player ";
    private String tieString = "It's a tie!\n";

    /**
     * Handles all the user inputs and outputs when trying
     * to load the game from a file
     * @return Returns a string containing the name of the file so
     * it can be used in other methods to load the file.
     */
    public String loadFromFilePrompts(){
        int userInput;

        printMessage(fileReadPrompt1);
        userInput = collectInput();

        while (!isInputValid(userInput, 1, 2)){
            printMessage(invalidInputString + fileReadPrompt1);
            userInput = collectInput();
        }

        if (userInput == 1){
            printMessage(fileReadPrompt2);
            return collectStringInput() + ".csv";
        }else{
            return null;
        }
    }

    /**
     * Handles all the input and output for each turn in the game. Prints the board,
     * takes the user input, etc
     * @param currentPlayer Used as parameters in methods to eventually change the board tokens to the
     * appropriate player
     * @param gameBoard Used to check and print the gameBoard
     */
    public void turn(int currentPlayer, Board gameBoard){
        int userInput;

        System.out.println("============================================================");
        printBoard(gameBoard.toString());
        printMessage("Player " + currentPlayer + "" + "'s turn. " + inputPromptString);
        
        userInput = collectInput();

        while (!isInputValid(userInput, 1, 7) || !gameBoard.updateBoard(userInput, currentPlayer)){
            if (userInput == 8){
                saveToFilePrompts(gameBoard);
                turn(currentPlayer, gameBoard);
                return;
            }else if (userInput == 9){
                System.exit(0);
            }

            printMessage(invalidInputString + inputPromptString);
            userInput = collectInput();   
        }
    }

    /**
     * Prints the board one last time and announces whether there was
     * a win or a tie
     * @param gameBoard Used so that the board can be printed one last time
     */
    public void endOfGameMessage(Board gameBoard){
        System.out.println("============================================================");
        printBoard(gameBoard.toString());

        if (gameBoard.checkWinner() == -1){
            printMessage(tieString);
        }else{
            printMessage(winnerString + gameBoard.checkWinner() + "" + "\n");
        }
    }

    private void printBoard(String boardString){
        System.out.print(boardString);
    }

    private int collectInput(){
        int userInput;

        keyboardScanner = new Scanner(System.in);

        try {
            userInput = keyboardScanner.nextInt();
        }catch(Exception e) {
            userInput = -1;
        }

        return userInput;
    }

    private String collectStringInput(){
        String userString;

        keyboardScanner = new Scanner(System.in);
        userString = keyboardScanner.nextLine();

        return userString;
    }

    private boolean isInputValid(int input, int lowestNum, int highestNum){
        return input <= highestNum && input >= lowestNum;
    }

    private void saveToFilePrompts(Board gameBoard){
        boolean didFileSave;

        printMessage(fileSavePrompt);
        didFileSave = gameBoard.saveTofile(collectStringInput());

        while (!didFileSave){
            printMessage(fileSaveError);
            printMessage(fileSavePrompt);
            didFileSave = gameBoard.saveTofile(collectStringInput());
        }
    }

    private void printMessage(String stringToPrint){
        System.out.print(stringToPrint);
    }

    /**
     * Prints the winner or tie message depending on what is passed into 
     * the winner parameter
     * @param winner Passed from main to be checked. Will be considered a tie
     * if it is -1. Otherwise will cause method to print a winning message for players 1 or 2.
     */
    public void printWinner(int winner){
        if (winner == -1){
            printMessage(tieString);
        }else{
            printMessage(winnerString + "Player" + winner + "");
        }
    }

    /**
     * Prints at a point where the user wants to load a file that either
     * does not exist, is not valid or cannot be opened.
     */
    public void printFileReadError(){
        printMessage(fileReadError);
    }
}