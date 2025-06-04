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
public class HourlyEmployeeManager{
  
  /**
   * The hourly employee being managed
   */
  private HourlyEmployee hEmployee;

  /**
   * Constructor for the class
   * 
   * @param he the HourlyEmployee to be managed
   */
  public HourlyEmployeeManager(HourlyEmployee he){
    hEmployee = he;
  }

  /**
   * Method that prints out the employee's monthly pay
   */
  public void viewMonthlyPay(){
    System.out.println("The monthly pay was: " + hEmployee.getMonthlyPay());
   }
   
  /**
   * Method to add hours to the employee's current hours
   */
  public void addHours(int numHours){
    hEmployee.addHours(numHours);
  }
  
  /**
   * Method to reset the employee's hours
   */
  public void resetHours(){
    hEmployee.resetHours();
  }
    
  /**
   * Method to view the amount of hours for the employee
   */
  public void viewHours(){
    System.out.println("The number of hours is: " + hEmployee.getHours());
  }
  
  /**
   * Method to set the hourly rate of the employee
   */
  public void setHourlyPayRate(double rate){
    hEmployee.setHourlyRate(rate);
  }
  
  /**
   * Method to view the employee's hourly rate
   */
  public void viewHourlyPayRate(){
    System.out.println("The hourly rate is: " + hEmployee.getHourlyRate());
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
    System.out.println("\tA Add hours for Hourly Employee ");
    System.out.println("\tV View monthly pay for Hourly Employee ");
    System.out.println("\tR Reset hours for Hourly Employee ");
    System.out.println("\tC View current hours for Hourly Employee");
    System.out.println("\tS Set hourly pay rate for Hourly Employee ");
    System.out.println("\tH View hourly pay rate for Hourly Employee ");
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
      case 'a': case 'A':
        int hours = Integer.parseInt(JOptionPane.showInputDialog("Hours to add: "));
        addHours(hours);
        break;
      case 'v': case 'V':
        viewMonthlyPay();
        break;
      case 'r': case 'R':
        resetHours();
        break;
      case 'c': case 'C':
        viewHours();
        break;
      case 's': case 'S':
        double rate = Double.parseDouble(JOptionPane.showInputDialog("Set hourly pay rate: "));
        setHourlyPayRate(rate);
        break;
      case 'h': case 'H':
        viewHourlyPayRate();
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
    System.out.println("Now exiting the volunteer manager\n");
  }
  
}
