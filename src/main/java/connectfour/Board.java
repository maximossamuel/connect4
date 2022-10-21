package connectfour;

public class Board{
    private int[][] data = {{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}};

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