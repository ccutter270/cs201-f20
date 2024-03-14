/******************************
Caroline Cutter
Homework 7: Doubly Linked List
Friday, November 6, 2020

Description:
  This program takes in Processes from the file "Processes.txt" and orders
  them based off Priority in a linked list. If the process doesn't have
  a Priority Number, it is assinged the value 100,000. Each process was assigned
  a specific PID number. Once all are loaded into the Queue, it begins to
  dequeue the items into two CPUs based off the time it takes each to process.
  Once it is finished, a list will be printed out with the CPU number, PID,
  name, and time for each process.

  **Size of the Queue is kept through throughout the program, I know the
  description didn't say to print the size but I did to show it works.
  Size will be printed out after the Queue is complete and after all items
  have been dequeued.


  To complile - javac Homework7.java
  To run -      java Homework7
********************************/

//IMPORTS
import java.util.Scanner;
import java.lang.Math;
import java.util.Vector;
import java.io.File;


class PriorityQueue{


  //ATTRIBUTES
  Node head;
  Node tail;
  int size;


  //NODE CLASS
  public class Node{

    //ATTRIBUTES
    String PID;
    String name;
    String time;
    int priority;
    int CPU;
    Node next;
    Node prev;

    //CONSTRUCTOR
    public Node(String[] info){

      PID = info[0];
      name = info[1];
      time = info[2];
      priority = Integer.parseInt(info[3]);
      CPU = 0;
      prev = null;
      next = null;
    }
  }



  /*
    add() - takes a string of info, creates a node, adds node to a linked list
            in order of lowest priority to highest priority
  */
  public void add(String[] info){

    Node newnode = new Node(info);
    boolean placed = false;

    Node curr = head;

    //List empty - add as head & tail
    if (head == null){
        head = newnode;
        tail = newnode;
        placed = true;
        }

    //List not empty - Add by priority
    else{

      //If new head
      if(newnode.priority < head.priority){
        head.prev = newnode;
        newnode.next = head;
        newnode.prev = null;
        head = newnode;
        placed = true;
        }

      //If not head, search until placed or until end of list
      while(placed == false && curr != null){

        //Priority Queue IS equal to current
        if(newnode.priority == curr.priority){

          //Iterate until at the end of equal priority queues
          while(curr.next != null && newnode.priority == curr.next.priority){
            curr = curr.next;
            }

          //If end - add as new tail
          if(curr.next == null){
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
            placed = true;
            }
          // If not, just add after current
          else{
            newnode.next = curr.next;
            newnode.prev = curr;
            curr.next.prev = newnode;
            curr.next = newnode;
            placed = true;
            }
          }

        // Priority Queue NOT equal to current
        else{

          //If larger, iterate to next
          if(newnode.priority > curr.priority){
            curr = curr.next;
            }

          //If smaller - insert before current
          else{
              newnode.next = curr;
              newnode.prev = curr.prev;
              curr.prev.next = newnode;
              curr.prev = newnode;
              placed = true;
              }
          }
      }

      //If end & not placed, add as tail
      if(placed == false && curr == null){
          tail.next = newnode;
          newnode.prev = tail;
          tail = newnode;
          placed = true;
          }
      }

      //Add to size if placed
      if(placed == true){
        size++;
      }
    }


  //printQueue() - prints the current queue with PID, name, time & priority
  public void printQueue(){

    Node curr = head;
    System.out.println("Queued Jobs.");

    while(curr != null){
      System.out.printf("PID: %s| %19s | Time: %5s| Priority: %s\n", curr.PID, curr.name, curr.time, curr.priority);
      curr = curr.next;
      }
    }


  //size() - returns current size of queue as an integer
  public int size(){
    return size;
  }



  /*
    remove() - removes the specified ID number from the current Queue, returns
               true if removed, false if not. In this program, the head is
               always removed becuase in the dequeue method, it iterates through
               the queue and removes the head each time. However, this function
               works for removing other values that aren't the head as well.
  */
  public boolean remove(String id){

      Node curr = null;
      Node prev = null;

      // ID is the head ID
      if(head != null && head.PID == id){

        //If only one item in the list
        if (head == tail){
          head = null;
          tail = null;
        }
        //If list length is greater than one
        else{
          head = head.next;
          head.prev = null;
        }
      }

      // If in the list but not first item ***This won't really be used in this
        //specific program
      else{

        curr = head.next;
        prev = head;

        //Continue until found or at end of list
        while (curr != null && curr.PID != id){
          prev = curr;
          curr = curr.next;
        }
        // Found it & not end of the list
        if (curr != null){

          // If it is the tail - set new tail
          if (curr == tail){
            tail = prev;
            tail.next = null;
          }

          //General case - found in list but not tail or head
          else{
            prev.next = curr.next;
            curr.next.prev = prev;
          }
        }
        //Item not found
        else{
          return false;
        }
      }
      //Item found, decrease size by one, item already removed
      size--;
      return true;
    }


  /*
    dequeue() - this method deques the head of the queue and assigns it to
                CPU1 or CPU2 based on the times of each process and which CPU
                is currently "empty". It prints each item that it dequeues
                with CPU#, PID, name and time.
  */
  public void dequeue(){

      Node curr = head;

      int CPUtime1 = 0;
      int CPUtime2 = 0;

    //Until queue is empty
    while(curr != null){

      //If CPU1 is empty - reassign times and remove head
      if (CPUtime1 <= CPUtime2){
        CPUtime2 -= CPUtime1;
        CPUtime1 = Integer.parseInt(curr.time);
        curr.CPU = 1;
        System.out.printf("CPU%d: Processing PID: %s|%19s | %5s\n", curr.CPU, curr.PID, curr.name, curr.time);
        remove(curr.PID);
        }
      //If CPU2 is empty - reassign times and remove head
      else{
        CPUtime1 -= CPUtime2;
        CPUtime2 = Integer.parseInt(curr.time);
        curr.CPU = 2;
        System.out.printf("CPU%d: Processing PID: %s|%19s | %5s\n", curr.CPU, curr.PID, curr.name, curr.time);
        remove(curr.PID);
        }
        curr = curr.next;
      }
    }


}



class Homework7{

  public static void main(String[] args){


    //ATTRIBUTES
    File file = new File("Processes.txt");
    String[] splitLine = new String[4];
    int newID = 0;

    PriorityQueue queue = new PriorityQueue();


    //Try to read files, catch if there are errors with the files
    try{

      //Read Processes file - Split and put each value into array split
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {

        String line = scanner.nextLine();
        String[] split = line.split(",");

        // Array Order: {PID, Name, Time, Priority}

        //PID
        if (newID>9){
          splitLine[0] = String.format("0%s", Integer.toString(newID));
          }
        else{
          splitLine[0] = String.format("00%s", Integer.toString(newID));
          }

        newID +=1; //Increase ID after each iteration


        splitLine[1] = split[0]; //Name
        splitLine[2] = split[1]; //Time

        //Priority
        if(split.length > 2){
          splitLine[3] = split[2];
          }
        else{
          //If the process doesn't have a priority queue - set as 100,000
          splitLine[3] = Integer.toString(100000);
          }

        //For each line - add item to Queue
        queue.add(splitLine);
      }


        //PART 1 - print queued items and size
        queue.printQueue();
        System.out.printf("\nThe size of the Queue: %d\n", queue.size());

        //PART 2 - dequeue items, print them, then print final size of queue
        System.out.println("\nExecuting Jobs.");
        queue.dequeue();
        System.out.println("Finished.\n");
        System.out.printf("The final size of the Queue: %d\n\n", queue.size());

    }catch(Exception ex){
      System.out.println(ex);
      }
  }
}
