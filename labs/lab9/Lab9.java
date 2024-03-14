/******************************

Caroline Cutter
Lab 10: Overrides and Separate Compilation
Monday, November 16, 2020

********************************/


import java.util.Scanner;
import java.io.File;



//DNA class holds my methods
class DNA{


  //numSubsequences - takes in sequence and substring and finds # of occurances of it
  public int numSubsequences(String seq, String sub){

    int count = 0;

    //Base Case
    if(seq.length() == sub.length()){
      if(seq.equals(sub)){
        return 1;
      }
      else{
        return 0;
      }
    }
    //recursive case
    else{
      if(seq.startsWith(sub)){
        count++;
      }
      count += numSubsequences(seq.substring(1), sub);
      return count;
    }
  }


  //mostCommon - finds the most common substring of inputted length in input sequence
  public void mostCommon(String seq, int min){

    String maxSeq = "";
    int maxSeqOccur = 0;
    String sub = "";
    int start = 0;

    //for each iteration
    for(int iter = 0; iter<(seq.length()-min); iter++){
      sub = seq.substring(start, start+min);
      if(numSubsequences(seq, sub) > maxSeqOccur){
        maxSeqOccur = numSubsequences(seq, sub);
        maxSeq = sub;
      }
      start++;
    }
      if(maxSeqOccur <= 1){
        System.out.println("A string of sufficient length was not found!\n");
      }
      else{
        System.out.printf("\"%s\" occurs %d times.\n\n", maxSeq, maxSeqOccur);
      }

  }


}



//Lab9 class holds my main method
class Lab9{

  //MAIN METHOD
  public static void main(String[] args){

    //ATTRIBUTES
    File file = new File(args[0]);
    String sequence = "";
    DNA dna = new DNA();


    //Reads file
    try{
      Scanner scanner = new Scanner(file);
      sequence = scanner.nextLine();
    }catch(Exception e){
      System.out.println(e);
      }

    //GET SUBSTRING
    System.out.print("Enter a search sequence: ");
    Scanner sc1 = new Scanner(System.in);
    String substring = sc1.next();


    //NUMBER OF OCCURANCES
    int occur = dna.numSubsequences(sequence, substring);
    System.out.printf("This sequence appears %d times.\n\n", occur);


    //GET MINIMUM VALUE
    System.out.print("Enter the minimal length for subsequence:  ");
    Scanner sc2 = new Scanner(System.in);
    int minLength = sc2.nextInt();

    //FIND MOST COMMON
    dna.mostCommon(sequence, minLength);

  }
}
