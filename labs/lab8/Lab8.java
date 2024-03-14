/******************************

Caroline Cutter
Lab 8: Enumeration
Monday, November 2, 2020

********************************/


import java.util.Scanner;
import java.lang.Math;
import java.util.Vector;
import java.io.File;









enum Change{

    //working in dollar - rounding for accuracy
    HUNDRED(10000),
    FIFTY(5000),
    TWENTY(2000),
    TEN(1000),
    FIVE(500),
    ONE(100),
    QUARTER(25),
    DIME(10),
    NICKEL(5),
    PENNY(1);

    public final int data;

    private Change(int d){
      data = d;
    }

}




class Lab8{


  public static void main(String[] args){

    //Change change;

    System.out.print("Enter a dollar amount:  ");
    Scanner sc = new Scanner(System.in);
    double doubleAmount = sc.nextDouble();


    int amount = (int)Math.ceil(doubleAmount*100);

    for(Change change: Change.values()){

      int tempChange = 0;
      while(amount >= change.data){
        amount -= change.data;
        tempChange ++;
      }
      if (tempChange > 0){
        System.out.print(change);
        System.out.printf(": %d\n", tempChange);
      }
    }


  }
}


//IGNORE THIS - JUST NOTES FROM CLASS

/*





Class example - how to use enum
enum Colors{

    RED(1),
    ORANGE(2),
    YELLOW(3),
    GREEN(4),
    BLUE(5),
    PRUPLE(6);
    public final int data;


  private Colors(int d){
    data = d;
  }

}



class Main{


  public static void main(String[] args){

    //Colors colors;

    for(Colors color: Colors.values()){
      System.out.println(color);
    }

  }
}

*/
