/******************************

Lecture 13: Encapsulation & Midterm Review
Wednesday, October 7, 2020

********************************/


/*******************************************************************************
Notes:
  STATIC VS NON-STATIC
  - If you assign a point to another point, you dont creat a new once, you just
    assing the value to the other value so they always stay the same
  - To get around this, use .copy() or .clone()
  - Static will share value with every instance of a class (so for x, all will
    share the value)
  - Good thing of a static - allowed variable to be called without creating an
    instance of a class
  - Static main() so it will run without instance of main class
  - Static useful when a class of a bunch of functions to manipulate the data,
    but not store any functions
  - Reasons why you get static error -
    - Non static variables belong to instance of classes, so must create an
      instance of a class to work
    - In order to use static function, every variable must be static within it
      but then all the data is static and if you change one thing, then
      everything is changed - debugging becomes really hard

  PUBLIC VS PRIVATE
  - Public variables can be accessed / seen from other classes
  - Private says only functions within class can use variable
  - Can make a public method that returns the value of a private variable, but
    other classes still can't manipulate it


Agenda:
  (SCRAPBOOK)
  - Review how to assing variables & use methods from a class
  (CODE)
  STATIC VS NON-STATIC
  - Difference between static and not Static - what happens to variable values
  - Good use of a static method - class MathFx
  - Good use of static variable - class MathFx
  - What happens when non-static variable is used in static function
  PUBLIC VS PRIVATE
  - What happens when a function / variable is private - can't be called in
    other classes
  - How to make a public method to return a private variable


*******************************************************************************/

//IMPORTS
import java.lang.Math;
import java.util.Vector;


class MathFx{

  //if this wasn't static, it would not run
  //If this was private, it wouldn't be able to be called in other classes
  private int nummults;

  //public mehtod to return nummults if it was private;
  public int getNummults(){
    return nummults;
  }


  public MathFx(){

    nummults = 0;

  }
  //now can use this without creating instance of class
  //If this was private - wouldn't be able to be accessed by class point
  public static int multiply(int a, int b){
    nummults++;
    return a*b;
  }

}


class Point{

  //ATTRIBUTES
  public static int x;
  public static int y;

  //CONSTRUCTOR
  Point(int a, int b){
    x = a;
    y=b;
  }





  public static void main(String[] args){

    Point p1 = new Point(4,5);
    System.out.printf("(%d, %d)\n", p1.x, p1.y);

    Point p2 = new Point(10,45);
    System.out.printf("(%d, %d)\n", p2.x, p2.y);

    //Because of static - we didn't reassign, but it reassigned by self to p2
    //Varaible will be shared between every instance of the class
    System.out.printf("(%d, %d)\n", p1.x, p1.y);

    //This will assign to all x and y because it is static
    p1.x = 55;
    p1.y = 20;

    System.out.printf("(%d, %d)\n", p1.x, p1.y);
    System.out.printf("(%d, %d)\n", p2.x, p2.y);




    //MathFx math = new MathFx();
    //int x = math.multiply(25,30);
    //Instead just use this - didn't even need to call instance
    //int x = MathFx.multiply(25,30);
    //System.out.printf("x: %d\n", x);


    //To see what happens with nummults
    //MathFx.multiply(25,30);
    //MathFx.multiply(25,30);
    //MathFx.multiply(25,30);
    //MathFx.multiply(25,30);


    //only works if nummults is public
    //System.out.println(MathFx.nummults);

    //if nummults was private:
    MathFx math = new MathFx();
    System.out.println(math.getNummults());


  }

}




/*
SCRAPBOOK:


//Review - how to use functions
Point p1 = new Point(4,5);
Point p2 = new Point(10,45);
System.out.printf("(%d, %d)\n", p1.x, p1.y);
System.out.printf("(%d, %d)\n", p2.x, p2.y);


//Assign P3 as P2
Point p3;
p3 = p2;

System.out.printf("(%d, %d)\n", p3.x, p3.y);


//What if we change P2?
p2.x = 11;
p2.y = 12;
System.out.printf("(%d, %d)\n", p2.x, p2.y);


//Then P3 is also changed!
System.out.printf("(%d, %d)\n", p3.x, p3.y);




*/
