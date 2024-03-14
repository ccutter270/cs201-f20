/******************************

Lecture 18: Linked Lists (Part 2)
Friday, October 19, 2020

********************************/



/*******************************************************************************
Notes:
  - Head = first node of list
  - Dont lose head of list or else gone forever

Agenda:
  - Printing values with a while loop
*******************************************************************************/





class LinkedList{



  public class Node{

    int data;
    Node next;
    Node prev;



    public Node(int d){
      data = d;
      prev = null;
      next = null;
    }

  }



  Node head;
  Node tail;


  public LinkedList(){
    head = null;
    tail = null;
  }


  public void add(int d){

    Node newnode = new Node(d);

    if (head == null){
      head = newnode;
      tail = newnode;
    }
  }

  public void printList(){

    Node curr = head;

    while(curr != null){
      System.out.println(curr.data);
      curr = curr.next;
    }
  }



}


class Lecture18{


  public static void main(String[] args){

    LinkedList ll = new LinkedList();

    ll.add(5);
    ll.printList();


  }






}
