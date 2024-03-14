/******************************

Lecture 10: Sorting
Wednesday, September 30, 2020

********************************/


/*******************************************************************************
Notes:
  - Sorting Algorithms (look at OneNote for notes)

Agenda:
  - Bubble Sort - finished
  - Merge Sort - look at Lecture11.java
*******************************************************************************/




//Imports
import java.lang.Math;
import java.util.Vector;



class Lecture10{


  //METHODS

  //Bubble Sort
  public static int[] bubbleSort(int[] nums){

    int temp;
    for(int j = 1; j< nums.length; j++){
      for (int iter = 1; iter<nums.length; iter++){
        if (nums[iter-1]>nums[iter]){
          temp = nums[iter];
          nums[iter] = nums[iter-1];
          nums[iter-1] = temp;
          }
        }
      }
    return nums;
    }





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


  // MAIN METHOD
  public static void main(String[] args){

    int[] numberArray = {1,5,3,8,3,15,7,6,10};

    numberArray = bubbleSort(numberArray);

    System.out.print("This is the Bubble Sort: \n");
    for (int i = 0; i<numberArray.length; i++){
      System.out.print(numberArray[i]);
      System.out.print("\n");
    }

    int[] numberArray2 = {1,4,3,6,3,15,20,6,10};

    numberArray2 = mergeSort(numberArray2);

    System.out.print("This is the Merge Sort: \n");
    for (int i = 0; i<numberArray2.length; i++){
      System.out.print(numberArray2[i]);
      System.out.print("\n");
    }




  }


}
