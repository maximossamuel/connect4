package connectfour;

public class ConnectFour{

    private int currentPlayer = 2;

    public static void main(String[] args){
        Board gameBoard = new Board();
        TextUI gameUI = new TextUI();
        ConnectFour game = new ConnectFour();
        String filename = gameUI.loadFromFilePrompts();
        int depth = 0;

        if (filename != null){
            depth = gameBoard.openFile(filename);

            if (depth == -1){
                gameUI.printFileReadError();
                return;
            }else{
                game.setTurnFromFile(depth);
            }
        }

        while (gameBoard.checkWinner() == -1 && depth < 42){
            gameUI.turn(game.getPlayer(), gameBoard);
            depth++;
        }

        gameUI.endOfGameMessage(gameBoard);
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

    public void setTurnFromFile(int depth){
        if (depth % 2 == 0){
            currentPlayer = 2;
        }else{
            currentPlayer = 1;
        }
    }
}