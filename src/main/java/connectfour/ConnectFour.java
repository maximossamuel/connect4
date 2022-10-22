package connectfour;

/**
 * Containes the main method that runs the game and 
 * keeps track of things like how many turns have been 
 * done and who's turn it is.
 * @author Maximos Samuel
 */
public class ConnectFour{

    /*
     *currentPlayer set to 2 so that it will switch to 1 when game begins
    */
    private int currentPlayer = 2;

    /**
     * The main method. Program runs off what is contained in it.
     * @param args Essential for main methods
     */
    public static void main(String[] args){
        Board gameBoard = new Board();
        TextUI gameUI = new TextUI();
        ConnectFour game = new ConnectFour();
        String filename = gameUI.loadFromFilePrompts();
        int depth = 0;

        /*
         * Opening a file option. Program will shut down if there is an error opening
         * the desired file
         */
        if (filename != null){
            depth = gameBoard.openFile(filename);

            if (depth == -1){
                gameUI.printFileReadError();
                return;
            }else{
                game.setTurnFromFile(depth);
            }
        }

        /*
         * Main gameplay. Printing of gameboard and handling of each turn.
         */
        while (gameBoard.checkWinner() == -1 && depth < 42){
            gameUI.turn(game.getPlayer(), gameBoard);
            depth++;
        }

        gameUI.endOfGameMessage(gameBoard);
    }

    /*
     * Switches the value of currentPlayer
    */
    private int setPlayer(){
        if (currentPlayer == 1){
            currentPlayer = 2;
        }else{
            currentPlayer = 1;
        }

        return currentPlayer;
    }

    /**
     * Accessor method for the player who's turn it currently is
     * @return Returns the number of the player who has the current turn
     */
    public int getPlayer(){
        return setPlayer();
    }

    /**
     * Adjusts the currentPlayer after loading a file based on how
     * far into the game the saved game is.
     * @param depth If the depth of the game is even, it will be made so that it
     * will be player 1's turn. If odd, player 2
     */
    public void setTurnFromFile(int depth){
        if (depth % 2 == 0){
            currentPlayer = 2;
        }else{
            currentPlayer = 1;
        }
    }
}
