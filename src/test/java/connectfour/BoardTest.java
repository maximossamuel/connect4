package connectfour;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/* you will need to add test methods and likely change the
setup method as well.  The samples that are here are just so that
you can see how junit works.

Tests are run on build unless specifically excluded with -x test.
The test results are reported in the reports subfolder of the build directory */


public class BoardTest{
    private Board tester;

    @Before
    public void setup(){
        //set up for the test
        tester = new Board();

    }

    @Test

    public void invalidFileOpenTest(){
        /*
         * Testing the opening of an invalid file, also tests fileToBoard and isFileValid
         */
        Assert.assertEquals(tester.openFile("exampleboard2.csv"), -1);
    }

    @Test

    public void validFileOpenTestAndUpdateFullColumn(){
        /*
         * Testing the opening of a valid file. Then an attempt to insert token into a full column. 
         * Then tests inserting into a not-full column. Also tests fileToBoard, checkBoardToken and isFileValid
         */
        Assert.assertEquals(tester.openFile("exampleboard3.csv"), 31);
        Assert.assertEquals(tester.updateBoard(1, 1), false);
        Assert.assertEquals(tester.updateBoard(2, 1), true);
    }

    @Test

    public void failedSaveToFile(){
        /*
         * Testing the saving to a file that already exists
         */
        Assert.assertEquals(tester.saveTofile("exampleboard"), false);
    }

    @Test

    public void tieTesting(){
        /*
         * Testing loading a completed game and declaring a tie
         */
        Assert.assertEquals(tester.openFile("exampleboard5.csv"), 42);
        Assert.assertEquals(tester.checkWinner(), -1);
    }

    @Test
    public void diagonalWinTest(){
        /*
         * Testing loading a completed game and delcaring a diagonal win for 1
         */
        Assert.assertEquals(tester.openFile("exampleboard6.csv"), 16);
        Assert.assertEquals(tester.checkWinner(), 1);
    }

    @Test

    public void horizontalWinTest(){
        /*
         * Testing loading a completed game and declaring a horizontal win for 2
         */
        Assert.assertEquals(tester.openFile("exampleboard7.csv"), 14);
        Assert.assertEquals(tester.checkWinner(), 2);
    }

    @Test

    public void verticalWinTestAndBoardString(){
        /*
         * Testing loading a completed game and declaring a vertical win for 2.
         *  Also tests the board string to see if it returns properly. 
         */

        String boardStringExpected = "| 1 | 2 | 3 | 4 | 5 | 6 | 7 |\n" 
        + "+---+---+---+---+---+---+---+\n+---+---+---+---+---+---+---+\n" 
        + "| 0 | 0 | 0 | 0 | 2 | 0 | 0 |\n+---+---+---+---+---+---+---+\n" 
        + "| 0 | 0 | 0 | 0 | 2 | 0 | 0 |\n+---+---+---+---+---+---+---+\n" 
        + "| 0 | 0 | 0 | 0 | 2 | 0 | 0 |\n+---+---+---+---+---+---+---+\n" 
        + "| 0 | 0 | 0 | 2 | 2 | 0 | 0 |\n+---+---+---+---+---+---+---+\n" 
        + "| 0 | 0 | 1 | 2 | 1 | 0 | 1 |\n+---+---+---+---+---+---+---+\n" 
        + "| 1 | 1 | 1 | 2 | 1 | 2 | 1 |\n+---+---+---+---+---+---+---+\n";
        Assert.assertEquals(tester.openFile("exampleboard8.csv"), 16);
        Assert.assertEquals(tester.checkWinner(), 2);
        Assert.assertEquals(tester.toString(), boardStringExpected);
    }

    @Test

    public void oppositeDiagonalWin(){
        /*
         * Testing loading a completed game and declaring a diagonal win for 
         */

         Assert.assertEquals(tester.openFile("exampleboard9.csv"), 11);
         Assert.assertEquals(tester.checkWinner(), 1);
    }
}