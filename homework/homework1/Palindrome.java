/****************************

Caroline Cutter
Homework 1
Problem 1: Palindrome
*******************************/



// Imports
import java.util.Scanner;
import java.lang.*;




// Class definition
class Palindrome{


	//Main Method

	public static void main(String[] args){

		System.out.println("Enter a string: ");

		Scanner sc = new Scanner(System.in);
		String originalWord = sc.nextLine();

		String word = originalWord.toLowerCase().replaceAll(" ", "");

		//Making reverse word
		int wordLength = word.length();
		String wordReverse = "";
		while (wordLength > 0){
			wordReverse += word.charAt(wordLength-1);
			wordLength--;
			}

			if (wordReverse.equals(word)){
    		System.out.printf("%s is a palindrome!\n", originalWord);
  			}
  		else{
    		System.out.printf("%s is not a palindrome\n", originalWord);
  			}


		}

}
