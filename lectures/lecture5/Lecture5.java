/******************************

Lecture 5: Arrays
Friday, September 18, 2020

********************************/



/********************************************************
Notes:

Classes:
  - You can have multiple classes within a file


Array:
  - How to create - datatype[] varname; OR datatype varname[];
  - How to initialize - datatype[] name = new datatype[sizeArray];
  - Can never change the size of the array after initialize


**********************************************************/



//imports
import java.lang.Math;



// Already made this - two classes, can call inside other class
class Point{

  //fields
  public int x;
  public int y;

  Point(int a, int b){

      x = a;
      y = b;
      }

    void printPoint(){

      System.out.printf("(%d,%d)\n", x, y);
      }

  }



//Another class that can be called inside our Lecture.java
class Line{

  public int m;
  public int b;


  Line(int a1, int b1){

    m = a1;
    b = b1;

  }

  void printLine(){
    System.out.printf("y = %dx + %d\n", m, b);
  }


}


//Lecture Class

class Lecture5{

  //Main Method
  public static void main(String[] args){

    //datatype[] varname;
    //datatype varname[]

    //how to initialize
    int[] numbers;
    // Also correct: int numbers[];

    //Another way to initialize
    int sizeArray = 10; //just for clarification
    int[] numbers3 = new int[sizeArray];


    //Giving numbers to numbers3 array
    for(int iter=0; iter<10; iter++){

      numbers3[iter] = iter;
      }

    System.out.println(numbers3[9]);

    // To print out whole array you have to iterate
    for(int iter=0; iter<10; iter++){

      System.out.println(numbers3[iter]);
      }




    // Can also initizalize arrays like this
    int[] numbers4 = new int[]{0,1,2,3,4,5,6,7,8,9};


    //Printing out numbers4
    for(int iter=0; iter<10; iter++){

      System.out.println(numbers4[iter]);
      }

    //Two Dimensional Arrays
    //This means 10 spots in first array, each array in those 10 spots
    // has 20 spots
    int[][] array2d = new int[10][20];

    //3D Arrays
    int[][][] array3d = new int[10][20][30];



  }


}












/*
SCRAPBOOK:




// This is for the Classes practice above, now talking about arrays

class Lecture5{

  // Main Method
	public static void main(String[] args){

    Point pt1 = new Point(1,2);
    pt1.printPoint();


    Line l1 = new Line(3,4);
    l1.printLine();

  }
*/
