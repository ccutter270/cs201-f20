/******************************************************************************
Caroline Cutter
Homework 2: Battleship
Friday, September 25, 2020

This is modeled after the 2002 version of battleship.There is a class named
Battleship which contains all the functions of the the game. When Battleship is
created as an instance of the classes "Homework2," the game will automatically
begin playing. A random board is created with 5 ships of different lengths.
There are unlimited attempts to guess where the 5 ships are located. The board
is updated and shown after every guess with hits marked as x and misses marked
as o. Once the locations are all guessed, the game will end and tell you how
many attempts it took.

You can terminate the game by typing "/ex" when prompted for a coordinate.
******************************************************************************/


// Imports
import java.util.Scanner;
import java.lang.*;
import java.util.Random;
import java.util.Arrays;


// Battleship Class
class Battleship{


  //Attributes
  public int numAttempts;
  public boolean gameWon;
  public char[] currentCoord;
  public String coordString;
  public int[] indexOfCoord;
  public int[] shipLengths;
  public String[][] playerBoard =  {
    {" ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"},
    {"A", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"B", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"C", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"D", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"E", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"F", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"G", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"H", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"I", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"J", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    };
  public String[][] playerHitBoard =   {
    {" ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"},
    {"A", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"B", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"C", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"D", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"E", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"F", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"G", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"H", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"I", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"J", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    };
  public String[][] gameBoard = {
    {" ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"},
    {"A", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"B", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"C", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"D", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"E", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"F", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"G", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"H", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"I", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"J", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    };


//Constructor - declares all value & plays game
  Battleship(){
    System.out.print("Test");
    numAttempts = 0;
    gameWon = false;
    currentCoord = new char[]{'0', '0'};
    coordString = "";
    indexOfCoord = new int[]{0,0};
    shipLengths = new int[]{5, 4, 3, 3, 2, 1};
    playGame();

    }




// METHODS

//setShips() = randomly places ships in array gameBoard as "X"
  public void setShips(){
    /*
    Generates random ship by first randomly generating if horizontal
    or vertical, then randomly places them along the board
    */

    Random random = new Random();
    int lenShip;
    boolean shipPlaced = false;


    //For Each Ship
    for (int iter = 0; iter < 6; iter++){
      shipPlaced = false;
      lenShip = shipLengths[iter];

      //Repeat until ship is placed
      while (shipPlaced == false){

        //Orientation of ship (0 = horizontal, 1 = vertical)
        int direction = random.nextInt(2);


        // HORIZONTAL
        if (direction == 0){

          //Random start index
          int col = random.nextInt(11-lenShip) + 1; //this makes sure boat won't go off edge
          int row = random.nextInt(10)+ 1;

          //Array of possible slots
          String[] possibleSlot = Arrays.copyOfRange(gameBoard[row],col, col+lenShip);


          //Checking if slots are available
          if (Arrays.asList(possibleSlot).contains("X")){
            //Overlap - do nothing, wait for loop to restart
            }
          //Slots available - fill them in wiht "X"
          else{
            for(int iter2 = col; iter2 < (col+lenShip); iter2++){
              gameBoard[row][iter2] = "X";
              }
            shipPlaced = true;
            }
          }


        //VERTICAL BOATS
          if (direction == 1){

            //Random Start Coordinate
            int row = random.nextInt(11-lenShip) + 1;
            int col = random.nextInt(10)+ 1;

            //Creating blank array, then array to see if slots are available
            String[] possibleSlots = {" ", " ", " ", " ", " "," ", " ", " ", " ", " ", " ", " "}; //12 for each possible spot on board
            for(int iter2 = row; iter2 < (row+lenShip); iter2++){
              possibleSlots[iter2] = gameBoard[iter2][col];
              }

            //Check if slots are taken
            if (Arrays.asList(possibleSlots).contains("X")){
              //Overlap - Do nothing, wait for loop to repeat
              }
            //Slots available - fill them in wiht "X"
            else{
              for (int iter3 = row; iter3 < (row+lenShip); iter3++){
                gameBoard[iter3][col] = "X";
                }
              shipPlaced = true;
              }
            }
          }
        }
      }


//printPlayerBoard() = prints player board when called
  public void printPlayerBoard(){

    for(int row = 0; row < 11; row++){
      for(int col = 0; col <11; col++ ){
        System.out.printf(playerBoard[row][col] + "\t");
        }
        System.out.printf("\n");
      }
    }


//askCoord() = Ask for input
  public void askCoord(){
    //gets coord from user
    System.out.printf("Enter a coordinate: \n");
    Scanner sc = new Scanner(System.in);
    coordString  = sc.next();

    //Optional things
    // Exit if /ex
    if (coordString.equals("/ex")){
      System.exit(0);
    }
    //Check valid (only for 2 spaces)
    if (coordString.length() != 2){
      System.out.print("Not a valid coordinate. \n");
      askCoord();
      }
    }


//coordToIndex() = Takes coordinate input, turns to board on the board
  public void coordToIndex(){

    //Changing coordString into array for indexing
    currentCoord[0]= Character.toLowerCase(coordString.charAt(0));
    currentCoord[1]= coordString.charAt(1);

    //Changing number to number index
    indexOfCoord[1] = (Character.getNumericValue(currentCoord[1])+1);

    //Changing letter to index
    if (currentCoord[0] =='a'){
      indexOfCoord[0] = 1;
      }
    if (currentCoord[0] == 'b'){
      indexOfCoord[0] = 2;
      }
    if (currentCoord[0] == 'c'){
      indexOfCoord[0] = 3;
      }
    if (currentCoord[0] == 'd'){
      indexOfCoord[0] = 4;
      }
    if (currentCoord[0] =='e'){
      indexOfCoord[0] = 5;
      }
    if (currentCoord[0] == 'f'){
      indexOfCoord[0] = 6;
      }
    if (currentCoord[0] == 'g'){
      indexOfCoord[0] = 7;
      }
    if (currentCoord[0] =='h'){
      indexOfCoord[0] = 8;
      }
    if (currentCoord[0] == 'i'){
      indexOfCoord[0] = 9;
      }
    if (currentCoord[0] == 'j'){
      indexOfCoord[0] = 10;
      }
    }


//hitShip() = prints hit or miss; changes guess on players board to o or x, prints board
  public void hitShips(){

    //If guess was already guessed  (will count towards guesses)
    if (playerBoard[indexOfCoord[0]][indexOfCoord[1]].equals("o") || playerBoard[indexOfCoord[0]][indexOfCoord[1]].equals("x")){
      System.out.print("Location already attempted.\n");
      }
    //Miss
    if (gameBoard[indexOfCoord[0]][indexOfCoord[1]].equals("-")){
      System.out.print("\nMiss.\n\n");
      playerBoard[indexOfCoord[0]][indexOfCoord[1]] = "o";
      }
    //Hit
    if (gameBoard[indexOfCoord[0]][indexOfCoord[1]].equals("X")){
      System.out.print("\nHit!\n\n");
      playerBoard[indexOfCoord[0]][indexOfCoord[1]] = "x";
      playerHitBoard[indexOfCoord[0]][indexOfCoord[1]] = "X";
      }
      printPlayerBoard();
    }


//gameWon() = decides if game is won, if it is, sets gameWon variable to true
  public void gameWon(){
    if(Arrays.deepEquals(gameBoard, playerHitBoard)){
      gameWon = true;
      System.out.print("You won the game!\n");
      System.out.printf("It took %d guesses.\n", numAttempts);
    }
  }


//playGame() = puts all the methods together to play game until game is won
  public void playGame(){
    // Creates & prints board
    setShips();
    printPlayerBoard();
    //While game is not won, keep asking for coordinates
    while (gameWon == false){
      numAttempts++;
      askCoord();
      coordToIndex();
      hitShips();
      gameWon();
    }
  }


}







// Homework class
class Homework2{

  //MAIN METHOD
      public static void main(String[] args){
        //Instance of Battleship class in main
        Battleship main = new Battleship();
        }
}
