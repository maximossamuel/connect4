# CIS*2430 A2: Connect Four

This is a Connect Four game meant for two players.

## Description

An in-depth paragraph about your project and overview of use.

## Getting Started

### Dependencies

* Describe any prerequisites, libraries, OS version, etc., needed before installing and running your program.



### Executing program

* How to build and run the program
* Step-by-step bullets
```
use code blocks for commands
```
* include the expected output

## Limitations

What isn't done? What things cause errors?  

## Author Information

Maximos Samuel
maximos@uoguelph.ca

## Development History

Keep a log of what things you accomplish when.  You can use git's tagging feature to tag the versions or you can reference commits.

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



