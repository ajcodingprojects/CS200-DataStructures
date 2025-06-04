import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

/** TwoDimGrid is a two dimensional array of buttons.
  *  Each button can be toggled between two colors by
  *  clicking it with the mouse, or its color can be
  *  changed/queried under program control.
  *  @author Koffman and Wolfgang
  * */

public class TwoDimGrid extends JPanel  {
  
  // Data Fields
  /** Prefered button size */
  private static final int PREFERED_BUTTON_SIZE = 60;
  
  /** Default number of rows */
  private static final int DEFAULT_COLS = 20;
  
  /** Default number of columns */
  private static final int DEFAULT_ROWS = 20;
  
  private static final Color BACKGROUND = Color.WHITE;
  
  /** A two dimensional grid of buttons */
  private JButton[][] theGrid;
  
  /** Number of rows */
  private int nRows;
  
  /** Number of columns */
  private int nCols;
  
// Constructors
  /** Construct a TwoDimGrid of the specified size and of the
    *  specified colors
    *  @param nRows - Number of rows
    *  @param nCols - Number of columns
    */
  public TwoDimGrid(int nRows, int nCols) {
    this.nRows = nRows;
    this.nCols = nCols;
    setPreferredSize(new Dimension(nCols * PREFERED_BUTTON_SIZE, nRows * PREFERED_BUTTON_SIZE));
    setLayout(new GridLayout(nRows, nCols));
    theGrid = new JButton[nRows][nCols];
    for (int r = 0; r != getNRows(); r++){
      for (int c = 0; c != getNCols (); c++) {
        theGrid[r][c] = new JButton(r + ", " + c);
        theGrid[r][c].setBackground(BACKGROUND);
        add(theGrid[r][c]); // Add the buttons to the button panel
      }
    }
  }
  
  // Accessors and Mutators
  /** Get the number of columns
    *  @return nCols */
  public int getNCols() {
    return nCols;
  }
  
  /** Get the number of rows
    *  @return nRows */
  public int getNRows() {
    return nRows;
  }
  
  /** Get the color at a given coordinate
    *  @param row - The row number
    *  @param col - The column number
    * 
    *  @return The color at the given coordinate */
  public Color getColor(int row, int col) {
    return theGrid[row][col].getBackground();
  }
  
  /** Change the color at a given coordinate
    * @param row - The row number
    * @param col - The column number
    * @param newColor - The color to set the button to */
  public void recolor(int row, int col, Color newColor) {
    theGrid[row][col].setBackground(newColor);
  }
  
  /** Finds buttons with a given color and recolors them
    * @param tempColor - The old color of the button
    * @param newColor - The color to set the button to */      
  public void recolor(Color tempColor, Color newColor) {
    for (int r = 0; r != getNRows(); r++){
      for (int c = 0; c != getNCols (); c++) {
        if (theGrid[r][c].getBackground().equals(tempColor))
          theGrid[r][c].setBackground(newColor);
      }
    }
  }
  
  
  /** Set the color of each square in the grid that correspond
    *  to the elements of the given array with the value 1
    *  @param bitMap - An array of 0's and 1's the same size as the grid
    *  @param aColor - The color to be set
    *  @throws ArrayIndexOutOfBounds if the array size and the
    *  grid size differ  */
  public void recolor(int[][] bitMap, Color aColor) {
    for (int r = 0; r != bitMap.length; r++) {
      for (int c = 0; c != bitMap[r].length; c++) {
        if (bitMap[r][c] == 1) {
          theGrid[r][c].setBackground(aColor);
        }
      }
    }
  }
  
  /** Set the colors of each square in the grid that correspond
    *  to the elements of the given array with the values 0 and 1
    *  @param bitMap - An array of 0's and 1's the same size as the grid
    *  @param aColor1 - The first color to be set
    *  @param aColor2 - The second color to be set
    *  @throws ArrayIndexOutOfBounds if the array size and the
    *  grid size differ  */
  public void recolor(int[][] bitMap, Color aColor1, Color aColor2) {
    for (int r = 0; r != bitMap.length; r++) {
      for (int c = 0; c != bitMap[r].length; c++) {
        if (bitMap[r][c] == 1) {
          theGrid[r][c].setBackground(aColor1);
        }
        else {
          theGrid[r][c].setBackground(aColor2);
        } 
      }
    }
  }
  
  /** Reset all buttons to LEGAL or WHITE color*/    
  public void reset(){
    for (int r = 0; r != getNRows(); r++){
      for (int c = 0; c != getNCols (); c++) {
        theGrid[r][c].setBackground(BACKGROUND);
      }
    }
  }
}