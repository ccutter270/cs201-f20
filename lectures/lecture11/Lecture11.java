/******************************

Lecture 11: Sorting (part 2)
Friday, October 2, 2020

********************************/


/*******************************************************************************
Notes:
  - Sorting Algorithms (look at OneNote for notes)

Agenda:
  - Merge Sort
*******************************************************************************/




//Imports
import java.lang.Math;
import java.util.Vector;



class Lecture11{


  //Merge Sort - Merge & sort recursive
  public static int[] mergeSort(int[] arr){

    int size = arr.length;

    //Base Case
    if (size <= 1){
      return arr;
      }

    //Recursive Case
    else{

      int [] left = new int[size/2];
      int[] right = new int [size - size/2];


      //Make left list
      for (int i = 0; i<size/2; i++){
        left[i] = arr[i];
      }

      //Make right list
      for (int i = 0; i < (size-size/2); i++){
        right[i] = arr[i + size/2];
      }




      //Sort left half of list
      int [] l = mergeSort(left);
      //Sort right half of list
      int [] r = mergeSort(right);

      //merge the sorted list
      return merge(l,r);
      }
    }

  //Merge function
  public static int[] merge(int[] left, int[] right){

    int[] merged = new int[left.length + right.length];

    int liter = 0;
    int riter = 0;
    int miter = 0;



    while (liter < left.length && riter < right.length){
      if (left[liter] < right[riter]){
        merged[miter] = left[liter];
        liter++;
        miter++;
        }
      else{
        merged[miter] = right[riter];
        riter++;
        miter++;
      }
    }


      // the left array is empty
      if (liter >= left.length){
        while(riter < right.length){
          merged[miter] = right[riter];
          miter++;
          riter++;
          }
        }
      if (riter >= right.length){
        while(liter < left.length){
          merged[miter++] = left[liter++];
          //miter++;
          //riter++;
          }
        }

    return merged;
  }






}
