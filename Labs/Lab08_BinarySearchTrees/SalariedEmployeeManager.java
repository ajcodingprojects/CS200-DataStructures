import java.util.*;
import java.util.stream.*;
import worker.*;
import javax.swing.*;
import java.io.*;

/**
 * This class implements a program that manages a set of workers.
 *
 * @author J. Miller, J. A. Holey and Andrew Nerud and Grant Peroutka
 * @version 9/22/22
 */
public class SalariedEmployeeManager{
  
  /**
   * The salaried employee being managed
   */
  private SalariedEmployee sEmployee;

  /**
   * Constructor for the class
   * 
   * @param he the SalariedEmployee to be managed
   */
  public SalariedEmployeeManager(SalariedEmployee se){
    sEmployee = se;
  }
  
  /**
   * Method to set the monthly pay for the employee
   */
  public void setMonthlyPay(double salary){
    sEmployee.setMonthlyPay(salary);
  }
  
  /**
   * Method that prints out the monthly pay for the employee
   */
   public void viewMonthlyPay(){
    System.out.println("The monthly pay was: " + sEmployee.getMonthlyPay());
   }
   
   /**
   * Method to run the manager interface for the user to interact with
   */
   public void runManager() {
    char cmd;
    do
    {
      menu ();
      cmd = acceptCommand ();
      doCommand (cmd);
    }
    while ((cmd != 'q') && (cmd != 'Q'));
  }
  
   /**
   * Method to display the menu
   */
  private void menu() {
    System.out.println();
    System.out.println("\tS Set salaried employee's pay ");
    System.out.println("\tV View salaried employee's pay ");
    System.out.println("\tQ Quit the program");
    System.out.println();
  }
  
  /**
   * Method that accepts commands based on inputted characters
   * 
   * @return a character of the first inputted letter
   */
  private char acceptCommand() {
    char cmd;
    String s = JOptionPane.showInputDialog("Enter command: ");
    cmd = s.charAt(0);
    return cmd;
  }
  
  /**
   * Method to execute a command based on the menu
   */
  private void doCommand(char cmd) {
    switch (cmd)
    {
      case 's': case 'S':
        double salary = Double.parseDouble(JOptionPane.showInputDialog("Monthly salary: "));
        setMonthlyPay(salary);
        break;
      case 'v': case 'V':
        viewMonthlyPay();
        break;
      case 'q': case 'Q':
        quit ();
        break;
      default:
        System.out.println("Invalid command--try again");
    }
  }
   /** quit
    * Method to terminate the WorkerManager program
    */
  private void quit() {        
    System.out.println("Now exiting the salaried employee manager\n");
  }
  
}
