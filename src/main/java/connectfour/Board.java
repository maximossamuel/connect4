package connectfour;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;

public class Board{
    private int[][] data = {{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}};

    public int openFile(String filename){
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("assets/" + filename));
            return fileToBoard(fileReader);
        } catch (Exception e) {
            return -1;
        }
    }

    private int fileToBoard(BufferedReader file){
        int numP1Moves = 0;
        int numP2Moves = 0;

        for (int i = 0; i < 6; i++){
            try {
                String[] tokens = file.readLine().split(",");
                for (int j = 0; j < 7; j++){
                    data[i][j] = Integer.parseInt(tokens[j]);
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

        if ((numP1Moves != numP2Moves + 1) && (numP1Moves != numP2Moves)){
            return -1;
        }

        return isFileValid();
    }

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

    public boolean saveTofile(String filename){
        try {
            File newFile = new File("assets/" + filename + ".csv");
            if (newFile.createNewFile()){
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

    private int checkBoardToken(int input){
        for (int i = 5; i >= 0; i -= 1){
            if (data[i][input - 1] == 0){
                return i;
            }
        }

        return -1;
    }

    public boolean updateBoard(int input, int player){
        int tokenIndexToBeUpdated = checkBoardToken(input);
        
        if (tokenIndexToBeUpdated != -1){
            data[tokenIndexToBeUpdated][input - 1] = player;
            return true;
        }else{
            return false;
        } 
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
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

/* this is a do-nothing method that was put here only so 
you could have an example of junit testing.  Once you have other
methods in the Board class and other tests you should delete
this method and this comment */
    public int returnSomething(){
        return 1;
    }

    

}