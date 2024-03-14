/******************************

Lecture 14: Inheritance
Friday, October 9, 2020

********************************/


/*******************************************************************************
Notes:
  - Inheritance - building classes upon other classes
  - Can make a very general class and then make specific classes that
    "inherit" those general properties
  - Have parent class, everything is a collection of the parent class
  - The child class extends the parent class
  - Protected means only class and childeren of the class can access it
  - Can give multiple constructors, but not with name type & number of args
    or else it is ambiguous and will get an error

Agenda:
  - Making a parent and child class
  - Private vs Protected variables
  - Multiple Constructors
*******************************************************************************/




//Imports
import java.lang.Math;
import java.util.Vector;



class Animal{


  //ATTRIBUTES

  protected String name;
  protected double weight;
  protected String nickname;


  //Constructor
  public Animal(){
    System.out.println("Making an animal.");
    }



  public void eat(){
    //System.out.println("I am eating generic food.\n");
    System.out.printf("%s is eating generic food.\n\n", name);
    }

  public String toString(){
    return "My name is " + name;
  }



  }




class Dog extends Animal{

  public Dog(String n){

    System.out.print("Making a dog.\n\n");
    name = n;


  }

}



class Cat extends Animal{


  public Cat(String n){
    //If you don't know the weight
    System.out.println("Constructor 1:Making a cat.");
    name = n;
  }

  public Cat(String n, double w){
    //If you know the weight
    System.out.println("Constructor 2: Making a cat.");
    name = n;
    weight = w;
  }

  public Cat(String n, String nn){
    //If you know the weight
    System.out.println("Constructor 3: Making a cat.");
    name = n;
    nickname = nn;
  }

  public String toString(){
    return "I am a cat named " + name;
  }





}





class Lecture14{

  public static void main(String[] args){


    System.out.println("\nCreated instance of an animal.");
    Animal animal = new Animal();
    animal.eat();

    System.out.println("Created instance of a dog\n");
    Dog dog = new Dog("Winter");
    dog.eat();

    //Print whole class (because of 2 string method)
    System.out.println(dog);



    System.out.print("Creating instance of Cat\n");
    Cat cat = new Cat("Snowflake", 35.0);
    cat.eat();
    System.out.println(cat);

    //Store all animals together
    Vector<Animal> animals = new Vector<Animal>();
    animals.add(dog);
    animals.add(cat);

    for(int iter = 0; iter<animals.size(); iter++){
      System.out.println(animals.get(iter));
    }


  }



}
