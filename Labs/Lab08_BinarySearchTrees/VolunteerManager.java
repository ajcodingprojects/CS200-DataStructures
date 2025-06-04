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
public class VolunteerManager{
  
  /**
   * The volunteer being managed
   */
  private Volunteer volunteer;

  /**
   * Constructor for the class
   * 
   * @param he the Volunteer to be managed
   */
  public VolunteerManager(Volunteer v){
    volunteer = v;
  }
  
  /**
   * Method to add hours to the volunteer's current hours
   */
  public void addHours(int numHours){
    volunteer.addHours(numHours);
  }
  
  /**
   * Method to reset the volunteer's hours
   */
  public void resetHours(){
    volunteer.resetHours();
  }
    
  /**
   * Method to view the amount of hours for the volunteer
   */
  public void viewHours(){
    System.out.println("The number of hours is: " + volunteer.getHours());
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
    System.out.println("\tA Add hours for volunteer ");
    System.out.println("\tV View hours for volunteer ");
    System.out.println("\tR Reset hours for volunteer ");
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
        viewHours();
        break;
      case 'r': case 'R':
        resetHours();
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

