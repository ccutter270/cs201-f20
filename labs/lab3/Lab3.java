/******************************

Lab 3: Recursion
Monday, September 28, 2020

********************************/

//Imports
import java.util.Scanner;


//Contains the recursive methods
class Recursion{




  //METHODS

  //square() - takes in integer, returns square of number using recursion
  public int square(int n){
    //Base case
    if (n==0){
      return 0;
      }
    //Recursive = n^2 = (n-1)^2 + 2n - 1
    else{
      return square(n-1) + 2*n - 1;
      }
  }


  // triangular() - takes in integer, returns triangluar number using recursion
  public int triangular(int n){
    //Base case
    if (n==1){
      return 1;
      }
    //Recursive = number of triangles = n+ triangle(n-1)
    else{
      return (n + triangular(n-1));
      }
    }
}




class Lab3{

  public static void main(String[] args){

  //Instance of class
  Recursion r = new Recursion();

  //Gets input
  System.out.println("Enter an Integer: ");
  Scanner sc = new Scanner(System.in);
  int number  = sc.nextInt();


  //Uses methods to get square and triangle
  int squareNum = r.square(number);
  int triangleNum = r.triangular(number);


  //Prints out answers
  System.out.printf("The Square of %d is %d\n", number, squareNum);
  System.out.printf("The Triangle of %d is %d\n", number, triangleNum);
  }

}
