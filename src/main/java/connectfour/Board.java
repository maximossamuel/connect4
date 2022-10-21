package connectfour;

import java.util.ArrayList;

public class Board{
    private ArrayList<Integer> data;

    public Board(){

    }


private void initializeBoard(){
    for (int i = 0; i < 42; i++){
        data.add(0);
    }
}

public boolean checkInput(int input, int player){
    if (input > 7 || input < 1){
        return false;
    }else{
        updateBoard(input, player);
        return true;
    }
}

private boolean updateBoard(int input, int player){
    if (checkBoardToken(input, player)){
        data.set(input, player);
        return true;
    }else{
        return false;
    } 
}

private boolean checkBoardToken(int input, int player){
    for (int i = input; i < 42; i = i + input){
        if (data.get(i) != 0){
            continue;
        }else{
            return true;
        }
    }

    return false;
}

private int checkWinner(){
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