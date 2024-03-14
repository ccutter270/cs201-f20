/******************************

Lecture 17: Singly Linked Lists
Friday, October 16, 2020

********************************/


/*******************************************************************************
Notes:
  - Head = first node of list
  - Dont lose head of list or else gone forever

Agenda:
  - Creating node CLASS
  - Setting head
  - Setting next value / while loop until at end of list
*******************************************************************************/




//IMPORTS
import java.lang.Math;
import java.util.Vector;


//PARENT CLASS
class LinkedList{



  //Class inside of class
  class Node{

    public int data;
    public Node next;

    public Node(int d){
      data = d;
      next = null;
    }



  }

  //ATTRIBUTES
    //Call first node - head
  public Node head;

  //Constructor
  public LinkedList(){

    head = null;


  }

  //METHODS

  public void add(int d){

    //create new node
    Node newnode = new Node(d);

    if(head == null){
      head = newnode;
    }
    else{
      Node curr = head;

      while(curr.next != null){
        curr = curr.next;
      }

      curr.next = newnode;
    }
  }

  public void printList(){

    Node curr = head;

    while (curr != null){
      System.out.println(curr.data);
      curr = curr.next;

    }



  }



  public void remove(int val){

    Node curr = head;
    Node prev = null;

    //If want to remove head
    if(curr != null && curr.data == val){
      head = head.next; // curr.next
    }


    else{

      //While current is not equal to the item we want to remove
      while (curr != null && curr.data != val){

        prev = curr;
        curr = curr.next;
      }

      if (curr != null){
        prev.next = curr.next;
      }
      else{
        System.out.println("Value not found");
      }

    }

  }







}



class Lecture17{

  public static void main(String[] args){

    LinkedList ll = new LinkedList();

    //Add to list
    ll.add(5);
    ll.add(10);
    ll.add(12);
    ll.add(12);
    ll.add(15);
    ll.add(17);
    ll.add(18);

    ll.printList();

    System.out.println("Removing now");


    System.out.println("Printing List");
    ll.remove(5);
    ll.printList();


    System.out.println("Printing List");
    ll.remove(7);
    ll.printList();











  }



}
