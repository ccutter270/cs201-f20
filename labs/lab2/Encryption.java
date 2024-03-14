/******************************

Lab 2: Encryption
Monday, September 21, 2020

********************************/


// Imports
import java.util.Scanner;
import java.lang.*;


// Encryption Class
class Encryption{

  //Attributes
  public String oWord;  //original word
  public String eWord;  //encrypted word
  public String encryptChar; //encrypted characters



    //Constructor
    Encryption(){

      //Get original word
      System.out.println("Enter a word: ");
      Scanner sc = new Scanner(System.in);
      oWord  = sc.next();

      // Get Encryption
      System.out.println("Enter the encryption characters: ");
      Scanner en = new Scanner(System.in);
      encryptChar  = en.next();

      eWord = encrypt();

    }





  //Methods
  public String encrypt(){
    String tempString = "";
    int lenWord = oWord.length();
    for(int iter = 0; iter < lenWord; iter++){
      tempString = tempString + oWord.charAt(iter) + encryptChar;
    }
    return tempString;
  }




  // Main Method
  public static void main(String[] args){

    Encryption main = new Encryption();

    System.out.printf("The original word was %s.\n", main.oWord);
    System.out.printf("The encrypted word is %s.\n", main.eWord);
    }


}
