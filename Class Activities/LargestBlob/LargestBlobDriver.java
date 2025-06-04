import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** Program to illustrate counting cells in a blob
  *   @author Koffman and Wolfgang
  * */

public class LargestBlobDriver extends JFrame implements GridColors, ActionListener {
  
  // data field
  /** a 2-D grid of buttons */
  private TwoDimGrid theGrid;
  private JButton solveButton, resetButton; 
  public static void main(String[] args) {
    //String reply = JOptionPane.showInputDialog("Enter number of rows");
    //int nRows = Integer.parseInt(reply);
    //reply = JOptionPane.showInputDialog("Enter number of columns");
    ///int nCols = Integer.parseInt(reply);
    //TwoDimGrid aGrid = new TwoDimGrid(nRows, nCols);
    TwoDimGrid aGrid = new TwoDimGrid(10, 10);
    new LargestBlobDriver(aGrid);
  }
  
  /** Builds the GUI
    *  @param aGrid - The TwoDimGrid that contains the blob */
  private LargestBlobDriver(TwoDimGrid aGrid) {
    this.theGrid = aGrid;
    getContentPane().add(aGrid, BorderLayout.CENTER);
    JTextArea instruct = new JTextArea(2, 10);
    instruct.setText("Toggle a button to change its color"
                       + "\nPress SOLVE when ready");
    getContentPane().add(instruct, BorderLayout.EAST);
    this.solveButton = new JButton("SOLVE MAZE");
    this.resetButton = new JButton("RESET MAZE");
    this.solveButton.addActionListener(this);
    this.resetButton.addActionListener(this);
    getContentPane().add(this.solveButton, BorderLayout.SOUTH);
    getContentPane().add(this.resetButton, BorderLayout.NORTH);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
    setVisible(true);
  }
  
  /** Respond to pressing SOLVE button
    *  @param e -- Not used */
  public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(solveButton)){    
      LargestBlob aBlob = new LargestBlob(theGrid);
      JOptionPane.showMessageDialog(null,aBlob.findLargestBlob());
    }
    else
      theGrid.reset();
  }
}
