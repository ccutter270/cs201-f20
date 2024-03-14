/*******************************
Caroline Cutter
Homework 1
Problem 3: Number of Properties
*******************************/

// Imports
import java.util.Scanner;
import java.lang.*;
import java.lang.Math;



// Class definition
class NumProps{

  // Main Method
  public static void main(String[] args){

    // Processes start value
    System.out.println("Start: ");
    Scanner first = new Scanner(System.in);
    int start = first.nextInt();

    // Processes stop value
    System.out.println("Stop: ");
    Scanner second = new Scanner(System.in);
    int stop = second.nextInt();

    // Processes step value
    System.out.println("Step: ");
    Scanner third = new Scanner(System.in);
    int step = third.nextInt();

    //Print out top line
    System.out.print("Num\tEven\tPrime\tSquare\tTriangular\n");


    //Print out true or false for each number & category
    while(start <= stop){

      String stringStart = Integer.toString(start);
      System.out.print(stringStart + "\t");
      isEven(start);
      isPrime(start);
      isSquare(start);
      isTriangular(start);


      start = start + step;

    }
  }


//METHODS SECTION


  // isEven() method
  public static void isEven(int number){

    //
    boolean bool = (number%2 == 0);
    System.out.print(Boolean.toString(bool) + "\t");

  }




  // isPrime() method
  public static void isPrime(int number){

    int possibleDivisors = number-1;

    //1 is not a prime number
    if (number == 1) {
      System.out.print("false\t");
      return;
    }


    //Checks if there are any dividors of the number, if there is print true
    while (possibleDivisors > 1){

      if (number%possibleDivisors == 0){
        System.out.print("false\t");
        return;
      }
      possibleDivisors--;
    }

    //if no dividors, its prime
    System.out.print("true\t");

  }




  // isTriangular() method
  // number can only be triangular if 8x+1 is a percect square
  // n(n+1)/2 = x --> 2x= n^2 + n
  public static void isTriangular(int number){

    int newNum = (8*number) + 1;

    //checking if newNum is a square
    double trueSquareRoot = Math.sqrt(newNum);
    double floorSquareRoot = Math.floor(trueSquareRoot);


    //printing out boolean value as string
    boolean bool = (trueSquareRoot == floorSquareRoot);
    System.out.print(Boolean.toString(bool) + "\t\n");

  }





  // isSquare() method
  public static void isSquare(int number){

    //checking if squares are perfect squares
    double trueSquareRoot = Math.sqrt(number);
    double floorSquareRoot = Math.floor(trueSquareRoot);

    //printing out boolean value as string
    boolean bool = (trueSquareRoot == floorSquareRoot);
    System.out.print(Boolean.toString(bool) + "\t");

  }

}
