/******************************
Caroline Cutter
Homework 9: Emergency Room
Sunday, November 22, 2020

Description: This program simulates a witing room in an ER using minHeap to
             prioritize patients based on arrival time and symptoms. Patients
             are dequeued when doctors become available and added to the heap
             based on when they arrive.

 !!!!!!

  My program output is a little different from the sample because I accounted
  for arrival time in my priority Queue, so people with the same symptom but
  arrived earlier would be considered higher on the priorty Heap.

!!!!!


  To complile - javac Homework9.java
  To run -      java Homework9 Patients.txt SymptomInfo.txt
********************************/

//Imports
import java.util.Vector;
import java.util.Scanner;
import java.io.File;


class MinHeap{


  //ATTRIBUTES
  Vector<Patient> minHeap;


  //CONSTRUCTOR
  public MinHeap(){
    minHeap = new Vector<Patient>(1);
    minHeap.add(null);
  }


  //METHODS

  //addPatient() - adds patient to the vector miniHeap, percolates ip if necessary
  public void addPatient(Patient patient){

    minHeap.add(patient);
    int patientPos = minHeap.size() - 1;

    //Percolate up if necessary
    percolateUp(patientPos);

  }


  //percolateUp() - moves newly inserted patient to correct position by recursively percolating up
  public void percolateUp(int childPos){

    //New node
    Patient child = minHeap.get(childPos);
    int childPriority = child.priority;

    //Parent of the node
    int parentPos = childPos / 2;
    Patient parent = minHeap.get(parentPos);

    //If the new node of the tree has a parent
    if(parent != null){

      int parentPriority = parent.priority;

      //If smaller than parent, swap and percolate up again
      if(childPos > 0 && childPriority < parentPriority){

        //Swap
        minHeap.set(childPos, parent);
        minHeap.set(parentPos, child);

        //percolate up
        percolateUp(parentPos);
        }
      }
    }



  //remove()- removes head (highest priority) patient from miniHeap and returns it,
    //moves lowest value to the head and percolates down as necessary
  public Patient remove(){

    //If nothing is in the heap
    if(minHeap.size() == 1){
      return null;
      }
    else{
      Patient removal = minHeap.get(1);

      //Move last node to the top
      int lastIndex = minHeap.size() - 1;
      Patient lastElement = minHeap.get(lastIndex);
      minHeap.set(1, lastElement);
      minHeap.remove(lastIndex);

      //Percolate down
      percolateDown(1);

      //Return removed value
      return removal;
    }
  }



  //percolateDown() - recursively percolates new head down patient to correct position
  public void percolateDown(int parentPos){

    //If parent has childeren
    if(parentPos < minHeap.size()){

      //Patient and Priority to be percolated down
      Patient parent = minHeap.get(parentPos);
      int parentPriority = parent.priority;

      //Left and Right child positions
      int leftPos = parentPos * 2;
      int rightPos = (parentPos * 2) + 1;

      //Set current as smallest, will change if childeren are smaller
      int smallestPos = parentPos;
      Patient smallest = parent;
      int smallestPriority = parentPriority;


      //If Left Leaf is smaller priority or same
      if(leftPos < minHeap.size() && minHeap.get(leftPos).priority <= smallestPriority){

        //If left leaf has same priority, check which arrival time is earlier
        if(minHeap.get(leftPos).priority == smallestPriority){

          //If left has earlier arrival time, make left smaller
          if(minHeap.get(leftPos).arrival < smallest.arrival){
            smallestPos = leftPos;
            smallest = minHeap.get(leftPos);
            smallestPriority = smallest.priority;
            }
          }
        //If left leaf has smaller priority, make left smaller
        smallestPos = leftPos;
        smallest = minHeap.get(leftPos);
        smallestPriority = smallest.priority;
      }

      //If Right Leaf is smaller priority or same
      if(rightPos < minHeap.size() && minHeap.get(rightPos).priority <= smallestPriority){

        //If right leaf has same priority, check which arrival time is earlier
        if(minHeap.get(rightPos).priority == smallestPriority){

          //If right has earlier arrival time, make right smaller
          if(minHeap.get(rightPos).arrival < smallest.arrival){
            smallestPos = rightPos;
            smallest = minHeap.get(rightPos);
            smallestPriority = smallest.priority;
            }
          }
        //If right leaf has smaller priority, make right smaller
        smallestPos = rightPos;
        smallest = minHeap.get(rightPos);
        smallestPriority = smallest.priority;
      }

      //If the smallest was not the parent, switch and percolate again
      if(smallestPos != parentPos){

        //Switch
        minHeap.set(parentPos, smallest);
        minHeap.set(smallestPos, parent);

        //Percolate again
        percolateDown(smallestPos);
      }
    }
  }


  //printHeap() - prints current heap (used for debugging)
  public void printHeap(){
    for(int i = 1; i<minHeap.size(); i++){
      System.out.println(minHeap.get(i));
      }
  }
}




class Patient{


 //ATTRIBUTES
 String name;
 String symptom;
 int arrival;
 int priority;
 int duration;
 int doctorID;


 //CONSTRUCTOR
 public Patient(String[] patients, Vector<String[]> symptoms){

   doctorID = -1;
   name = patients[0];
   symptom = patients[1];
   arrival = Integer.parseInt(patients[2]);

   //Finds symptom priority and duration of time with doctor
   for(int iter = 0; iter<symptoms.size(); iter++){
     String[] symptomInfo = symptoms.get(iter);

     //If same symptom, get priority and duration
     if(symptomInfo[0].equals(symptom)){
       priority = Integer.parseInt(symptomInfo[1]);
       duration = Integer.parseInt(symptomInfo[2]);
      }
    }
  }


// toString() - formats how to print Patient
 public String toString(){

   String arrival_string = "";

   //Formats time
   if(arrival >= 1000){
     arrival_string = String.format("%d", arrival);
     }
   else{
    arrival_string = String.format("0%d", arrival);
    }
   return String.format("Dr. 0%d Patient: %-10s Reason: %-14s Arrival: %s |", doctorID, name, symptom, arrival_string);
  }

}




class Doctor{

  //ATTRIBUTES
  int id;
  int timeLeft;


  //CONSTRUCTOR
  public Doctor(int id_){
    id = id_;
    timeLeft = 0;
  }

  //isAvailable() - returns true if doctor is available, false if not
  public boolean isAvailable(){
    if(timeLeft <= 0){
      return true;
    }
    return false;
  }


  //seePatient() - "sees" a patient by taking them in, changing thier doctor ID
    //and "sees" them for duration of symptom
  public void seePatient(Patient patient){
    //Increases time left to duration with patient
    timeLeft = patient.duration;
    //Sets patients doctor ID
    patient.doctorID = id;
  }

}






class Homework9{


  public static void main(String[] args){

    //ATTRIBUTES
    Vector<String[]> symptoms = new Vector<String[]>();
    Vector<String[]> patientsInfo = new Vector<String[]>();
    Vector<Patient> patients = new Vector<Patient>();
    Vector<Doctor> doctors = new Vector<Doctor>();


    File file = new File(args[0]);
    File file1 = new File(args[1]);

    int numDoctors = 0;
    boolean gotDoctors = false;
    int doctorID = 0;
    int currentTime = 815;

    int patientSeen = 0;
    MinHeap heap = new MinHeap();



    //GETTING NUMBER OF DOCTORS
    System.out.println("Welcome to the CSCI 201 Emergency Room.");
    System.out.print("Enter the number of doctors on call:  ");

    while(gotDoctors == false){
      try{
        Scanner sc = new Scanner(System.in);
        numDoctors  = sc.nextInt();
        //If 0 Doctors, make them re-enter number
        if(numDoctors <= 0){
          throw new IllegalArgumentException();
        }
        gotDoctors = true;
      }catch(Exception ex){
        System.out.print("Invalid number. Please reenter:  ");
      }
    }


    //MAKING DOCTOR VECTOR
    for(int iter1 = 0; iter1 < numDoctors; iter1++){
        Doctor doctor = new Doctor(doctorID);
        doctors.add(doctor);
        doctorID++;
      }



    //READING FILES
    try{

      //PATIENTS
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {

        String line = scanner.nextLine();
        String[] split = line.split(" ");
        // Array Order: {Name, Symptom, Arrival Time}
        patientsInfo.add(split);
      }

      //SYMPTOMS
      Scanner scanner1 = new Scanner(file1);
      while (scanner1.hasNextLine()) {

        String line1 = scanner1.nextLine();
        String[] split1 = line1.split(" ");
        // Array Order: {Symptom, Priority, Duration}
        symptoms.add(split1);
      }
    }catch(Exception e){
      System.out.println(e);
      }




    //MAKING PATIENTS FROM FILE DATA, ADDING TO PATIENTS VECTOR
    for(int ii = 0; ii< patientsInfo.size(); ii++){
      Patient patient = new Patient(patientsInfo.get(ii), symptoms);
      patients.add(patient);
      }




    //QUEING THE PATIENTS BASED OFF ARRIVAL TIME, RELEASING TO DOCTORS WHEN AVAILABLE


    //While there are still patients to see
    while(patientSeen < patients.size()){

      //For each patient, add to heap if arrival time == current time
      for(int iter3 = 0; iter3 < patients.size(); iter3++){
        Patient patient = patients.get(iter3);
        if(patient.arrival == currentTime){
          heap.addPatient(patient);
        }
      }


      //CHECK EACH DOCTORS AVAILABILITY
      for(int iter2 = 0; iter2 < doctors.size(); iter2++){

        Doctor doctor = doctors.get(iter2);

        //If the doctor is available
        if(doctor.isAvailable() == true){

          //Take first patient from heap, only if there are patients in heap
          if(heap.minHeap.size() > 1){

            Patient removal = heap.remove();
            doctor.seePatient(removal);
            patientSeen ++;
            doctor.timeLeft -= 5;

            //PRINT OUT PATIENT AND TIME THEY WERE SEEN BY DOCTOR
            System.out.print(removal);
            System.out.printf("Current: %d\n", currentTime);
            }
          }

        //If doctor is not available, subtract 5 mins from time left with patient
        else{
          doctor.timeLeft -= 5;
        }
      }

      //If it is at the end of the hour (:55), add 45 to make it next hour,
      String curTimeStr = Integer.toString(currentTime);
      if((curTimeStr.substring(curTimeStr.length() - 2)).equals("55")){
        currentTime += 45;
        }
      else{
        currentTime += 5;
        }
      }
    }
}
