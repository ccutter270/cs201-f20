/******************************

Lecture 16: Interfaces
Wednesday, October 14, 2020

********************************/


/*******************************************************************************
Notes:
  - Interface specifies the type, exact function, output of code, even if things
    are seperated in them
  - Can't define anything inside an Interface - just a blueprint
  - In class, must define all of the methods in the interface
      - Must have same types as paremeters
  - Can add additional functionality to class that isn't in interfcae


Agenda:
  - Interface Bicylce function
  - Making a child class of the implement class

*******************************************************************************/




//IMPORTS
import java.lang.Math;
import java.util.Vector;



//Interface
interface Bicycle{


    //Cant do This
    //public int speed;

  public void changeCadence(int val);

  public void changeGear(int val);

  public void speedUp(int val);

  public void applyBrakes(int val);


}



//PARENT CLASS
class Bike implements Bicycle{


  public double speed;
  public int wheelsize;
  public String name;

  public Bike(){
    System.out.println("Creating a new Bike.");
  }

  public void changeCadence(int val){

  }

  public void changeGear(int val){

  }

  public void speedUp(int val){

  }

  public void applyBrakes(int val){

  }

  public String getName(){
    return "";

  }


}


class RoadBike extends Bike{

  public RoadBike(){
    System.out.println("Creating a new RoadBike.");
  }



}




class Lecture16{

  public static void main(String[] args){

      RoadBike rb = new RoadBike();

  }
}
