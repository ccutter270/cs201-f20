/******************************

Lecture 21: Exam Review
Monday, October 26, 2020

********************************/



/*******************************************************************************
Notes:
  - Look at exam on Canvas for correct answers, One Note for wrong Answers


*******************************************************************************/





class ExamReview{



  public static int sumDigits(int n){

    if (n==0){
      return 0;
      }
      else{
        return (n%10 + sumDigits(n/10));
      }

    }


  public static int smallestNumber(Vector<Integer> v){

    //Base Case
    if (v.size() ==1){
      return v.get(0);
    }
    // Keep going
    else{



    }




  }










  public static void main(String[] args){

    System.out.println(sumDigits(421));



  }




}
