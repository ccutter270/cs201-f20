/******************************

Lecture 4: Classes
Wednesday, September 16, 2020

********************************/


/********************************************************
Notes:

  - Must declare field without values if its an attribute of the class

  - Then when in constructor, can initialize value





**********************************************************/



class ModString{

  //fields
  public String s;

 //Constructors
  ModString(String str){


    System.out.println("Creating instance");
    s = str;

  }


// Methods
  void PrintChars(){

    for(int iter = 0; iter < s.length(); iter++){

        System.out.println(s.charAt(iter));


    }


  }



// Main Function
public static void main(String[] args){


    ModString ms = new ModString("Caroline");
    System.out.println(ms.s);
    System.out.println(ms.s.charAt(0));

    ms.PrintChars();



    }

}
