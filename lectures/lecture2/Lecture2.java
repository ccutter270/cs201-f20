/*************************************************************

Lecture 2: Data Types and Operations

Friday, September 11th

This is just the code from class, see attached notes in Day 2
***************************************************************/



/*
NOTES:


* Save & Compile before every use

public : anything can access
static: instance of the class
void: doesn't return anything
main: method name

System is a class, has methods (we call the println function of system)

*/




//imports
import java.lang.Math;



//This is a class definition
class Lecture2{


	public static void main(String[] args){

		//Prints "Hello, World!"
		System.out.println("Hello, World!");

		//Creates interger named varA with value of 30
		int varA = 10 * 3;
		//Prints value of varA
		System.out.printf("The value of a is %d\n", varA);

		//Creates double named sq_rt with the value of sqrt(16)
		double sq_rt = Math.sqrt(16.0);
		//Prints out value of sq_rt
		System.out.printf("The value of sq_rt is %f\n", sq_rt);


	}




}
