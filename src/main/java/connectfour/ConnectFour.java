package connectfour;

public class ConnectFour{

    private int currentPlayer = 2;

    public static void main(String[] args){
        Board gameBoard = new Board();
        TextUI gameUI = new TextUI();
        ConnectFour game = new ConnectFour();
        int depth = 0;
        int userInput;

        gameBoard.initializeBoard();

        while (gameBoard.checkWinner() == -1 && depth < 42){
            userInput = gameUI.turn(game.getPlayer(), gameBoard.toString());
            depth++;
        }

    }

    private int setPlayer(){
        if (currentPlayer == 1){
            currentPlayer = 2;
        }else{
            currentPlayer = 1;
        }

        return currentPlayer;
    }

    public int getPlayer(){
        return setPlayer();
    }

}