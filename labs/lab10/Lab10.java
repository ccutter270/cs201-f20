/******************************

Caroline Cutter
Lab 10: Overrides and Separate Compilation
Monday, November 16, 2020

********************************/


import java.util.Scanner;


class Lab10{

  public static void main(String args[]){

    //Getting Args

    System.out.print("Enter a radius:  ");
    Scanner scanner = new Scanner(System.in);
    double length = scanner.nextDouble();

    System.out.print("Enter the number of iterations:  ");
    Scanner scanner2 = new Scanner(System.in);
    int numIterations= scanner2.nextInt();



    //METHOD 1

    Circle c1 = new Circle(length, numIterations);
    c1.pi();


    //METHOD 2

    Circle c2 = new Circle(length, numIterations){
      @Override double pi(){

        double total = 3;
        int den = 2;
        boolean add = true;
        for(int i = 0; i<=numIterations; i++){
          if(add == true){
            total += (double)4/(den*(den+1)*(den+2));
            add = false;
          }
          else{
            total -= (double)4/(den*(den+1)*(den+2));
            add = true;
          }

          den += 2;
        }

        System.out.printf("Area using method 2: %.5f\n", area(total));
        return total;

      }
    };
    c2.pi();

  }
}
