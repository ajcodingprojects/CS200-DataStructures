/*
 * File Queens.java
 */

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Program to find a solution to the 8 queens problem
 * and display the result graphically.
 * 
 * @author Jim Schnepf, modified by J. Andrew Holey, I Rahal. Andrew Nerud, Colin Glynn
 * @version October, 2022
 */
public class EightQueens extends JFrame {
  
  private static final Color QUEENSPOT      = Color.RED;
  private static final Color OPEN           = Color.BLACK;
  
  /** delay between redraws of chessboard*/
  private static int SLEEP_TIME = 100;
  
  /** squares per row or column */
  private static int BOARD_SIZE = 8;
  
  /** used to indicate an empty square*/
  private static final int EMPTY = 0;
  
  /** used to indicate a square containing a queen*/
  private static int QUEEN = 1;
  
  /** used to represent the chess board*/
  private int board[][];
  
  /**
   * used to store the row location for each queen 
   * placed so far on the board; array index indicates 
   * the column location for the queen
   */ 
  private int queenLocations[]; 
  
  /*
   * board cells will be represented as buttons on a grid */
  private TwoDimGrid GUIBoard;  
  
  /**
   * Constructor creates an empty square board
   */
  public EightQueens() {
    board = new int[BOARD_SIZE][BOARD_SIZE];
    queenLocations = new int[BOARD_SIZE];
    GUIBoard = new TwoDimGrid(BOARD_SIZE, BOARD_SIZE);
    getContentPane().add(GUIBoard, BorderLayout.CENTER);
    pack();
    setVisible(true);
    clearBoard();
    displayBoard();
  }
  
    /**
   * A getter method to return the current board value at location [row][col]
   *
   * @param row - The row number
   * @param col - The column number
   * @return board value at location [row][col]
   */
  private int getBoardAt(int row, int col){
    return board[row][col];
  }
  
  /**
   * A setter method to store "value" at board location [row][col]
   * @param row - The row number
   * @param col - The column number
   * @param value - The new value to store board location [row][col]
   */
  private void setBoardAt(int row, int col, int value){
    board[row][col] = value;
  }  
  
  /**
   * Clears the board
   * post: Sets all of the squares to EMPTY
   */
  public void clearBoard() {
    for (int c = 0; c <  BOARD_SIZE; c++){    
      queenLocations[c] = -1;
      for (int r = 0; r < BOARD_SIZE; r++){
        setBoardAt(r,c,EMPTY);
      }
    }
  }
  
  /**
   * Displays the board
   * post: board is displayed using grid
   */
  void displayBoard() {
    GUIBoard.recolor(board, QUEENSPOT, OPEN);
    try {
      Thread.sleep(SLEEP_TIME);
    }
    catch(InterruptedException ie) {
      ie.printStackTrace();
      System.exit(1);
    }      
  }
  
  /**
   * Places queens in the colums beginning at the 
   * column specified
   * 
   * Precondition: Queens are already placed in all columns preceding 
   * currentColumn
   * 
   * @param currentColumn the current column to place a queen in
   * @return true if a solution is found, where each column on the board 
   * contains one queen;
   */
  public boolean placeQueens(int currentColumn) {
    for (int row = 0; row < board.length; row++) {
      if (!isUnderAttackV2(row, currentColumn)) {
        setQueen(row, currentColumn);
        if (currentColumn == board.length - 1 || placeQueens(currentColumn+1)) {
          return true;
        } else { 
          removeQueen(row, currentColumn);
        }
       // if (currentColumn == board.length - 1) {
        //  return true;
       // } else if (!placeQueens(currentColumn+1)){
         // removeQueen(row, currentColumn); 
        //}
      } 
    }
    return false;
  }
  
  /**
   * Set a queen on a row indicated by row and column
   * post: Sets the square on the board in a
   * given row and column to QUEEN.
   * 
   * @param row - The row number
   * @param col - The column number
   */
  private void setQueen(int row, int  col) {
    setBoardAt(row,col, QUEEN);
    queenLocations[col] = row;
    displayBoard();
  }
  
  /** Remove a queen at square indicated by row and column
    *  post: Sets the square on a board in a given row and column 
    * to EMPTY  
    * 
    * @param row - The row number
    * @param col - The column number
    */
  
  private void removeQueen(int row, int col) {
    setBoardAt(row,col, EMPTY);
    queenLocations[col] = -1;
    displayBoard();
  }
  
  /**
   * Determines whether the square on the board at a given 
   * row and col is under attack
   * 
   * @param row the x-coordinate for the square on the board
   * @param col the y-coordinate for the square on the board* 
   * @return true if placing the queen at square (column, row) is NOT allowed; 
   *         false otherwise
   */
  private boolean isUnderAttack(int row, int col){
    for (int offset = 1; offset <= col; offset++) {
      if (getBoardAt(row, col - offset) == 1 || ((!(row - offset < 0)) && getBoardAt(row - offset, col - offset) == 1) 
            || ((!(row + offset >= board.length)) && getBoardAt(row + offset, col - offset) == 1)) {
        return true;
      }
    }
    
    return false;
  }
  
  /**
   * Determines whether the square on the board at a given 
   * row and col is under attack
   * 
   * @param row the x-coordinate for the square on the board
   * @param col the y-coordinate for the square on the board* 
   * @return true if placing the queen at square (column, row) is NOT allowed; 
   *         false otherwise
   */
  private boolean isUnderAttackV2(int row, int col){
    for (int queenCol = 0; queenCol < col; queenCol++) {
      int rowDiff = Math.abs(row - queenLocations[queenCol]);
      int colDiff = Math.abs(col - queenCol);
      if ((rowDiff == 0) || (rowDiff == colDiff)) {
        return true;
      }
    }
    
    return false;
  }
  
  
  /**
   * Start the Queens search 
   */
  public static void main(String [] args) {
    EightQueens q = new EightQueens();
    q.placeQueens(0);
  }
}     




