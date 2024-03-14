/******************************

Lecture 20: Stacks and Queues
Friday, October 23, 2020

********************************/



/*******************************************************************************
Notes:
  - Stacks and Queues (look at worksheet and OneNote for notes)

Agenda:
  - QUEUES
      - How to Add
      - How to remove
      - How to keep size
  - STACKS
    - How to Add
    - How to remove
    - How to keep size
*******************************************************************************/


//IMPORTS


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

    // list is empty
    if (head == null){
      head = newnode;
      tail = newnode;
    }
    else{
      tail.next = newnode;
      newnode.prev = tail;
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

  public boolean remove(int val){

    Node curr = null;
    Node prev = null;

    // item is first in list
    if(head != null && head.data == val){

      //  if only one item in list
      if (head == tail){
        head = null;
        tail = null;
      }
      // list length is greater than 1
      else{
        head = head.next;
        head.prev = null;
      }
    }
    // could be in list, but not the first item
    else{

      curr = head.next;
      prev = head;

      // continue until found out or reach end of the list
      while (curr != null && curr.data != val){
        prev = curr;
        curr = curr.next;
      }
      // we haven't reached the end, found it
      if (curr != null){

        // check to see if last item of our list
        if (curr == tail){
          tail = prev;
          tail.next = null;
        }
        // found something not the last item
        // general case
        else{
          prev.next = curr.next;
          curr.next.prev = prev;
        }
      }
      else{
        // item not found
        return false;
      }
    }
    return true;
  }
}






class Queue extends LinkedList{


  //ATTRIBUTES
  int size;


  //CONSTRUCTOR

  public Queue(){

    size = 0;
  }


  // Add an element to the Queue
  public void push(int data){
    add(data);
    size++;
  }

  //Remove the first element in the queue and returns it;
  public int pop(){

    int data;
    if(head!= null){
      data = head.data;
      remove(data);
      size--;

      return data;
    }

    return -1;
  }


  //Returns the size of the Queue
  public int size(){
    return size;

  }

}



class Stack extends LinkedList{

  //ATTRIBUTES
  int size;


  //CONSTRUCTOR
  public Stack(){
    size = 0;
  }


  //Add element
  public void push(int data){
    add(data);
    size++;
  }


  //Remove first element and returns it
  public int pop(){
    int data;


    if(tail != null){

      if(size == 1){
        data = tail.data;
        head = null;
        tail = null;
      }

      else{

        data = tail.data;

        tail = tail.prev;
        tail.next = null

        remove(data);
        size--;


      }

      return data;
    }

    return null;

  }


  //Returns size
  public int size(){
    return size;
  }

}















class Lecture20{



  //MAIN METHOD
  public static void main(String[] args){


    Stack s = new Stack();

    s.push(5);
    s.push(6);
    s.push(7);
    s.push(8);

    System.out.println("Printing Stack");
    s.printList();

    System.out.print("Size of Stack: ");
    System.out.println(s.size());
    s.printList();


    System.out.print("Removing from Stacks: ");
    System.out.println(s.pop());
    s.printList();

    System.out.print("Size of Stack: ");
    System.out.println(s.size());
    s.printList();



    /*
    LinkedList ll = new LinkedList();

    // add one item
    ll.add(5);
    ll.add(25);
    ll.add(35);
    ll.add(225);

    System.out.println("Changing Linked List");

    ll.printList();

    boolean retval = ll.remove(15);
    if (retval){
      System.out.println("Found and deleted");
    }
    else{
      System.out.println("Not found");
    }
    retval = ll.remove(25);
    System.out.println("Changing Linked List");
    ll.printList();

    */


    /*

    FOR QUEUE
    Queue q = new Queue();

    q.push(5);
    q.push(6);
    q.push(7);
    q.push(8);

    System.out.println("Printing Queue");
    q.printList();

    System.out.println("Size of Queue");
    System.out.println(q.size());
    q.printList();


    System.out.println("Removing from Queue");
    System.out.print(q.pop());
    q.printList();

    */






  }

}
