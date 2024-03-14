/******************************

Lecture 8: Vectors
Friday, September 25, 2020

********************************/


/*******************************************************************************
Notes:
  - Vectors by default has 10 spaces (can declare otherwise)
  - Capcity is how many you can fit in, size is how many are already in
  - Java perfers you to specify type of vector, but can do without
  - Vectors double when they need more space (aka 21 elements = 40 spaces)
  - Can specify initial capacity (in the new vector(size);)
  - If you specify size, it will double the size instead of doubling 10
  - This should be used instead of array for dynamic lengths


Agenda:
  (in scrapbook)
  - How to declare a vector
  - How to check size and capacity
  - How to declare vector of differnt types
  (in main method)
  - How to specify initial captacity
  - How to use a for loop to add / print Vectors
  - How to get values from Vectors
  - How to remove elements
*******************************************************************************/



//Imports
import java.lang.Math;
import java.util.Vector;



class Lecture8{


  // MAIN METHOD
  public static void main(String[] args){


    // Can specify initial captacity
    Vector<Integer> v1 = new Vector<Integer>(7);

    //For loop to print out vectors
    for(int ii = 0; ii<21; ii++){
      v1.add(ii);
      //System.out.printf("Vector size: %d\n", v1.size());
      //System.out.printf("Vector capacity: %d\n", v1.capacity());

      }

    //Accesing inside our vectors

    Vector<String> v2 = new Vector<String>();

    v2.add("Red");
    v2.add("Blue");
    v2.add("Green");

    //Can acess 2 different ways
    v2.elementAt(1);
    v2.get(1);
    // First & last values
    v2.firstElement();
    v2.lastElement();

    System.out.println(v2.elementAt(1));
    System.out.println(v2.get(1));
    System.out.println(v2.firstElement());
    System.out.println(v2.lastElement());



    //Removing elements
    v2.remove(1);

    System.out.printf("Vector size: %d\n", v2.size());
    System.out.printf("Vector capacity: %d\n", v2.capacity());


    //For loop to print values
    for(int ii = 0; ii < v1.size(); ii++){

      System.out.println(v1.get(ii));
      }








  }
}





/*

SCRAPBOOK:



    //VECTOR 1 - integers

    //Declaring new Vector
    Vector<Integer> v1 = new Vector<Integer>(); //Don't need the int, just avoids warning


    //Prints out size and capacity
    System.out.printf("Vector size: %d\n", v1.size());
    System.out.printf("Vector capacity: %d\n", v1.capacity());


    //Add to vector
    v1.add(10);
    v1.add(12);
    v1.add(13);
    v1.add(14);


    //Prints out size and capacity
    System.out.printf("Vector size: %d\n", v1.size());
    System.out.printf("Vector capacity: %d\n", v1.capacity());

    System.out.printf("Vector 2\n");



    // VECTOR 2 - Strings

    Vector v2 = new Vector();

    v2.add("abc");
    v2.add("efg");
    v2.add("xyz");
    v2.add("123");

    System.out.printf("Vector size: %d\n", v2.size());
    System.out.printf("Vector capacity: %d\n", v2.capacity());








*/
