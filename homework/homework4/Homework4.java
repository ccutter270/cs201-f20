/******************************************************************************
Caroline Cutter
Homework 4: Sorting
Friday, October 9, 2020

Explaination:

Part 1:
  This program sorts a arrays with three different sort algorithms (Bubble,
  Selection & Insertion). It takes in a length of an array and the maximum
  value of that array and then creates a random array to sort. Then, the
  unsorted array and all three sorted arrays are printed, along with the
  numbers of comparisons and assignment each sorting algorithm took to sort.

Part 2:
  This program takes the users input for height, width, and max value of a
  two dimensional array and then creates a random array. Then, the array rows
  are sorted, then the arrays columns are sorted. The sorted & unsorted
  arrays are both printed.

Questions:
  - is it okay if I use selection sort as a different method?
  - My bubble sort is okay, but my insertion and selction have different
    assingment values, is this okay?

*******************************************************************************/


// IMPORTS
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;





//Sorting Class
class Sort{


  //ATTRIBUTES

  //Part 1
  public int array1length;
  public int maxValue1;
  public int[] arrayPart1;
  //Insertion
  public int[] insertArray;
  //Selection
  public int[] selectionArray;
  //Bubble
  public int[] bubbleArray;


  //Part 2
  public int array2rows;
  public int array2cols;
  public int[][] arrayPart2;
  public int maxValue2;




  //CONSTRUCTOR
  Sort(){

    //Part 1
    getInputPart1();
    createArrayPart1();
    printUnsortedArray1();


    insertArray = insertionSort(arrayPart1);
    selectionArray = selectionSort(arrayPart1);
    bubbleArray = bubbleSort(arrayPart1);

    printTable();


    //Part 2
    getInputPart2();
    createArrayPart2();
    printUnsortedArray2();
    twoDSelectionSort(arrayPart2);


  }



  //METHODS


  //PART 1 METHODS


  //getInputPart1 - gets array lengths and maximum value from user for part 1
  public void getInputPart1(){

    //Ask user for length of Array
    System.out.printf("\nPart 1\nEnter an array length:  ");
    Scanner sc1 = new Scanner(System.in);
    array1length = sc1.nextInt();

    System.out.printf("Enter the maximum value:  ");
    Scanner sc2 = new Scanner(System.in);
    maxValue1 = sc2.nextInt();

  }


  //createArrayPart1 - creates random array with users inputs for part 1
  public void createArrayPart1(){

    Random random = new Random();

    arrayPart1 = new int[array1length];

    for(int i = 0; i<array1length; i++){
      arrayPart1[i] = random.nextInt(maxValue1 + 1);
    }
  }


  //printUnsortedArray1 - prints the unsorted random array for part 1
  public void printUnsortedArray1(){
    System.out.print("\nUnsorted Array: \n");
    for (int iter = 0; iter<arrayPart1.length; iter++){
      System.out.printf("%d ", arrayPart1[iter]);
    }
    System.out.print("\n\n");
  }


  //bubbleSort - bubble sorts array, prints sorted array & returns array of
    //comparisons & assingments
  public int[] bubbleSort(int[] array){

    int[] arr = array.clone();

    int size = arr.length;
    int numsorted = 0;
    int temp = 0;
    int bubbleComparison = 0;
    int bubbleAssignment = 0;
    boolean swapped = true;


    for(int i = 1; i < size && swapped; i++){
      swapped = false;

      for (int j = 1; j < (size-numsorted); j++){

        if(arr[j-1] > arr[j]){
          temp = arr[j];
          arr[j] = arr[j-1];
          arr[j-1] = temp;
          bubbleAssignment += 3;
          //if still unsorted, else will stop the loop
          swapped = true;

          }
          bubbleComparison ++;
        }
        numsorted++;
      }

        //Print out
        System.out.print("Bubble Sort: \n");
        for (int iter = 0; iter<arr.length; iter++){
          System.out.printf("%d ", arr[iter]);
        }
        System.out.print("\n\n");


      int[] bubbleNums = {bubbleComparison, bubbleAssignment};
      return bubbleNums;



  }


  //selectionSort - slection sorts array, prints sorted array & returns array of
    //comparisons & assingments
  public int[] selectionSort(int[] array){

    int[] arr = array.clone();
    int selectionComparsion = 0;
    int selectionAssignment = 0;


    //Grab pivot point
    int pivot = arr.length-1;
    int maxvalue = arr[pivot];
    int maxindex = pivot;
    selectionAssignment += 3;


    //For each element
    for(int i = 1; i < arr.length; i++){


      //Gets largest value --> puts to end
      for(int j = 0; j < pivot; j++){
        selectionComparsion++;
        if(arr[j]> maxvalue){
          maxvalue = arr[j];
          maxindex = j;
          selectionAssignment++;
          }
        }

      //Swapping elem in pivot with max
      int temp = arr[pivot];
      arr[pivot] = maxvalue;
      arr[maxindex] = temp;

      //House keeping --> increments and sets new pivot
      pivot --;
      maxindex = pivot;
      maxvalue = arr[pivot];

      selectionAssignment += 2;
    }

    //Print out
    System.out.print("Selection Sort: \n");
    for (int iter = 0; iter<arr.length; iter++){
      System.out.printf("%d ", arr[iter]);
    }
    System.out.print("\n\n");


    int[] selectionNums = {selectionComparsion, selectionAssignment};
    return selectionNums;
  }


  //insertionSort - insertion sorts array, prints sorted array & returns array
    //of comparisons & assingments
  public int[] insertionSort(int[] array){

    int[] arr = array.clone();
    int size = array.length;
    int insertComparison = 0;
    int insertAssignment = 0;


    for(int i = 1; i < size; i++) {

      int firstUnsorted = i;
      insertAssignment++;

      insertComparison+=2;

      //While unsorted index is still smaller than sorted & not 0
      while ((firstUnsorted > 0) && (arr[firstUnsorted] < arr[firstUnsorted-1])){

        //switch
        int temp = arr[firstUnsorted];
        arr[firstUnsorted] = arr[firstUnsorted-1];
        arr[firstUnsorted-1] = temp;

        insertAssignment++;
        insertComparison++;

        firstUnsorted--;
      }

    }

      //Print out
      System.out.print("Insertion Sort: \n");
      for (int iter = 0; iter<arr.length; iter++){
        System.out.printf("%d ", arr[iter]);
      }
      System.out.print("\n\n");


      int[] insertionNums = {insertComparison, insertAssignment};
      return insertionNums;


    }


  //printTable - prints table of comparisons & assingments for part 1
  public void printTable(){
    System.out.printf("\t   Comparisons\tAssingments\n");
    System.out.printf("Insertion:%12d %12d\n", insertArray[0], insertArray[1]);
    System.out.printf("Selection:%12d %12d\n", selectionArray[0], selectionArray[1]);
    System.out.printf("Bubble:%15d %12d\n", bubbleArray[0], bubbleArray[1]);
    }






  //PART TWO METHODS

  //getInputPart2 - gets height, width & max value from the user for part 2
  public void getInputPart2(){

    //Ask user for length of Array
    System.out.printf("\n\nPart 2\nEnter an array height (rows):  ");
    Scanner sc3 = new Scanner(System.in);
    array2rows = sc3.nextInt();

    System.out.printf("Enter an array width (cols):  ");
    Scanner sc4 = new Scanner(System.in);
    array2cols = sc4.nextInt();

    System.out.printf("Enter the maximum value:  ");
    Scanner sc5 = new Scanner(System.in);
    maxValue2 = sc5.nextInt();


  }

  //createArrayPart2 - creates random 2D array with user inputs for part 2
  public void createArrayPart2(){

    Random random = new Random();

    arrayPart2 = new int[array2rows][array2cols];

    for(int i = 0; i < array2rows; i++){
      for(int j = 0; j < array2cols; j++){
        arrayPart2[i][j] = random.nextInt(maxValue2 + 1);
      }
    }
  }


  //printUnsortedArray2 - prints unsorted array for part 2
  public void printUnsortedArray2(){
    System.out.print("\n\nUnsorted: \n\n");
    for(int iter = 0; iter < array2rows; iter++){
      for(int iter2 = 0; iter2 < array2cols; iter2++){
        System.out.printf(" %4d", arrayPart2[iter][iter2]);
      }
      System.out.print("\n\n");
    }
  }


  //selectSort - selection sorts an array, returns the sorted array
  public int[] selectSort(int[] arr){

    int pivot = arr.length - 1;
    int maxvalue = arr[pivot];
    int maxindex = pivot;

    for(int i = 1; i < arr.length; i++){
      for (int j = 0; j < pivot; j++){

        // if the value at arr[j] is greater than our pivot
        // switch the value with the pivots value.
        if(arr[j] > maxvalue){
          maxindex = j;
          maxvalue = arr[j];
        }
      }
      int temp = arr[pivot];
      arr[pivot] = maxvalue;
      arr[maxindex] = temp;
      pivot--;
      maxindex = pivot;
      maxvalue = arr[pivot];
    }

    return arr;
  }


  //twoDSelectionSort - selection sorts a 2D array, prints out sorted array
  public void twoDSelectionSort(int [][] array){

    //FIRST - sort the rows
    for (int row = 0; row<array.length; row++){
      array[row] = selectSort(array[row]);
      }


    //SECOND - Sort Columns

    int[] unsortedColumn = new int[array2rows];

    //Put unsorted row in an array
    for(int col = 0; col<array2cols; col++){
      for(int row = 0; row<array2rows; row++){
        unsortedColumn[row] = array[row][col];
        }

      //Sort the unsored column
      int[] sortedColumn = selectSort(unsortedColumn);

      //Place the sorted back into the column
      for(int row = 0; row<array2rows; row++){
        array[row][col] = sortedColumn[row];
        }
      }

    //Print Array
    System.out.print("\n\nSorted: \n\n");
    for(int row = 0; row < array2rows; row++){
      for(int col = 0; col < array2cols; col++){
        System.out.printf(" %4d", array[row][col]);
      }
      System.out.print("\n\n");
    }
  }

}






class Homework4{

  //Main Method
  public static void main(String[] args){

    Sort sort = new Sort();

    }

}
