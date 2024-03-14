/******************************

Caroline Cutter
Homework 6: Doubly Linked List
Friday, October 30, 2020


Description:
  This program takes in information from two files, Cargo.txt & Destinations.txt
  and adds each element to a doubly linked list in order of destiantion and
  cargo type. Then, it removes the values if they are departing to locations
  specified in Destinations.txt. The remaining nodes on the train will be printed.

  To complile - javac Homework6.java
  To run -      java Homework6 Cargo.txt Destinations.txt


********************************/

//IMPORTS
import java.util.Scanner;
import java.lang.Math;
import java.util.Vector;
import java.io.File;




class FreightCar{


  //ATTRIBUTES
  Node head;
  Node tail;


  //NODE CLASS
  public class Node{

    //ATTRIBUTES
    String destination;
    String cargo;
    String id;
    int priorityQueue;
    Node next;
    Node prev;

    //CONSTRUCTOR
    public Node(String[] info){

      id = info[0];
      destination = info[1];
      cargo = info[2];
      prev = null;
      next = null;

      //Priority Queue
      if(destination.equals("Boston")){
        priorityQueue = 0;
      }
      if(destination.equals("Providence")){
        priorityQueue = 1;
      }
      if(destination.equals("Trenton")){
        priorityQueue = 2;
      }
      if(destination.equals("Philadelphia")){
        priorityQueue = 3;
      }
      if(destination.equals("New York")){
        priorityQueue = 4;
      }
      if(destination.equals("Samford")){
        priorityQueue = 5;
      }
      if(destination.equals("Newark")){
        priorityQueue = 6;
      }
      if(destination.equals("Baltimore")){
        priorityQueue = 7;
      }
      if(destination.equals("Washington")){
        priorityQueue = 8;
      }
    }

  }

  //CONSTRUCTOR
  public FreightCar(){
    head = null;
    tail = null;
  }



  /*
    addInOrder()- for each line in the file "Cargo.txt," itcreates a node of
      for each train with Priority Queue, ID Number, Destination, and Cargo,then
      places them in order of priority queue (aka destination) and Cargo type
  */
  public void addInOrder(String[] cargoInfo){

    Node newnode = new Node(cargoInfo);
    boolean placed = false;

    Node curr = head;

    //List empty - add as head & tail
    if (head == null){
        head = newnode;
        tail = newnode;
        }

    //List not empty - find where to place
    else{

      //Continue while the item has not been placed or until the end of list
      while(placed == false && curr != null){

          //If Priority Queue (destination) is same, sort in order of cargo
          if(newnode.priorityQueue == curr.priorityQueue){

              //If cargos are same - add after current
              if(newnode.cargo.equals(curr.cargo)){

                //If adding to end of list - make it the tail
                if(newnode.cargo.equals(curr.cargo) && curr.next == null){
                  tail.next = newnode;
                  newnode.prev = tail;
                  tail = newnode;
                  placed = true;
                  }
                //If not tail, just add after current
                else{
                  newnode.next = curr.next;
                  newnode.prev = curr;
                  curr.next.prev = newnode;
                  curr.next = newnode;
                  placed = true;
                }
              }

              //If Cargo is not the same as current, move to the next node
              else{
                curr = curr.next;

                //If at end of list, add as tail
                if (curr == null ){
                  tail.next = newnode;
                  newnode.prev = tail;
                  tail = newnode;
                  placed = true;
                  }

                //If the new current is not the same destination, add before current
                if(placed == false && newnode.priorityQueue != curr.priorityQueue){
                  curr = curr.prev;
                  newnode.next = curr.next;
                  newnode.prev = curr;
                  curr.next.prev = newnode;
                  curr.next = newnode;
                  placed = true;
                }
              }
            }

          //If Priority Queue is not the same, move on to next and repeat
          else{
            curr = curr.next;
          }
        }


      //If not placed and end of the list - place as tail
      if(placed == false && curr == null){
          tail.next = newnode;
          newnode.prev = tail;
          tail = newnode;
          placed = true;
          }
      }
  }


  //size() - returns size as int of the doublely linked list
  public int size(){

    int size = 0;
    Node curr = head;

    while(curr != null){
      size++;
      curr = curr.next;
    }
    return size;
  }


  //printList() - prints doubly linked list
  public void printList(){

    Node curr = head;

    while(curr != null){
      System.out.printf("%3s: %-20s %s\n", curr.id, curr.destination, curr.cargo);
      curr = curr.next;
    }
  }


  // remove() - removes a specified destination from linked list and returns
    //true if it was removed, false if it was not found
  public boolean remove(String destination){

    String dest = destination;
    Node curr = null;
    Node prev = null;

    // Remove first item in list
    if(head != null && head.destination.equals(dest)){

      // If only one item in list - make list empty
      if (head == tail){
        head = null;
        tail = null;
      }
      // If list has more than one item - set next as head and head as null
      else{
        head = head.next;
        head.prev = null;
      }
    }
    // If not the first item
    else{
      curr = head.next;
      prev = head;

      // Continue until destination is found or at end of list
      while (curr != null && (!(curr.destination.equals(dest)))){
        prev = curr;
        curr = curr.next;
      }

      // If not at end & found the value
      if (curr != null){

        // If its the last item - set new tail
        if (curr == tail){
          tail = prev;
          tail.next = null;
        }
        // If found item and not tail (general case)
        else{
          prev.next = curr.next;
          curr.next.prev = prev;
        }
      }
      //Item not found - return false
      else{
        return false;
        }
      }
    //Return true because item was found & removed
      return true;
    }



  /*
  departing() - takes in vector of destinations from Destinations.txt and
    for each destination, if the items in the linked list are the the same
    destination, it removes them from linked list and prints them out
    as they depart. At the end, it prints what is left on the train (all the
    values that didn't have destinations in Destinations.txt)

  */
  public void departing(Vector<String> destVect){

    System.out.println("\n\nThe train is departing! \n");

    //For each destination in Destination.txt
    for(int iter = 0; iter<destVect.size(); iter++){

      //Set new destination
      String newDest = destVect.get(iter);
      System.out.printf("\n\nNow arriving at %s. Unloading cargo.\n\n", newDest);

      //Iterate through list and remove all instances of Destinations that match
      Node curr = head;
      while(curr != null){
          //If destination is equal, remove it & print it
          if(curr.destination.equals(newDest)){
            remove(newDest);
            System.out.printf("Unloading %3s: %-20s %s\n", curr.id, curr.destination, curr.cargo);
            }
          curr = curr.next;
          }
      }
      //Print final list
      System.out.printf("\n\nWhat's left on the train?\n");
      printList();
    }



}







class Homework6{

  public static void main(String[] args){


    //ATTRIBUTES
    File cargofile = new File(args[0]);
    File destfile = new File(args[1]);
    String[] splitLine = new String[3];
    Vector<String> destVect = new Vector<String>();
    int newID = 0;
    FreightCar ll = new FreightCar();


    //Try to read files, catch if there are errors with the files
    try{

      //Read Destination File - place each destination in vector
      Scanner scanner1 = new Scanner(destfile);
      while(scanner1.hasNextLine()){
        String destination = scanner1.nextLine();
        destVect.add(destination);
        }

      //Read Cargo file - Split and put each value into array
      Scanner scanner2 = new Scanner(cargofile);
      while (scanner2.hasNextLine()) {

        String line = scanner2.nextLine();
        String[] split = line.split(",");

        //Set Destination
        splitLine[1] = split[0];
        //Set Cargo
        splitLine[2] = split[1];
        //Set ID Numbner
        if (newID>9){
          splitLine[0] = String.format("0%s", Integer.toString(newID));
          }
        else{
          splitLine[0] = String.format("00%s", Integer.toString(newID));
          }

        //Increase ID number each iteration
        newID +=1;

        //Try to add each array from Cargo to doubly lineked list (ll),
          //catch if invalid args or other errors
        try{
          //Part 1 - Adding to doubly linked list (ll)
          ll.addInOrder(splitLine);

          }catch (Exception e){
              System.out.print(e);
              System.out.print("\n");
              }
          }

      //Part 2 - Printing out doubly linked list
      System.out.println("\n\n--Cargo Manifest--");
      ll.printList();


      //Part 3 - Removing values & printing them
      ll.departing(destVect);

    }catch(Exception ex){
      System.out.print(ex);
      System.out.print("\n");
      }
  }
}
