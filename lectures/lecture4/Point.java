/******************************

Lecture 4: Classes
Wednesday, September 16, 2020

********************************/


/********************************************************
Notes:

Constructor
  - first instance of the class, does not have return type
  - anything you want to run when the class is first opened in construcutor
  - give values this when program starts
  - Needs to have same name as class
  - Only runs once, gets called when you first call the Classes
  - Not inside main function
  - Ex: amazon echo --> tell info at beinginng only once


**********************************************************/


import java.lang.Math;


class Point{

  // Field or Attributes
  public int x;
  public int y;


//Contructor Example 2

// Contructor
  Point(int inx, int iny){

    x = inx;
    y = iny;
  }




  // Methods


  void addPoints(Point p){

    x += p.x;
    y += p.y;

  }


  // returntype name(args of function)

  Point addPoint2(Point p){

    int mx = x + p.x;
    int my = y + p.y;

    Point pt = new Point(mx, my);

    return pt;

  }




  // Main Method

  public static void main(String[] args){

    //follows constructor & calls class
    Point pt1 = new Point(4,10);
    System.out.printf("x: %d\ty: %d\n", pt1.x, pt1.y);

    Point pt2 = new Point(5,5);
    System.out.printf("x: %d\ty: %d\n", pt2.x, pt2.y);

    pt1.addPoints(pt2);
    System.out.printf("x: %d\ty: %d\n", pt1.x, pt1.y);


    //Point pt3 = new Point(0,0);
    Point pt3 = pt1.addPoint2(pt2);
    System.out.printf("pt3 = x: %d\ty: %d\n", pt3.x, pt3.y);
    System.out.printf("pt1 = x: %d\ty: %d\n", pt1.x, pt1.y);


    }

}




/*

Other code examples

/ Consturctor Example 1

// Contructor
  /*
  Point(){
    x = 0;
    y = 0;
  }
  */


  //Possible Scanner Use
  // Scanner sc = new Scanner (...)
  // String = sc.next();
  // convert to integer


// Main Method


/*
  public static void main(String[] args){
    //follows constructor & calls class
    Point pt1 = new Point();
    System.out.printf("x: %d\ty: %d\n", pt1.x, pt1.y);
*/







/*

- Don't use static in homework - this is bad example
- Instead use the example called addPoints above


      static Point addPopints(Point a, Point b){

        int x2 = a.x + b.x;
        int y2 = a.y + b.y;

        Point c = new Point(x2, y2);

        return c;




This would be in main method
        Point pt3 = new Point(0,0);
        pt3 = addPoints(pt1, pt2);
        System.out.printf("x: %d\ty: %d\n", pt3.x, pt3.y);

*/
