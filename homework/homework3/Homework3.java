/******************************************************************************
Caroline Cutter
Homework 3: Connect Four
Friday, October 2, 2020

Explaination:

  This is a game of ConnectFour that uses 3 classes - ConnectFour, Player, and
  Homework 3. The ConnectFour class creates a board, Prints the board, and
  decides when player one or player two has won the game. The ConnectFour class
  contains the method to play the game (named "playGame()") which uses functions
  from the Player class to play. These functions include getting an input,
  marking that input on the board, and storing previous inputs. The game ends
  when one of the players gets four of there markers in a row (horizontal,
  vertical or diagonal) or if the board is full and there is a tie game.
*******************************************************************************/


// IMPORTS
import java.util.Scanner;
import java.lang.*;
import java.util.Arrays;
import java.util.Vector;





//Connect Four Class
class ConnectFour{


  //ATTRIBUTES
  public String[][] gameboard = {
    {"-", "-", "-", "-", "-", "-", "-"},
    {"-", "-", "-", "-", "-", "-", "-"},
    {"-", "-", "-", "-", "-", "-", "-"},
    {"-", "-", "-", "-", "-", "-", "-"},
    {"-", "-", "-", "-", "-", "-", "-"},
    {"-", "-", "-", "-", "-", "-", "-"},
    {"0", "1", "2", "3", "4", "5", "6"},
    };
  public boolean gameTie;
  public boolean gameWon;
  public int totalMoves;
  public boolean playerOneWon;
  public boolean playerTwoWon;
  public Vector<Integer> previousMoves;
  public Player player;

  //CONSTRUCTOR
  ConnectFour(){
    player = new Player();
    gameTie = false;
    gameWon = false;
    playerOneWon = false;
    playerTwoWon = false;
  }



  //METHODS

  //playGame() -- plays game until wins/tie game, calls methods from classes
  public void playGame(){

    //While game not won/tied - print board, get input, place marker, check won
    while (gameWon == false && gameTie == false){
      printGameboard();
      player.getInput();
      player.placeMarker(gameboard);
      gameWon();
      }

    //Print final board
    printGameboard();

    //If game tied
    if (gameTie == true){
      System.out.print("Tied Game.\n");
      }

    //If game won
    if (gameWon == true){
      //Player 1
      if (playerOneWon == true){
        System.out.print("\nPlayer 1 won the game!\n\n");
        }
      //Player 2
      if (playerTwoWon == true){
        System.out.print("\nPlayer 2 won the game!\n\n");
        }
      }



  }

  /*
  gameWon() -- comments explaining throughout... first updates previous moves
  and total moves, then checks each move (if they are in bounds to be checked)
  for a horizontal, vertical, front diagonal and back diagonal win, also
  determines which player won or if they tied
  */
  public void gameWon(){

    //Update previous moves & total moves
    previousMoves = player.getMoves();
    totalMoves = player.totalMoves;
    System.out.print("\n\n\n");

    //If there are enough moves for a winner -
    if (totalMoves >= 7){

      //For each previous move
      for (int i = 0; i <= (previousMoves.size()-1); i+=2){
        String[] possibleWins = new String[4];
        int index = 0;
        int diagonalIter;
        int row = previousMoves.get(i);
        int col = previousMoves.get(i+1);
        String[] playerOne = {"X", "X", "X", "X"};
        String[] playerTwo = {"O", "O", "O", "O"};

        //Check horizontal -- only checks in bounds of board
        if (col<=3){
          //Checks from index to four right of index
          for(int iter1 = col; iter1<col+4; iter1++){
            possibleWins[index] = gameboard[row][iter1];
            index++;
            }
          //If player one won
          if (Arrays.equals(possibleWins, playerOne)){
            playerOneWon = true;
            gameWon = true;
            }
          //If player 2 won
          if (Arrays.equals(possibleWins, playerTwo)){
            playerTwoWon = true;
            gameWon = true;
            }
          }


        //Check Vertical -- has to be between 3 & 5 to check upwards
        index = 0;
        if (row>=3 && row<=5){
          //Checks from index to four above
          for(int iter2 = row; iter2>row-4; iter2--){
            possibleWins[index] = gameboard[iter2][col];
            index++;
            }
          //If player one won
          if (Arrays.equals(possibleWins, playerOne)){
            playerOneWon = true;
            gameWon = true;
            }
          //If player two won
          if (Arrays.equals(possibleWins, playerTwo)){
            playerTwoWon = true;
            gameWon = true;
            }
          }


        //Check Diagonal (like this --> /) -- checks in bounds
        index = 0;
        diagonalIter = row;
        //Checks from index to 4 diagonal (like this /) of index
        if (row >= 3 && row <= 5 && col <= 3){
          for (int iter3 = col; iter3 < col+4; iter3++){
            possibleWins[index] = gameboard[diagonalIter][iter3];
            index++;
            diagonalIter--;
          }
          //If player one won
          if (Arrays.equals(possibleWins, playerOne)){
            playerOneWon = true;
            gameWon = true;
            }
          //If player Two Won
          if (Arrays.equals(possibleWins, playerTwo)){
            playerTwoWon = true;
            gameWon = true;
            }
          }


        //Back Diagonal (like this \) -- check in bounds
        index = 0;
        diagonalIter = row;
        //Checks from index to 4 diagonal (like this \) of index
        if (row >= 3 && row <= 5 && col >= 3 && col <= 6){
          for (int iter4 = col; iter4 > col-4; iter4--){
            possibleWins[index] = gameboard[diagonalIter][iter4];
            index++;
            diagonalIter--;
            }
          //If player 1 won
          if (Arrays.equals(possibleWins, playerOne)){
            playerOneWon = true;
            gameWon = true;
            }
          //If player 2 won
          if (Arrays.equals(possibleWins, playerTwo)){
            playerTwoWon = true;
            gameWon = true;
            }
          }

        }
      }

    //If game is tied (checks after game won in case won on last move)
    if (totalMoves == 42){
      gameTie = true;
      }

  }



  //printGameboard() -- prints current gameboard
  public void printGameboard(){

    for(int row = 0; row < 7; row++){
      for(int col = 0; col < 7; col++ ){
        System.out.printf(gameboard[row][col] + "\t");
        }
        System.out.printf("\n");
      }
    }


}



class Player{

  //ATTRIBUTES
  public Vector<Integer> previousMoves= new Vector<Integer>(2);
  public int totalMoves;
  public int currentCol;
  public int currentRow;
  public boolean playerOneTurn;


  //CONSTRUCTOR
  Player(){
    totalMoves = 0;
    playerOneTurn = true;
  }


  //METHODS

  /*
  getInput() -- Eses Scanner to get a column for the user, if it is not
  a valid column number then ask until a valid column is entered
  */
  public void getInput(){

    //Prints out whose turn it is
    if (playerOneTurn == true){
      System.out.print("\nPlayer 1's Turn!\n\n");
    }
    else{
      System.out.print("\nPlayer 2's Turn!\n\n");
    }

    //Ask user for input
    System.out.printf("Enter a column:  ");
    Scanner sc = new Scanner(System.in);
    currentCol = sc.nextInt();

    //Check if valid column
    if (currentCol < 0 || currentCol > 6){
      System.out.print("Not a valid column. \n");
      getInput();
      }
    }


  /*
  placeMarker() -- Updates the board with the correct player marker, asks for
  a new column if it is full, updates the moves list with the new coordinates
  in the gameboard array
  */
  public void placeMarker(String[][] gameboard){
    boolean markerPlaced = false;

    while (markerPlaced == false){
      String possibleSlots = "";
      //Checks possible slots
      for(int row = 0; row <= 5; row++){
        possibleSlots += gameboard[row][currentCol];
      }

      //Finds lowest slot
      currentRow = possibleSlots.lastIndexOf("-");

      //If column is full
      if (currentRow == -1){
        System.out.print("\nColumn is full!\n");
        getInput();
        }

      //If column has space
      else{

        //If its player 1's turn
        if (playerOneTurn == true){
          gameboard[currentRow][currentCol] = "X";
          //previousMoves.add(currentRow, ).add(current)
          playerOneTurn = false;
          }
        //If its player 2's turn
        else{
          gameboard[currentRow][currentCol] = "O";
          playerOneTurn = true;
          }
        markerPlaced = true;
        totalMoves += 1;
        previousMoves.add(currentRow);
        previousMoves.add(currentCol);

        }
      }
    }



  //getMoves -- returns the vector of previous moves (used for ConnectFour Class)
  public Vector<Integer> getMoves(){
    return previousMoves;
  }


}



class Homework3{

  //MAIN METHOD
  public static void main(String[] args){


    //Creates Instances of the classes ConnectFour and Player
    ConnectFour cf = new ConnectFour();
    Player player = new Player();

    //Plays game
    cf.playGame();

    }
  }
