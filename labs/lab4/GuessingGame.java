/******************************

Lab 4: The Guessing Game
Monday, October 5, 2020

********************************/


import java.util.Scanner;
import java.util.Vector;
import java.util.Random;


class GuessingGame{


  public static void main(String[] args){

    Vector<Integer> previousGuesses = new Vector<Integer>();
    Vector<Integer> previousAnswers = new Vector<Integer>();
    int totalCorrect = 0;
    int totalAttempts = 0;
    boolean playAgain = true;
    boolean validResponse = false;
    Random random = new Random();


    do{

      //Make Random Number
      int currentAnswer = random.nextInt(10) + 1;
      previousAnswers.add(currentAnswer);


      //Get Guess
      System.out.printf("Guess a number between 1 and 10:  ");
      Scanner sc = new Scanner(System.in);
      int currentGuess = sc.nextInt();
      previousGuesses.add(currentGuess);

      //Reply back
      totalAttempts++;

      if (currentGuess == currentAnswer){
        System.out.print("You guessed the correct number!\n");
        totalCorrect++;
        }
      else{
        if ((currentGuess+1 == currentAnswer) || (currentGuess-1 == currentAnswer)){
          System.out.printf("You were close! The correct answer was %d.\n", currentAnswer);
          }
        else{
          System.out.printf("Sorry. The correct answer was %d.\n", currentAnswer);
          }
        }

      //Play Again?
      validResponse = false;

      System.out.printf("Play Again? (y/n):  ");
      Scanner sc2 = new Scanner(System.in);
      String play = sc2.next();

      if (play.equals("y") || play.equals("Y")){
        playAgain = true;
        validResponse = true;
        }

      if (play.equals("n") || play.equals("N")){
        playAgain = false;
        validResponse = true;
        }


    } while(playAgain == true);

    //Print Summary
    System.out.print("\n\nSummary\n");
    System.out.printf("You guessed the correct number %d out of %d times!\n", totalCorrect, totalAttempts);
    for(int iter = 0; iter < previousGuesses.size(); iter++){
      System.out.printf("Guess: %d\t", previousGuesses.get(iter));
      System.out.printf("Answer: %d\n", previousAnswers.get(iter));
    }
    System.out.print("\n\n\n");



  }


}
