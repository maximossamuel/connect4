package connectfour;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;

/**
 * Handles the tokens on the board and is responsible for 
 * changing them when needed
 * @author Maximos Samuel
 */
public class Board{
    private int[][] data = {{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}};

    /**
     * Takes in a string for a filename, opens the file and calls the 
     * fileToBoard method with the new file variable
     * @param filename String given for the name of the file
     * @return Returns the depth of the game found within the file. This is to
     * determine who's turn it is.
     */
    public int openFile(String filename){
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("assets/" + filename));
            return fileToBoard(fileReader);
        } catch (Exception e) {
            return -1;
        }
    }

    /*
     * Takes elements from file boards and puts them into the game board
     */
    private int fileToBoard(BufferedReader file){
        int numP1Moves = 0;
        int numP2Moves = 0;

        for (int i = 0; i < 6; i++){
            try {

                /*
                 * String tokenization. Takes the commas out of the strings and puts everything inbetween the commas
                 * in an array.
                 */
                String[] tokens = file.readLine().split(",");
                for (int j = 0; j < 7; j++){

                    /*
                     * Conversion from string to int
                     */
                    data[i][j] = Integer.parseInt(tokens[j]);
                    if (data[i][j] > 2 || data[i][j] < 0){
                        return -1;
                    }

                    /*
                     * numP1Moves and numP2Moves made and used to ensure that a CSV file was not submitted where
                     * player 2 made 4 more moves than player 1 for example
                     */
                    if (data[i][j] == 1){
                        numP1Moves++;
                    }else if (data[i][j] == 2){
                        numP2Moves++;
                    }
                }
            } catch (Exception e) {
                return -1;
            }
        }

        /*
        * Check to see if the game within file is valid 
        * (e.g, if player 1 has 3 more tokens than 2, it is not valid)
        */
        if ((numP1Moves != numP2Moves + 1) && (numP1Moves != numP2Moves)){
            return -1;
        }

        return isFileValid();
    }

    /*
     * Checks to see that each column in the file does not have player tokens
     * above empty tokens on the board.
     */
    private int isFileValid(){
        int depth = 0;

        for (int i = 0; i < 7; i++){
            boolean zeroFound = false;
            for (int j = 5; j >= 0; j--){
                if (data[j][i] == 0){
                    zeroFound = true;
                }else{
                    if (zeroFound){
                        return -1;
                    }else{
                        depth++;
                    }
                }
            }
        }

        return depth;
    }

    /**
     * Saves the current game board to a file
     * @param filename Name of the file the board is being saved to
     * @return returns either true or false in  so the program can
     * have the user put in another name case the file already exists
     */

    public boolean saveTofile(String filename){
        try {
            /*
            * newFile handles the creation of a new file and prepares for the exception
            * that a file with the name in the filename string already exists
            */
            File newFile = new File("assets/" + filename + ".csv");
            if (newFile.createNewFile()){
                /*
                * Writing to file
                */
                FileWriter writer = new FileWriter("assets/" + filename + ".csv");
                for (int i = 0; i < 6; i++){
                    for (int j = 0; j < 7; j++){
                        writer.write(data[i][j] + "");
                        if (j != 6){
                            writer.write(",");
                        }else{
                            writer.write("\n");
                        }
                    }
                }
                writer.close();
                return true;
            }else{
                return false;
            }
        }catch (Exception e) {
            return false;
        }
    } 

    /*
     * Check to see that there is an empty spot in the user's desired column on the board
     */
    private int checkBoardToken(int input){
        for (int i = 5; i >= 0; i -= 1){
            if (data[i][input - 1] == 0){
                return i;
            }
        }

        return -1;
    }

    /**
     * Does all the necessary checks to see if a board token can be
     * updated and then does so. 
     * @param input The column the user inputted. Is put through a check
     * in the method to see if a user's token can be inserted into said column.
     * @param player The player who gave the input. Inserted in the function so
     * that the token can be updated to the appropriate player
     * @return Returns either true or false to see whether or not the user input
     * was an illegal input
     */
    public boolean updateBoard(int input, int player){
        int tokenIndexToBeUpdated = checkBoardToken(input);
        
        if (tokenIndexToBeUpdated != -1){
            data[tokenIndexToBeUpdated][input - 1] = player;
            return true;
        }else{
            return false;
        } 
    }

    /**
     * Puts together the string that is printed every turn to represent
     * the board
     * @return Returns the mentioned string
     */
    public String toString(){
        String boardString = "| 1 | 2 | 3 | 4 | 5 | 6 | 7 |\n";
        String rowDivider = "+---+---+---+---+---+---+---+\n";

        boardString = boardString + rowDivider;

        for (int i = 0; i < 6; i++){
            boardString = boardString + rowDivider;
            for (int j = 0; j < 7; j++){
                boardString = boardString + "| " + data[i][j] + "" + " ";
            }
            boardString = boardString + "|\n";
        }

        boardString = boardString + rowDivider;
        
        return boardString;
    }

    /**
     * Checks all possible win conditions on the board to see whether
     * or not a winner has been found.
     * @return Returns the winning player number. If not, returns -1 which
     * allows the game to keep going or call a tie if 42 plays have been
     * made.
     */
    public int checkWinner(){
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 7; j++){
                if (data[i][j] != 0){
                    /*
                     * Horizontal win
                     */
                    if ((j + 3) < 7){
                        if (data[i][j] == data[i][j + 1] && data[i][j + 1] == data[i][j + 2] 
                        && data[i][j + 2] == data[i][j + 3]){
                            return data[i][j];
                        }
                    }

                    /*
                     * Vertical win
                     */
                    if ((i + 3) < 6){
                        if (data[i][j] == data[i + 1][j] && data[i + 1][j] == data[i + 2][j] 
                        && data[i + 2][j] == data[i + 3][j]){
                            return data[i][j];
                        }
                    }

                    /*
                     * Left(up) to right(down) diagonal win
                     */
                    if ((j + 3) < 7 && (i + 3) < 6){
                        if (data[i][j] == data[i + 1][j + 1] && data[i + 1][j + 1] == data[i + 2][j + 2] 
                        && data[i + 2][j + 2] == data[i + 3][j + 3]){
                            return data[i][j];
                        }
                    }

                    /*
                     *  Left(down) to right(up) diagonal win
                     */
                    if ((j + 3) < 7 && (i - 3) >= 0){
                        if (data[i][j] == data[i - 1][j + 1] && data[i - 1][j + 1] == data[i - 2][j + 2] 
                        && data[i - 2][j + 2] == data[i - 3][j + 3]){
                            return data[i][j];
                        }
                    }
                }
            }
        }
        return -1;
    }
}
