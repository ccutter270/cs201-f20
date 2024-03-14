/******************************

Caroline Cutter
Lab 6: Error Handling
Monday, October 19, 2020

********************************/


import java.util.Scanner;
import java.lang.Math;


class Triangle{

  //ATTRIBUTES
  double sideA;
  double sideB;
  double sideC;



  //CONSTRUCTOR
  public Triangle(){
    getInput();
  }


  //METHODS

  public void getInput(){

    System.out.println("Enter the side lengths of a triangle.");

    //Input A
    try{
      System.out.print("Side A:  ");
      Scanner sc1 = new Scanner(System.in);
      sideA = sc1.nextDouble();
    } catch (Exception e){
      System.out.println("Invalid input for dimension of side.");
      return;
    }
    //Input B
    try{
      System.out.print("Side B:  ");
      Scanner sc2 = new Scanner(System.in);
      sideB = sc2.nextDouble();
    } catch (Exception e){
      System.out.println("Invalid input for dimension of side.");
      return;
    }

    //Input C
    try{
      System.out.print("Side C:  ");
      Scanner sc3 = new Scanner(System.in);
      sideC = sc3.nextDouble();
    } catch (Exception e){
      System.out.println("Invalid input for dimension of side.");
      return;
    }

    //Triangle Inequality Theory
    try{
      if(sideA >= sideB + sideC || sideB >= sideA + sideC || sideC >= sideA + sideB){
        throw  new ArithmeticException("Invalid dimensions for a triangle.");
      }
      double area = area(sideA, sideB, sideC);
      System.out.printf("\nArea of triangle is %.2f.\n", area);
    } catch (Exception e){
        System.out.println(e);
      }
  }



  public double area(double a, double b, double c){

    double s = (a+b+c)/2;
    double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));

    return area;
  }


}




class Lab6{

  public static void main(String[] args){

    Triangle triangle = new Triangle();


  }



}
