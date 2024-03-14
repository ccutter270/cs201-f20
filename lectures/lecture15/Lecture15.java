/******************************

Lecture 15: Inheritance Part 2
Monday, October 12, 2020

********************************/


/*******************************************************************************
Notes:
  - Super - says to call parent costructor with the same number of arguments
  - Can only call super one time, MUST be the first statement
  - Can use this when talking about itself

Agenda:
  - Super function
  - How to make deep copy of a instance of a class
*******************************************************************************/




//IMPORTS
import java.lang.Math;
import java.util.Vector;


//PARENT CLASS
class Midd{

  public String first;
  public String last;
  public int id;

  public Midd(){
    System.out.println("\nInstance of Midd Class.\n");

  }

  public Midd(String f, String l){
    first = f;
    last = l;
    System.out.println("\nMidd Constructor - 2 Arguments.");

  }

  public Midd(int n){
    id = n;
    System.out.println("\nMidd Constructor - 1 Argument.");
  }


  public String toString(){
    return last + ", " + first;
  }


  public void talk(){
    System.out.println("Hello fromt the Parent Constructor");
  }



}



//CHILD CLASSES

class Student extends Midd{


}




class Faculty extends Midd{

  //public Faculty(String f, String l){
    //super(f,l); //calls the parent constructor with two arguments
    //System.out.println("Faculty Constructor.");
    //first = f;
    //last = l;

  //}

  public Faculty(String f, String l, int n){

    id = n;
    first = f;
    last = l;
    System.out.println("Faculty Constructor.");

  }

  //Copy Constructor
  public Faculty(Faculty fac){

    this.first = fac.first;
    this.last = fac.last;

  }


}



class Staff extends Midd{

  public Staff(String f, String l, int n){
    super(f,l);
    id = n;
    System.out.println("Staff Constructor");
    //talk();

  }

  //Takes this over the Parent class - if not defaults to parent class
  public void talk(){
    System.out.println("Hello fromt the Staff Child Class");
  }




}







class Lecture15{

  public static void main(String[] args){

    Midd s = new Staff("Mary", "Doe", 2);
    System.out.println(s);
    s.talk();


  }








  /*

  THIS MAIN CLASS SHOWS SOURCE AND COPY FUNCTIONS AND MAINLY USES FACULTY

  public static void main(String[] args){

    //Parent class
    //Midd m = new Midd("Caroline", "Cutter");
    //System.out.println(m);

    //Faculty class
    Faculty src = new Faculty("Jason", "Grant", 1);
    //Can also be this -
    //Midd fac = new Faculty("Jason", "Grant", 1);
    System.out.println(src);

    //This is a shallow copy!!!
      //Faculty fac2 = fac;
    //Shows that both are manipulated in the shallow copy
      //System.out.println(fac2);
      //fac2.first = "Justin";
      //System.out.println(fac);
      //System.out.println(fac2);

    Faculty dst = new Faculty(src);

    System.out.println(dst);


    dst.first = "Justin";


    System.out.println(src);
    System.out.println(dst);

  }
  */




}
