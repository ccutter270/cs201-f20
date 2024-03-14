/******************************

Lecture 22: Priority Queues
Wednesday, October 28, 2020

********************************/



/*******************************************************************************
Notes:
  - Look at OneNote for priority Queues


  - How to use recursion to print out linked lists - function printListRec



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

    //List empty
    if (head == null){
      head = newnode;
      tail = newnode;
      }

    //List has values
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



  public void printListRec(Node n){



    //Base Case
    if(n == null){
      return;
      //System.out.println(n.data);
    }
    else{
      System.out.println(n.data);
      printListRec(n.next);
    }



  }


  public boolean remove(int val){

    Node curr = null;
    Node prev = null;

    //If we want to remove head (list lenght = 1)
    if(head != null && head.data == val){

      //If only one item in list
      if( head == tail){
        head = null;
        tail = null;
        }
      //If list length is greater than 1
      else{
        head = head.next;
        head.prev = null;
        }

    }

    //If looking for an item not the head
    else{
      curr = head.next;
      prev = head;

      //continue until found item or reach end of list
      while(curr != null && curr.data != val){
        prev = curr;
        curr = curr.next;
        }

      //if found it
      if(curr != null){

        //if last one itme in list
        if (curr == tail){
          tail = prev;
          tail.next = null;
          }
        // Found something thats not the last item
        else{
          prev.next = curr.next;
          curr.next.prev = prev; //look at day 19 notes for clarification
          }
        }
      else{
        //Item not found
         return false;
          }

      }
      return true;
    }



  }








class Lecture22{

  public static void main(String[] args){

    LinkedList ll = new LinkedList();

    ll.add(5);
    ll.add(10);
    ll.add(15);


    ll.printListRec(ll.head);



  }


}
