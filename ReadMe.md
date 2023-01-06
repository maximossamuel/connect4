# Connect Four

This is a Connect Four game meant for two players.

## Description

This ConnectFour game was written using Object-Oriented programming. There are 3 main classes. The Board class handles the tokens on the
board and is responsible for changing them when needed. TextUI handles all the output and input. ConnectFour contained the main method
that ran the game and kept track of things like how many turns had been done and who's turn it was. 

## Getting Started

### Dependencies

* Have the latest versions of java and gradle installed on your machine before attempting to run this program



### Executing program

* Open a terminal (powershell in windows, terminal on mac, etc)

* Navigate to the folder 'A2' containing the build.gradle file

* Input..

```
gradle build
```

* It should say 'build successful'. After that, input.. 

```
gradle run
```

* You should find the command that runs the program. It should look like...

```
java -cp build/classes/java/main connectfour.ConnectFour
```

* Copy and paste into the command line. The program should run.


## Author Information

Maximos Samuel
maximos@uoguelph.ca

## Development History

* 1.0
    * Added test cases
* 0.9
    * Added inline comments
* 0.8
    * Added JavaDocs
* 0.7
    * Added load and save from file functionality
    * Added winner/tie messages at the end of the game
* 0.6
    * Error handling done on game input
* 0.5
    * Adjusted program to work with a 2D array instead of an ArrayList
        * Modifications done on all methods in Board class
    * Finished checkWinner method
    * Created print methods within TextUI
* 0.4
    * Inserting into columns "works" but program throws errors due to reaching indexes out of bounds
* 0.3
    * Working check of inputs not between 1 and 7
    * TextUI Class
        * moved checkInput method to TextUI from Board
* 0.2
    * ConnectFour Class
    * added setPlayer method
    * added setPlayer method
        * started main
            * program now prints board
            * program now takes in user input
            * program now switches players
    * TextUI Class
        * moved printBoard method to TextUI from ConnectFour
        * added turn method
        * added printPlayerTurnMessage method
        * added collectInput method
* 0.1
    * 
    * Board Class
        * added initializeBoard method
        * added checkInput method
        * added updateBoard method
        * added checkBoardToken method
        * added checkWinner method  
    * ConnectFour Class
        * added printBoard method
    

## Acknowledgments

Inspiration, code snippets, etc.
* [awesome-readme](https://github.com/matiassingers/awesome-readme)
* [simple-readme] (https://gist.githubusercontent.com/DomPizzie/7a5ff55ffa9081f2de27c315f5018afc/raw/d59043abbb123089ad6602aba571121b71d91d7f/README-Template.md)



