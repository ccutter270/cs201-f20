/******************************

Lecture 12: Sort - Part 3
Monday, October 5, 2020

********************************/


/*******************************************************************************
Notes:
  - How to implement selection sort
  - What is insertion sort
  - Notes on lecture 12 One Note page

Agenda:
  - Selection Sort
*******************************************************************************/




//Imports
import java.lang.Math;
import java.util.Vector;



class Lecture12{




  //SELECTION SORT
  public static int[] selectionSort(int[] arr){

    //Grab pivot point
    int pivot = arr.length-1;
    int maxvalue = arr[pivot];
    int maxindex = pivot;


    //For each element
    for(int i = 1; i < arr.length; i++){

      //Gets largest value --> puts to end
      for(int j = 0; j < pivot; j++){
        if(arr[j]> maxvalue){
          maxvalue = arr[j];
          maxindex = j;
          }
        }

      //Swapping elem in pivot with max
      int temp = arr[pivot];
      arr[pivot] = arr[maxindex];
      //arr[pivot] = maxvalue;
      arr[maxindex] = temp;

      //House keeping --> increments and sets new pivot
      pivot --;
      maxindex = pivot;
      maxvalue = arr[pivot];

    }
    return arr;
  }



  //MAIN METHOD
  public static void main(String[] args){

    int[] nums = new int[] {12, 22, 18, 4, 6, 11};

    nums = selectionSort(nums);

    for (int elem: nums){
      System.out.println(elem);
    }



  }



}
