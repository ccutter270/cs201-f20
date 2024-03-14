/******************************

Caroline Cutter
Lab 7: File Reading
Monday, October 26, 2020

********************************/


import java.util.Scanner;
import java.lang.Math;
import java.util.Vector;
import java.io.File;


class VotingMachine{



  //ATTRIBUTES
  public String fips;
  public String state;
  public String county;
  public String municipality;
  public String first_range;
  public String equipment;
  public String machine;
  public String trail;
  public String mail;



  //CONSTRUCTOR - takes in array of data and sets each data
  public VotingMachine(String[] votingData){
    fips = votingData[0];
    state = votingData[1];
    county = votingData[2];
    municipality = votingData[3];
    first_range = votingData[4];
    equipment = votingData[5];
    machine = votingData[6];
    trail = votingData[7];
    mail = votingData[8];
  }




  //METHODS

  //toString - formats each object of VotingMachine
  public String toString(){
    return fips + ", " + state + ", " + county + ", " + municipality + ", " + first_range + ", " + equipment + ", " + machine + ", " + trail + ", " + mail;
  }

}





class Lab7{


  //Main Method
  public static void main(String[] args){

    //ATTRIBUTES
    Vector<String> votingErrors = new Vector<String>();
    Vector<VotingMachine> votingVector = new Vector<VotingMachine>();
    int totalErrors = 0;
    File file = new File("votingdata.txt");



    //Scanner scanner = new Scanner(new File("votingdata.txt"));
    try{
      Scanner scanner = new Scanner(file);

      while (scanner.hasNextLine()) {
        //Creates an array of data for each line then passes to VotingMachine
        //to create a Vector of obects of VotingMachine
        String line = scanner.nextLine();
        String[] splitLine = line.split(",");

        try{
          //If not right amount of arguments
          if (splitLine.length != 9){
            throw new IllegalArgumentException("Invalid number of arugments for VotingData class.");
            }

          VotingMachine votingMachine = new VotingMachine(splitLine);
          votingVector.add(votingMachine);


        }catch (Exception e){
          String exceptionString = e.toString() + "\n" + line;
          votingErrors.add(exceptionString);
          totalErrors+=1;
          }
      }

      //Print out exceptions & how many exceptions
      System.out.printf("\n");
      for(int i = 0; i<votingErrors.size(); i++){
        System.out.println(votingErrors.get(i));
        System.out.println("\n");
        }

      System.out.printf("\nThe file contained %d errors.\n", totalErrors);


      //Asking user if they want to display all the entries
      System.out.print("Display entries (y/n):  ");
      Scanner sc = new Scanner(System.in);
      String display = sc.next();

      //If they want to display the items - print each object
      if (display.equals("y")  || display.equals("Y")){
        for(int iter = 0; iter<votingVector.size(); iter++){
          System.out.println(votingVector.get(iter));
          }
        }

    //If there is a file error
    }catch(Exception ex){
      System.out.print(ex);
    }

  }

}
