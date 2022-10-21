package connectfour;

import java.util.ArrayList;

public class Board{
    private ArrayList<Integer> data = new ArrayList<Integer>();

    public void initializeBoard(){
        for (int i = 0; i < 42; i++){
            data.add(0);
        }
    }

    private int checkBoardToken(int input){
        for (int i = input + 35; i > 0; i -= 7){
            if (data.get(i - 1) == 0){
                return i - 1;
            }
        }

        return -1;
    }

    public boolean updateBoard(int input, int player){
        int tokenIndexToBeUpdated = checkBoardToken(input);
        
        if (tokenIndexToBeUpdated != -1){
            data.set(tokenIndexToBeUpdated, player);
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
        int j = 0;
        int i = 0;
        int limit;

        boardString = boardString + rowDivider;

        for (i = 0; i < 6; i++){
            boardString = boardString + rowDivider;
            limit = j + 7;
            while (j < (limit)){
                boardString = boardString + "| " + data.get(j) + "" + " ";
                j++;
            }
            boardString = boardString + "|\n";
        }

        boardString = boardString + rowDivider;
        
        return boardString;
    }

    public int checkWinner(){
        for (int i = 0; i < 42; i++){
            if (data.get(i) != 0){
                /*
                * Vertical win
                */
                if (data.get(i) == data.get(i + 7) && data.get(i + 7) == data.get(i + 14) 
                && data.get(i + 14) == data.get(i + 21)){
                    return data.get(i);
                }
                /*
                * Horizontal win
                */
                if (((i + 1) % 7 != 0) && ((i + 1) % 6 != 0) && ((i + 1) % 5 != 0)){
                    if (data.get(i) == data.get(i + 1) && data.get(i + 1) == data.get(i + 2) 
                    && data.get(i + 2) == data.get(i + 3)){
                        return data.get(i);
                    }
                    /*
                    * Left to right diagonal win
                    */
                    if(data.get(i) == data.get(i + 8) && data.get(i + 8) == data.get(i + 16) 
                    && data.get(i + 16) == data.get(i + 24)){
                        return data.get(i);
                    }
                }
                /*
                * Right to left diagonal win
                */
                if ((i > 2 && i < 7) || (i > 9 && i < 14) || (i > 16 && i < 21)){
                    if(data.get(i) == data.get(i + 6) && data.get(i + 6) == data.get(i + 12) 
                    && data.get(i + 12) == data.get(i + 18)){
                        return data.get(i);
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