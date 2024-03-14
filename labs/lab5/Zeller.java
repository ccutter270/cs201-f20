/******************************

Lab 5: Days of the Week
Monday, October 12, 2020

********************************/


import java.util.Scanner;
import java.lang.Math;


class Zeller{

  //MAIN METHOD
  public static void main(String[] args){

    //GET INPUT
    System.out.println("This program calculates the calendar day of the week from a given month, day, and year.");

    System.out.print("\nEnter a month (e.g. 12):  ");
    Scanner sc1 = new Scanner(System.in);
    int month = sc1.nextInt();

    System.out.print("\nEnter a day (e.g. 25):  ");
    Scanner sc2 = new Scanner(System.in);
    int day = sc2.nextInt();

    System.out.print("\nEnter a year (e.g. 2019):  ");
    Scanner sc3 = new Scanner(System.in);
    int year = sc3.nextInt();


    //Create Instance of Class Zeller
    Zeller zeller = new Zeller();
    zeller.dayOfTheWeek(month, day, year);



  }


  //dayOfTheWeek Method - takes the imputs and prints out what day of the week the date was on
  public void dayOfTheWeek(int month, int day, int year){


    //DAY OF WEEK AS INTEGER
    double century = year%100;
    double zeroCentury = Math.floor((year/100));

    double dayDouble =  (day + Math.floor((13*(month+1)/5)) + century + Math.floor((century/4)) + Math.floor((zeroCentury/4)) + (5*zeroCentury)) % 7;

    int dayInt = (int)(dayDouble % 7);


    //INTEGER TO DAY OF WEEK
    String dayString = "";
    switch (dayInt) {
        case 0:  dayString = "Saturday";
                 break;
        case 1:  dayString = "Sunday";
                 break;
        case 2:  dayString = "Monday";
                 break;
        case 3:  dayString = "Tuesday";
                 break;
        case 4:  dayString = "Wednesday";
                 break;
        case 5:  dayString = "Thursday";
                 break;
        case 6:  dayString = "Friday";
                 break;
               }
    System.out.printf("\n\nThis date falls on a %s.\n\n", dayString);
    }


}
