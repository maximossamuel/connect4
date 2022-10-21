package connectfour;

public class ConnectFour{
    private Board gameBoard = new Board();

    private void printBoard(int[][] Board.data){
        for (int i = 0; i < 6; i++){
            System.out.println("+---+---+---+---+---+---+---+");
            System.out.print("|");
            for (int j = 0; j < 7; j++){
                System.out.printf(" %d |", data[j][i]);
            }
            System.out.print("\n");
        }
        System.out.println("+---+---+---+---+---+---+---+");
    }
}