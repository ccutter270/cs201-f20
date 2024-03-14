/******************************

Lecture 7: Recursion
Wednesday, September 23, 2020

********************************/



/********************************************************
Notes:
  - On OneDrive
**********************************************************/



//imports
import java.lang.Math;



class Recursion{


//METHODS

//Factorial()
  public int Factorial(int n){

    // Base case = 0! = 1
    // Recursive Classes = n! = (n-1)! * n

    //Base
    if(n ==0){
      return 1;
      }
    //Recursive
    else{
      return Factorial(n-1) * n;
      }
    }


//Square()
  public int Square(int n){

    //Base Case = 0^2 = 0
    //Recursive Case = n^2 = (n-1)^2 + 2n - 1

    //Base
    if(n==0){
      return 0;
      }
    //Recursive
    else{
      return Square(n-1) + 2*n - 1;
      }
  }

//calcFibonacci()
 public int calcFibonacci(int n){

    //Base Case --> n=1 & n=2 = 0
    // Recursive case = n = fib(n-1) + fib (n-2)

    //Base
    if( n == 1 || n == 2){
      return 1;
      }
    //Recursive
    else{
      return calcFibonacci(n-1) + calcFibonacci(n-2);
      }
    }
}


class Lecture7{

  public static void main(String[] args){

      Recursion rec = new Recursion();


      System.out.println(rec.Factorial(5));
      System.out.println(rec.Square(5));

      int n = 7;
      int result = rec.calcFibonacci(n);
      System.out.printf("Fibonacci %d: %d\n", n, result);
  }


}
