/******************************
Caroline Cutter
Homework 10: Car Dealership
Sunday, December 6, 2020

Description: This program creates a hash table of cars using linear probing
             if there are hash value conflicts. Each month the hash table adds
             and sells cars from the inventory, resizing the hash table if
             necessary.

  To complile - javac Homework10.java
  To run -      java Homework10 Cars.txt CarsSold.txt
********************************/

//Imports
import java.util.Vector;
import java.util.Scanner;
import java.io.File;
import java.lang.Math;





class HashTable{


  //NODE CLASS
  class Node{

    //ATTRIBUTES
    Car car;
    boolean deleted;

    //CONSTRUCTOR
    public Node(Car car_){
      car = car_;
      deleted = false;
    }


    //METHODS

    //delete() - lazily deletes node
    public void delete(){
      deleted = true;
    }

    //isDeleted() - returns true if node is lazily deleted, false if not
    public boolean isDeleted(){
      return deleted;
    }

  }

  //ATTRIBUTES (of HashTable class)
  Node[] hashTable;
  int capacity;
  int size;


  //CONSTRUCTOR
  public HashTable(){
    capacity = 100;
    size = 0;
    hashTable = new Node[capacity];
  }


  //print() - prints current hashTable
  public void print(){
    for(int i =0; i<hashTable.length; i++){
      if(hashTable[i]==null){
        //dont print anything if null
      }
      else{
        if(hashTable[i].deleted == false){
          System.out.printf("%03d: ", i);
          System.out.println(hashTable[i].car);
        }
      }
    }
  }



  //hashCode() - hashes car based on VIN number (written by Prof. Grant)
  public long hashCode(String s){
    long hash = 0;
    for(int i = 0; i<s.length(); i++){
        hash = hash * 31 + s.charAt(i);
    }
    return hash;
  }



  //add() - adds new node to hash table, linear probes if necessary
  public void add(Car car){

    //resize if necessary
    resize();

    Node newnode = new Node(car);
    boolean added = false;

    //HashValue to Index
    long hash = hashCode(car.vin);
    int hashIndex = Math.abs((int)(hash%capacity));


    while(added == false){

      //Add if spot is empty or value was deleted
      if(hashTable[hashIndex] == null || hashTable[hashIndex].isDeleted()){
        hashTable[hashIndex] = newnode;
        size++;
        added = true;
      }
      //else, linear probe by moving to next spot and checking again
      else{
        hashIndex ++;

        //If at end of array, wrap around to beginning
        if(hashIndex >= capacity){
          hashIndex = 0;
        }
      }
    }
  }



  //delete() - removes node from hash table and returns number of indexes to find
  public int delete(Car car){

    int indexes = 1;
    boolean found = false;
    long hash = hashCode(car.vin);
    int hashIndex = Math.abs((int)(hash%capacity));



    while(found == false){
      //If found, delete and exit while loop
      if(hashTable[hashIndex] != null && hashTable[hashIndex].car.vin.equals(car.vin)){
        hashTable[hashIndex].delete();
        size--;
        found = true;
      }
      //If not found, move down list until item is found (increasing indexes)
      else{
          hashIndex ++;
          indexes ++;

          //If hash index equals capacity, wrap to beginning of list
          if(hashIndex == capacity){
            hashIndex = 0;
          }
        }
      }
      return indexes;
    }



  //resize() - resizes hash table when it is full
  public void resize(){

    //Checks if table needs to be resized
    if(size == capacity){

      Node[] temp = hashTable.clone();
      hashTable = new Node[capacity*2];

      //reset capacity
      capacity = capacity*2;

      //Insert values back in with new hash value, size isn't increasing so size--;
      for(int iter = 0; iter < temp.length; iter++){
        add(temp[iter].car);
        size--;
        }
    }
  }


}




class Car{

  //ATTRIBUTES
  String vin;
  String year;
  String type;
  String manufact;
  int month;

  //CONSTRUCTOR
  public Car(String[] cars){

    // Vector Order: {Month, VIN, Year, Manufacturer, Type}
    month = Integer.parseInt(cars[0]);
    vin = cars[1];
    year = cars[2];
    manufact = cars[3];
    type = cars[4];
  }



  // toString() - formats how to print Car class
  public String toString(){

    return String.format("%s %s %s %s", vin, year, manufact, type);
    }


}




class Homework10{


  public static void main(String args[]){


    //ATTRIBUTES
    Vector<String[]> carInfo = new Vector<String[]>();
    Vector<String[]> carSoldInfo = new Vector<String[]>();
    Vector<Car> cars = new Vector<Car>();
    Vector<Car> carsSold = new Vector<Car>();


    HashTable ht = new HashTable();

    File file = new File(args[0]);
    File file1 = new File(args[1]);



    //READING FILES
    try{
      //Cars.txt file
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {

        String line = scanner.nextLine();
        String[] split = line.split(" ");
        carInfo.add(split);
        }

      //CarsSold.txt file
      Scanner scanner1 = new Scanner(file1);
      while (scanner1.hasNextLine()) {

        String line1 = scanner1.nextLine();
        String[] split1 = line1.split(" ");
        carSoldInfo.add(split1);
      }

      }catch(Exception e){
        System.out.println(e);
        }



    // ADDING ALL CARS TO cars vector
    for(int ii = 0; ii < carInfo.size(); ii++){
        Car car = new Car(carInfo.get(ii));
        cars.add(car);
       }

    // ADDING ALL SOLD CARS TO carsSold vector
    for(int ii = 0; ii < carSoldInfo.size(); ii++){
        Car car = new Car(carSoldInfo.get(ii));
        carsSold.add(car);
      }



    // ACTUAL PROGRAM RUNNING


    //For Each Month
    for(int month = 1; month <= 12; month++){

      int newcar = 0;
      int soldcar = 0;
      int keysIndexed = 0;


      //ADDING cars to hash table by month
      for(int iter = 0; iter < cars.size(); iter++){

        Car car = cars.get(iter);
        if(car.month == month){
          ht.add(car);
          newcar ++;
        }
      }


      //REMOVING cars that are sold from hash table by month
      for(int iter = 0; iter < carsSold.size(); iter++){

        Car car = carsSold.get(iter);
        if(car.month == month){
          keysIndexed += ht.delete(car);
          soldcar ++;
        }
      }


      //Convert month to string
      String month_string = "";
      switch (month) {
          case 1:  month_string = "January";
                   break;
          case 2:  month_string = "February";
                   break;
          case 3:  month_string = "March";
                   break;
          case 4:  month_string = "April";
                   break;
          case 5:  month_string = "May";
                   break;
          case 6:  month_string = "June";
                   break;
          case 7:  month_string = "July";
                   break;
          case 8:  month_string = "August";
                   break;
          case 9:  month_string = "September";
                   break;
          case 10: month_string = "October";
                   break;
          case 11: month_string = "November";
                   break;
          case 12: month_string = "December";
                   break;
                 }

      //Averaged keys
      double avgKeys = (double)keysIndexed / (double)soldcar;

      //Print out monthly summary
      System.out.printf("\n%s Inventory\n", month_string);
      System.out.printf("New: %d, Sold: %d, Total: %03d, Capacity: %d\n", newcar, soldcar, ht.size, ht.capacity);
      System.out.printf("Avg num. of keys indexed for retreival: %.2f\n", avgKeys);

    }


    //Asking to print inventory
    boolean got_input = false;

    while(got_input == false){
      System.out.print("\n\n\nPrint Inventory (y/n):  ");
      Scanner scan = new Scanner(System.in);
      String answer = scan.next();

      if(answer.equals("y") || answer.equals("Y")){
        ht.print();
        got_input = true;
      }
      else{
        if(answer.equals("n") || answer.equals("N")){
          got_input = true;
        }
        else{
          System.out.println("Invalid Input");
        }
      }





    }


  }
}
