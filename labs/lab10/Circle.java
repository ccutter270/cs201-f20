/******************************

Caroline Cutter
Lab 10: Overrides and Separate Compilation
Monday, November 16, 2020

********************************/

import java.util.Scanner;
import java.lang.Math;



public class Circle{

  //ARGUMENTS

  double length;
  int numIterations;

  //CONSTRUCTOR
  public Circle(double len, int num){

    length = len;
    numIterations = num;
  }

  //PI one
  double pi(){

    double total = 1;
    int denominator = 3;
    boolean add = false;
    for(int i = 0; i<=numIterations; i++){
      if(add == true){
        total += (double)1/denominator;
        add = false;
      }
      else{
        total -= (double)1/denominator;
        add = true;
      }

      denominator += 2;
    }

    System.out.printf("Area using method 1: %.5f\n", area(total*4));
    return total*4;
  }

  //AREA
  public double area(double pi){
    return (pi*(length*length));
  }


}
