/******************************

Lecture 9: Array List
Monday, September 28, 2020

********************************/


/*******************************************************************************
Notes:
  - Iterator --> helps not go out of bounds
  - Vectors can only be written in order, can only happen synchronise
    meaning a thread can only write to it one at a time, order matters
  - Thread let functions occur at the same time
  - Array List is asynchronous - meaning thread can write to multiple at a same
    time & order doesn't matter
  - Capacity of vector doubles every time, Array lists increases by 50%
  - Can use iterator for ArrayList


Agenda:
  (In Scrapbook)
  - Review Vectors: make, add, remove, print, add at index
  - How to create an iterator & how to use it with a while loop
  - How to create array lists, different functions
*******************************************************************************/

//Imports
import java.lang.Math;
import java.util.Vector;
import java.util.Iterator;
import java.util.ArrayList;






class Vectorpractice{

  public void vectorwork(){

    //create vectors
    Vector <String> v1 = new Vector <String>();

    v1.add("blue");
    v1.add("green");
    v1.add("purple");

    v1.remove(1);

    v1.add("orange");
    v1.add("black");

    //print one at a time
    for (int ii = 0; ii < v1.size(); ii++){

      System.out.println(v1.get(ii));
    }


    //print all at once
    System.out.println(v1);

    //Add at index of vectors, will push everything else back
    v1.add(1, "red");

    System.out.println(v1);



    //How to call iterator
    Iterator iter = v1.iterator();

    //Call while instead of for
    while(iter.hasNext()){
      System.out.println(iter.next());
      // Need to specify type to do this
      //String s = iter.next();
      }
    }
  }





class Lecture9{


  // MAIN METHOD
  public static void main(String[] args){

    ArrayList <String> al = new ArrayList<String>(/*Can Specify Capacity*/);

    al.add("blue");
    al.add("green");
    al.add("pruple");

    System.out.println(al);

    al.add(1, "black");
    al.add("white");

    //Prints out array list
    System.out.println(al);


    //First & Last
    System.out.println(al.get(0));
    System.out.println(al.get(al.size()-1));

    Iterator iter = al.iterator();

    while(iter.hasNext()){
      System.out.println(iter.next());
      }

  }
}





/*
SCRAPBOOK:



*/
