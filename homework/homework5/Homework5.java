/******************************************************************************
Caroline Cutter
Homework 5: Inheritance
Friday, October 16, 2020

Explaination:

Part 1:
  This part of the program asks the user for an imput of a shape, then asks
  the demensions of the shape and returns the area and the perimeter.

Part 2:
  This part of the program takes how many shapes the user wants to create,
  creates random shapes with random dimensions in a range specified by the user
  and prints out each of these shapes. This also stores all these shapes in an
  object array of Shapes[] so it can be sorted later in part 3.

Part 3:
  This part takes the array of shapes created in part two, sorts it, and prints
  it out using a modified version of insertion sort to sort these shapes by
  area.
*******************************************************************************/



// IMPORTS
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.lang.Math;



//SHAPE CLASS
class Shape{

  //ATTRIBUTES
  //Part 1
  public int numShape;
  public double area;
  public double perimeter;
  public double base;
  public double height;
  public double diameter;
  public double topLength;
  //Part 2
  public int[] numShapeArray;
  public int maxLength;
  public double totalArea;
  public double totalPerimeter;
  public int amountShapes;
  public Shape[] shapeArray;


  //CONSTRUCTOR
  Shape(){
    numShape = 0;
    area = 0;
    perimeter = 0;
    base = 0;
    height = 0;
    diameter = 0;
    topLength = 0;
  }


  //PART 1 METHODS

  //getInputPart1() - gets a number that correlates with a shape from user
  public int getInputPart1(){
    //Intro
    System.out.println("\nPart 1\n\nSelect a shape");
    System.out.println("1: Triangle\n2: Rectangle\n3: Square\n4: Circle\n5: Trapezoid");
    System.out.printf("\nEnter a value:  ");

    //Getting the shape number
    Scanner sc1 = new Scanner(System.in);
    int num = sc1.nextInt();
    //If invalid input
    if (num < 1 || num > 5){
      System.out.print("\nInvalid Selection. Please try again.\n");
      getInputPart1();
      }
    return num;
    }


  //PART 2 METHODS

  //getInputPart2() - gets number of each shapes the user wants to create,
    //as well as max side length and returns an array of these numebers
  public int[] getInputPart2(){

    System.out.println("\n\nPART 2\nEnter the number of shapes to create for shape.");

    //1. Number of Triangles
    System.out.print("Triangle:   ");
    Scanner sc1 = new Scanner(System.in);
    int numTri = sc1.nextInt();

    //2. Number of Rectangles
    System.out.print("Rectangle:  ");
    Scanner sc2 = new Scanner(System.in);
    int numRec = sc2.nextInt();

    //3. Number of Squares
    System.out.print("Square:     ");
    Scanner sc3 = new Scanner(System.in);
    int numSqr = sc3.nextInt();

    //4. Number of Circles
    System.out.print("Circle:     ");
    Scanner sc4 = new Scanner(System.in);
    int numCir = sc4.nextInt();

    //5. Number of Trapezoids
    System.out.print("Trapezoid:  ");
    Scanner sc5 = new Scanner(System.in);
    int numTrap = sc5.nextInt();

    //Max side length
    System.out.print("Enter a max side length:  ");
    Scanner sc6 = new Scanner(System.in);
    int maxLength = sc6.nextInt();

    amountShapes = numTri+numRec+numSqr+numCir+numTrap;

    int[] nums = {numTri, numRec, numSqr, numCir, numTrap, maxLength};
    return nums;
    }


  /*
  shapeArray() - creates the shapes specified by the user using random values
    in a range specified by the user. Each time a shape is created it is printed
    with its dimensions, area, and perimeter. The shape object is added to the
    array Shapes[] which is used in part 3.
  */
  public Shape[] shapeArray(){

    Random r = new Random();
    Shape[] shapeArray = new Shape[amountShapes];
    int shapesAdded = 0;
    maxLength = numShapeArray[5];

    System.out.println("\nThe following shapes were created.\n");

    //Create Triangles
    for(int iter = 0; iter < numShapeArray[0]; iter++){
      double base = r.nextInt(maxLength) + 1;
      double height = r.nextInt(maxLength) + 1;

      Triangle tri = new Triangle(base, height);
      shapeArray[shapesAdded] = tri;
      shapesAdded++;

      area = tri.area(base, height);
      perimeter = tri.perimeter(base,height);

      totalArea += area;
      totalPerimeter += perimeter;

      System.out.printf("Triangle:    b:%5.1f, h:%6.1f, a:%6.1f, p:%6.1f\n", base, height, area, perimeter);
      }

    //Create Rectangles
    for(int iter = 0; iter < numShapeArray[1]; iter++){
      double base = r.nextInt(maxLength) + 1;
      double height = r.nextInt(maxLength) + 1;

      Rectangle rect = new Rectangle(base, height);
      shapeArray[shapesAdded] = rect;
      shapesAdded++;

      area = rect.area(base, height);
      perimeter = rect.perimeter(base,height);

      totalArea += area;
      totalPerimeter += perimeter;

      System.out.printf("Rectangle:   w:%5.1f, h:%6.1f, a:%6.1f, p:%6.1f\n", base, height, area, perimeter);
      }

    //Creating Squares
    for(int iter = 0; iter < numShapeArray[2]; iter++){
      double base = r.nextInt(maxLength) + 1;

      Square square = new Square(base);
      shapeArray[shapesAdded] = square;
      shapesAdded++;

      area = square.area(base);
      perimeter = square.perimeter(base);

      totalArea += area;
      totalPerimeter += perimeter;

      System.out.printf("Square:      w:%5.1f, a:%6.1f, p:%6.1f\n", base, area, perimeter);
    }

    //Creating Cirlces
    for(int iter = 0; iter < numShapeArray[3]; iter++){
      double diameter = r.nextInt(maxLength) + 1;

      Circle circle = new Circle(diameter);
      shapeArray[shapesAdded] = circle;
      shapesAdded++;

      area = circle.area(diameter);
      perimeter = circle.perimeter(diameter);

      totalArea += area;
      totalPerimeter += perimeter;

      System.out.printf("Cirlce:      d:%5.1f, a:%6.1f, p:%6.1f\n", diameter, area, perimeter);
      }

    //Creating Trapezoids
    for(int iter = 0; iter < numShapeArray[4]; iter++){
      double topLength = r.nextInt(maxLength) + 1;
      double base = r.nextInt(maxLength) + 1;
      double height = r.nextInt(maxLength) + 1;

      Trapezoid trap = new Trapezoid(topLength, base, height);
      shapeArray[shapesAdded] = trap;
      shapesAdded++;

      area = trap.area(topLength, base, height);
      perimeter = trap.perimeter(topLength, base, height);

      totalArea += area;
      totalPerimeter += perimeter;

      System.out.printf("Trapezoid:   b1:%4.1f, b2:%5.1f, h:%6.1f, a:%6.1f, p:%6.1f\n", topLength, base, height, area, perimeter);
      }

    System.out.printf("\nTotal Area: %.1f\nTotal Perimeter: %.1f\n\n", totalArea, totalPerimeter);
    return shapeArray;
    }



  //PART 3 METHODS

  //getArea() - this function returns the area of a shape object - used in the
    // sort function to sort the shapes by their area
  public double getArea(){
    return area;
  }


  /*
  sort(Shape[] shapes) - this method takes in an array of shapes and sorts them
    based of their area. This uses a form of insertion sort.
  */
  public static Shape[] sort(Shape[] shapes){
    int size = shapes.length;

    for(int i = 1; i < size; i++){
      int firstUnsorted = i;

      while ((firstUnsorted > 0) && (shapes[firstUnsorted].getArea() < shapes[firstUnsorted-1].getArea())){
        //switch
        Shape temp = shapes[firstUnsorted];
        shapes[firstUnsorted] = shapes[firstUnsorted-1];
        shapes[firstUnsorted-1] = temp;

        firstUnsorted--;
      }
    }
    return shapes;
  }

}



//1. TRIANGLE CLASS
class Triangle extends Shape{

  //CONSTRUCTOR 1 - for part 1
  public Triangle(){

    //Get triangle base
    System.out.printf("Enter the base of the triangle:  ");
    Scanner sc2 = new Scanner(System.in);
    base = sc2.nextDouble();

    //Get triangle base
    System.out.printf("Enter the height of the triangle:  ");
    Scanner sc3 = new Scanner(System.in);
    height = sc3.nextDouble();

    //Caclulate area & perimeter
    area = area(base, height);
    perimeter = perimeter(base, height);
    System.out.printf("Triangle: Area = %.2f, Perimeter = %.2f\n", area, perimeter);
    }

  //CONSTRUCTOR 2 - for part 2 & 3
  public Triangle(double base, double height){
    area = area(base, height);
    perimeter = perimeter(base, height);
  }

  //area() - returns area of triangle
  public double area(double base, double height){
    area = (base * height)/2;
    return area;
  }

  //perimeter() - returns perimeter of triangle
  public double perimeter(double base, double height){
    double cSquared = (height*height) + (base*base);
    double c = Math.sqrt(cSquared);

    perimeter = height + base + c;

    return perimeter;
  }

  //toString() - format for how object is created when called
  public String toString(){
    double roundedArea = Math.round(area * 10) / 10.0;
    double roundedPerimeter = Math.round(perimeter * 10) / 10.0;
    return "Triangle:  a: " + Double.toString(roundedArea) + " p: " + Double.toString(roundedPerimeter);
  }

}


//2. RECTANGLE CLASS
class Rectangle extends Shape{

  //CONSTRUCTOR 1 - for part 1
  public Rectangle(){
    //Get rectangle width
    System.out.printf("Enter the width of the rectangle:  ");
    Scanner sc2 = new Scanner(System.in);
    base = sc2.nextDouble();

    //Get rectangle base
    System.out.printf("Enter the height of the rectangle:  ");
    Scanner sc3 = new Scanner(System.in);
    height = sc3.nextDouble();

    //Calculate area & perimeter
    area = area(base, height);
    perimeter = perimeter(base, height);
    System.out.printf("Rectangle: Area = %.2f, Perimeter = %.2f\n", area, perimeter);

  }

  //Contructor 2 - for part 2
  public Rectangle(double base, double height){
    area = area(base, height);
    perimeter = perimeter(base, height);
  }

  //area()- returns area of rectangle
  public double area(double base, double height){
    area = base*height;
    return area;
  }

  //perimeter() - returns perimeter of rectangle
  public double perimeter(double base, double height){
    perimeter = (base*2) + (height*2);
    return perimeter;
  }

  //toString() - format for how object is created when called
  public String toString(){
    double roundedArea = Math.round(area * 10) / 10.0;
    double roundedPerimeter = Math.round(perimeter * 10) / 10.0;

    return "Rectangle: a: " + Double.toString(roundedArea) + " p: " + Double.toString(roundedPerimeter);
  }



}


//3. SQUARE CLASS
class Square extends Shape{

  //CONSTRUCTOR 1 - for part 1
  public Square(){
    //Get square side length
    System.out.printf("Enter the side length of the square:  ");
    Scanner sc2 = new Scanner(System.in);
    base = sc2.nextDouble();

    //Find area & perimeter
    area = area(base);
    perimeter = perimeter(base);
    System.out.printf("Square: Area = %.2f, Perimeter = %.2f\n", area, perimeter);

  }

  //CONSTRUCTOR 2 - for part 2
  public Square(double base){
    area = area(base);
    perimeter = perimeter(base);
  }

  //area()- returns area of square
  public double area(double base){
    area = base*base;
    return area;
    }

  //perimeter()- returns perimeter of square
  public double perimeter(double base){
    perimeter = base*4;
    return perimeter;
    }

    //toString() - format for how object is created when called
    public String toString(){
      double roundedArea = Math.round(area * 10) / 10.0;
      double roundedPerimeter = Math.round(perimeter * 10) / 10.0;

      return "Square:    a: " + Double.toString(roundedArea) + " p: " + Double.toString(roundedPerimeter);
    }
}


//4. CIRCLE CLASS
class Circle extends Shape{

  //CONSTRUCTOR 1 - for part 1
  public Circle(){
    //Get circle diameter
    System.out.printf("Enter the diameter length of the circle:  ");
    Scanner sc2 = new Scanner(System.in);
    diameter = sc2.nextDouble();

    //Calculates area & perimeter
    area(diameter);
    perimeter(diameter);
    System.out.printf("Circle: Area = %.2f, Perimeter = %.2f\n", area, perimeter);
    }

  //CONSTRUCTOR 2 - for part 2
  public Circle(double diameter){
    area = area(diameter);
    perimeter = perimeter(diameter);
  }

  //area() - returns area of circle
  public double area(double diameter){
    area = Math.PI * ((diameter/2) * (diameter/2));
    return area;
    }

  //perimeter() - returns perimeter of circle
  public double perimeter(double diameter){
    perimeter = (2*Math.PI) * (diameter/2);
    return perimeter;
    }

  //toString() - format for how object is created when called
  public String toString(){
    double roundedArea = Math.round(area * 10) / 10.0;
    double roundedPerimeter = Math.round(perimeter * 10) / 10.0;

    return "Circle:    a: " + Double.toString(roundedArea) + " p: " + Double.toString(roundedPerimeter);
  }



}


//5. TRAPEZOID CLASS
class Trapezoid extends Shape{

  //CONSTRUCTOR 1 - for part 1
  public Trapezoid(){
    //Get top base
    System.out.printf("Enter the top base length of the trapezoid:  ");
    Scanner sc2 = new Scanner(System.in);
    topLength = sc2.nextDouble();

    //Get bottom base
    System.out.printf("Enter the bottom base length of the trapezoid:  ");
    Scanner sc3 = new Scanner(System.in);
    base = sc3.nextDouble();

    //Get height
    System.out.printf("Enter the height of the trapezoid:  ");
    Scanner sc4 = new Scanner(System.in);
    height = sc4.nextDouble();

    //Find area and perimeter
    area(topLength, base, height);
    perimeter(topLength, base, height);
    System.out.printf("Trapezoid: Area = %.2f, Perimeter = %.2f\n", area, perimeter);
  }

  //CONSTRUCTOR 2 - for part 2 & 3
  public Trapezoid(double topLength, double base, double height){
    area = area(topLength, base, height);
    perimeter = perimeter(topLength, base, height);
  }

  //area()- returns area of trapezoid
  public double area(double topLength, double base, double height){
    area = ((topLength+base)/2)*height;
    return area;
  }

  //perimeter() - returns perimeter of trapezoid
  public double perimeter(double topLength, double base, double height){
    double sideSquare = Math.abs(((base-topLength)/2)*((base-topLength)/2)) + (height*height);
    double side = Math.sqrt(sideSquare);

    perimeter = topLength + base + (side*2);
    return perimeter;
  }

  //toString() - format for how object is created when called
  public String toString(){
    double roundedArea = Math.round(area * 10) / 10.0;
    double roundedPerimeter = Math.round(perimeter * 10) / 10.0;

    return "Trapezoid: a: " + Double.toString(roundedArea) + " p: " + Double.toString(roundedPerimeter);
  }

}



//Homework5 class with main method
class Homework5{



  //MAIN METHOD
  public static void main(String[] args){

    //PART 1

    //Create instance of shape & get a value for which shape is being created
    Shape shape = new Shape();
    shape.numShape = shape.getInputPart1();

    //Deciding which shape to calculate area & perimeter for
    if (shape.numShape == 1){
      Triangle tri = new Triangle();
      }
    if (shape.numShape == 2){
      Rectangle rect = new Rectangle();
      }
    if (shape.numShape == 3){
      Square square = new Square();
      }
    if (shape.numShape == 4){
      Circle circle = new Circle();
      }
    if (shape.numShape == 5){
      Trapezoid trap = new Trapezoid();
      }


    //PART 2

    //Gets number of each shape to creat & stores it in an array
    shape.numShapeArray = shape.getInputPart2();

    //Uses specified shapes to create random shapes and stores in shapeArray
    shape.shapeArray = shape.shapeArray();


    //PART 3

    //Print out part 3
    System.out.println("\nPart 3\nShapes Sorted by Area");

    //Sorting shapeArray from part 2
    shape.shapeArray = shape.sort(shape.shapeArray);

    //Print the sorted array
    for(int i = 0; i < shape.shapeArray.length; i++){
      System.out.println(shape.shapeArray[i]);
      }
  }

}
