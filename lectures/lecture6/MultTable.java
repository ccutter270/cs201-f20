/******************************

Lecture 6: Arrays - Worksheet
Monday, September 21, 2020

********************************/



//imports
import java.lang.Math;




class MultTable{

  //fields
  int[][] table;

  public MultTable(int m, int n){

    table = new int[m+1][n+1];





    createTable(m,n);
  }



public void createTable(int m, int n){

  for(int col = 1; col <= m; col++){
    for (int row = 1; row <= n; row++){
      table[col][row] = col*row;
      System.out.print(Integer.toString(table[col][row]) + "\t");
      }
      System.out.print("\n");
    }
  }

  public static void main(String[] args){
    MultTable mt = new MultTable(10,8);

  }




  }
