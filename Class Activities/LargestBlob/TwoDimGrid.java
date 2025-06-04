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

public class TwoDimGrid extends JPanel implements GridColors {
  
  // Data Fields
  /** Prefered button size */
  private static final int PREFERED_BUTTON_SIZE = 60;
  
  /** Default number of rows */
  private static final int DEFAULT_COLS = 20;
  
  /** Default number of columns */
  private static final int DEFAULT_ROWS = 20;
  
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
    this.theGrid = new JButton[nRows][nCols];
    for (int r = 0; r != getNRows(); r++){
      for (int c = 0; c != getNCols (); c++) {
        this.theGrid[r][c] = new JButton(r + "," + c);
        this.theGrid[r][c].setBackground(LEGAL);
        this.theGrid[r][c].addActionListener(new ToggleColor(this.theGrid[r][c]));
        add(this.theGrid[r][c]); // Add the buttons to the button panel
      }
    }
  }
  
 // Accessors and Mutators
  /** Get the number of rows
    *  @return nRows */
  public int getNRows() {
    return this.nRows;
  }

  /** Get the number of columns
    *  @return nCols */
  public int getNCols() {
    return this.nCols;
  }
  
  /** Get the color at a given coordinate
    *  @param row - The row number   
    *  @param col - The column number
    *  @return The color at the given coordinate */
  public Color getColor(int row, int col) {
    return this.theGrid[row][col].getBackground();
  }
  
  /** Change the color at a given coordinate
    * @param row - The row number
    * @param col - The column number  
    * @param newColor - The color to set the button to */
  public void recolor(int row, int col, Color newColor) {
    this.theGrid[row][col].setBackground(newColor);
  }
  
  /** Finds buttons with a given color and recolors them
    * @param tempColor - The old color of the button
    * @param newColor - The color to set the button to */  
  public void recolor(Color tempColor, Color newColor) {
    for (int r = 0; r != getNRows(); r++){
      for (int c = 0; c != getNCols (); c++) {
        if (this.theGrid[r][c].getBackground().equals(tempColor))
          this.theGrid[r][c].setBackground(newColor);
      }
    }
  }
  
  /** Reset all buttons to LEGAL or WHITE color*/    
  public void reset(){
    for (int r = 0; r != getNRows(); r++){
      for (int c = 0; c != getNCols (); c++) {
        this.theGrid[r][c].setBackground(LEGAL);
      }
    }
  }
  
// Inner class
  /** ActionListener class to toggle color when clicked */
  private class ToggleColor implements ActionListener {
    // DataField
    /** The button to be responded to */
    private JButton me;
    
    // Constructor
    /** Construct ToggleColor object for a given button
      *  @param theButton - The button to be responded to */
    public ToggleColor(JButton theButton) {
      this.me = theButton;
    }
    
    // Methods
    /** Action in response to button push
      *  @param e - Event object is ignored */
    public void actionPerformed(ActionEvent e) {
      if (this.me.getBackground().equals(LEGAL)) {
        this.me.setBackground(ILLEGAL);
      }
      else {
        this.me.setBackground(LEGAL);
      }
    }
  }
}
