/*****************************
Caroline Cutter
Homework 1
Problem 2: Quadradic Equation
*******************************/

// Imports
import java.util.Scanner;
import java.lang.*;
import java.lang.Math;



// Class definition
class QuadEq{

  // Main Method
  public static void main(String[] args){

    // Variables as atribiutes of the class

    // Processes a
    System.out.println("a: ");
    Scanner first = new Scanner(System.in);
    double a = first.nextDouble();

    // Processes b
    System.out.println("b: ");
    Scanner second = new Scanner(System.in);
    double b = second.nextDouble();

    // Processes c
    System.out.println("c: ");
    Scanner third = new Scanner(System.in);
    double c = third.nextDouble();


    // Calls methods
    System.out.print(toString(a,b,c));
    solve(a,b,c);

  }




  // toString() method
  public static String toString(double a, double b, double c){

    String aString = Double.toString(a);
    String bString = Double.toString(b);
    String cString = Double.toString(c);

    String equation = aString + "x^2 + " + bString + "x + " + cString + " = 0\n";

    return(equation);
  }


  // solve() method
  public static void solve(double a, double b, double c){

    double root1 = (-b + Math.sqrt(Math.pow(b, 2) - 4*a*c)) / 2*a;
    double root2 = (-b - Math.sqrt(Math.pow(b, 2) - 4*a*c)) / 2*a;

    System.out.printf("The roots of this equation are %f and %f \n", root1, root2);

  }


}
