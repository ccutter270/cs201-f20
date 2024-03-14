/****************************

Caroline Cutter
Lab 1
Monday, September 14th, 2020

****************************/



// Imports
import java.util.Scanner;



// Class definition
class Lab1{


	public static void main(String[] args){

  // Hello World print line
  System.out.println("Hello, world!");

  // Asks user for name
  System.out.println("Enter your name: ");

  // Takes input of users name & converts to string
  Scanner sc = new Scanner(System.in);
  String name = sc.nextLine();


  // Prints out Hello + name input
  System.out.printf("Hello, %s!\n", name);

	}


}
