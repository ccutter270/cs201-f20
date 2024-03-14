/******************************
Caroline Cutter
Homework 8: Binary Search Trees
Friday, November 13, 2020

Description:
    This program takes in books from a library and adds them to a tree based
    off of their dewey decimal number. The program then can add and remove
    these books accordingly while keeping track of the size of the library.
    The different methods can be seen under the BST class.


  To complile - javac BST.java
  To run -      java Homework8 library.txt
********************************/





class Book{
  public double ddn; // Dewey Decimal Number
  public String author;
  public String title;

  public Book(double _ddn, String _author, String _title){
    ddn = _ddn;
    author = _author;
    title = _title;
  }

 public String toString(){
   String bookString = String.format("Call Number: %.3f, %s, \"%s\"", ddn, author, title);
   return bookString;
 }
}




public class BST{

  private int size;
  public Node root;

  class Node{
    Book data;
    Node parent;
    Node left, right;

    public Node(Book book){
      data = book;
      parent = null;
      left = null;
      right = null;
      }
    }

  public BST(){
    size = 0;
    root = null;
  }



  // printRecursion(Node curr) - Uses recursion to print out the books in the
    //tree according to lowest decimal to highest
  public void printRecursion(Node curr) {
    //current starts of as root, then continues until null
    if(curr != null){
      printRecursion(curr.left);
      System.out.printf("The Call Number is: %.3f, %s, \"%s\" \n", curr.data.ddn, curr.data.author, curr.data.title);
      printRecursion(curr.right);
      }
    }

  //print() - uses printRecursion to print all the nodes starting at root
  public void print(){

    printRecursion(root);

  }



  //size() - returns the size of the current library
  public int size(){
    return size;
  }



  //add() - adds a new book to a binary search tree in order based of decimal number
  public void add(Book book){

    Node newnode = new Node(book);
    Node curr = root;
    boolean placed = false;

    if (curr == null){
      root = newnode;
      placed = true;
    }

    while(placed == false && curr != null){

      //right
      if (newnode.data.ddn > curr.data.ddn){
        if(curr.right == null){
          curr.right = newnode;
          newnode.parent = curr;
          placed = true;
        }
        else{
          curr = curr.right;
        }
      }
    //left
    else{
      if(curr.left == null){
        curr.left = newnode;
        newnode.parent = curr;
        placed = true;

      }
      else{
        curr = curr.left;
        }
      }
    }
    if(placed == true){
      size++;

    }
  }



  //remove() - removes books from the binary search tree and adjust the tree
    //according to the 4 rules of removal and returns the removed book
  public Book remove(double ddn){

    Node curr = root;
    boolean found = false;


    //Find the value being removed and sets as current
    while(curr != null && found == false){
      if(curr.data.ddn == ddn){
        found = true;
      }
      else{
        if(ddn < curr.data.ddn){
          curr = curr.left;
          }
        else{
          curr = curr.right;
          }
        }
    }

    //Book that is being removed
    Book removedBook = new Book(curr.data.ddn, curr.data.author, curr.data.title);


    //Rule 1/2: if node doesn't have a child
    if(curr.left == null && curr.right == null){

      //RULE 1: if the node book being removed is the last in the list
      if(curr.parent == null){
        root = null;
        }

      //RULE 2: if the node has no childeren but is not the last in the list
      else{
        if(curr.parent.right != null && curr.parent.right.data.ddn == ddn){
          curr.parent.right = null;
        }
        else{
          curr.parent.left = null;
        }
      }
      size--;
      return removedBook;
    }
    else{

      //Rule 3: if node has one child (either left or right)
      if((curr.left != null && curr.right == null) || (curr.right != null && curr.left == null)){

        //If node has left child
        if((curr.left != null && curr.right == null)){

          //If value being removed is root of tree
          if(curr == root){
            root = curr.left;
            root.parent = null;
            curr = null;
          }
          //If not root of the tree, shift accordingly
          else{
            //If value is right of parent
            if(curr.parent.right != null && curr.parent.right.data.ddn == ddn){
              curr.parent.right = curr.left;
              curr.left.parent = curr.parent;
            }
            //If value is left of parent
            else{
              curr.parent.left = curr.left;
              curr.left.parent = curr.parent;
            }
          }
        }


        //If node has right child
        else{

          //If value being removed is the root
          if(curr == root){
            root = curr.right;
            root.parent = null;
            curr = null;
          }
          //If value being removed is not the root
          else{

            //If right of parent
            if(curr.parent.right != null && curr.parent.right.data.ddn == ddn){
              curr.parent.right = curr.right;
              curr.right.parent = curr.parent;
              }
              //If left of parent
            else{
              curr.parent.left = curr.right;
              curr.right.parent = curr.parent;
            }
          }
        }
      }


      //Rule 4: If node has 2 children
      else{

        Node removal = curr;

        //CURRENT IS GOING TO BE THE GREATEST NUMBER
        //REMOVAL IS THE VALUE BEING REMOVED

        curr = curr.left;

        ///If you can't iterate right
        if(curr.right == null){

          //If its the root
          if(removal.parent == null){
            curr.right = removal.right;
            removal.right.parent = curr;
            curr.parent = null;
            root = curr;
            }
          //If its not the root
          else{
            //If value is right of parent
            if(removal.parent.right != null && removal.parent.right.data.ddn == ddn){
              removal.parent.right = curr;
              }
            //If value is left of parent
            else{
              removal.parent.left = curr;
            }

            curr.parent = removal.parent;

            //Move removed value has right value, then assign it to right of current
            if(removal.right != null){
              curr.right = removal.right;
              removal.right.parent = curr;
              }
            }
          }

        //If you can iterate right
        else{

          //Iterate to the greatest calue
          while(curr.right != null){
            curr = curr.right;
            }

          //NOW curr is the greatest value on the left side

          //If curr is the root of the tree
          if(removal.parent == null){

              curr.parent.right = curr.left;

              removal.right.parent = curr;

              removal.left.parent = curr;
              curr.left = removal.left;
              curr.right = removal.right;
              curr.parent = null;

              root = curr;
          }
          //If curr is not the root of the tree
          else{

            //If it is to the right of parent, make curr the new right
            if(removal.parent.right != null && removal.parent.right.data.ddn == ddn){
              removal.parent.right = curr;
              }
            //If it is to the left of parent, make curr the new left
            else{
              removal.parent.left = curr;
            }

            //If curr has something to the left, make it the new right of parent
            if(curr.left != null){
              curr.parent.right = curr.left;
            }
            //If not, make right of parent null
            else{
              curr.parent.right = null;
            }

            //Make current the new value where removed was
            curr.parent = removal.parent;

            removal.left.parent = curr;
            removal.right.parent = curr;

            curr.right = removal.right;
            curr.left = removal.left;
          }
        }
      }
      size--;
      return removedBook;
    }
  }



  //isAvailable() - takes in a dewey decimal and returns true if it is in the
    //library and false if it is not
  public boolean isAvailable(double ddn){

    //boolean found = false;
    Node curr = root;

    while(curr != null){
      if(curr.data.ddn == ddn){
        return true;
      }

      else{
        if(ddn < curr.data.ddn){
          curr = curr.left;
        }
        else{
          curr = curr.right;
        }
      }
    }
    return false;
  }





}
