import java.util.*;
import java.util.stream.*;
import worker.*;
import javax.swing.*;
import java.io.*;
import zhstructures.*;
import ajnstructures.*;

/**
 * This class implements a program that manages a set of workers.
 *
 * @author J. Miller, J. A. Holey and Andrew Nerud and Grant Peroutka
 * @version 9/22/22
 */
public class WorkerManager{
  
  /**
   * The set of workers to keep track of
   */
  private ZHBinarySearchTree<Worker> workers;
  
  /**
   * Default constructor for the class that creates a new set of workers
   */
  public WorkerManager(){
    System.out.println("Welcome to the Worker Manager");
    workers = new AJNLinkedBinarySearchTree<Worker>();
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
    System.out.println("\tA Add a new worker");
    System.out.println("\tR Remove a worker");
    System.out.println("\tM Manage an individual worker");
    System.out.println("\tP rePort on workers");
    System.out.println("\tS Save the current worker set");
    System.out.println("\tL Load a worker set");
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
        add();
        break;
      case 'r': case 'R':
        remove();
        break;
      case 'm': case 'M':
        manage();
        break;
      case 'p': case 'P':
        report();
        break;
      case 's': case 'S':
        save();
        break;
      case 'l': case 'L':
        load();
        break;
      case 'q': case 'Q':
        quit ();
        break;
      default:
        System.out.println("Invalid command--try again");
    }
  }
  
  /** add
    *
    * Prompt the user for the type of worker to add, create the appropriate worker type
    * and add the worker to the set.
    *
    */
  private void add() {
    System.out.println();
    System.out.println("Which type of worker do you want to add?");
    System.out.println();
    System.out.println("\tV add a Volunteer");
    System.out.println("\tH add an Hourly Employee");
    System.out.println("\tS add a Salaried Employee");
    System.out.println("\tC Cancel add worker");
    System.out.println();
    
    String s = JOptionPane.showInputDialog("Enter worker type: ");;
    char cmd = s.charAt(0);
    
    Worker newWorker;
    switch (cmd)
    {
      case 'v': case 'V':
        newWorker = newVolunteer();
        if (!workers.add(newWorker)) {
          System.out.println("This worker already exists in this set");
        }
        break;
      case 'h': case 'H':
        newWorker = newHourlyEmployee();
        if (!workers.add(newWorker)) {
          System.out.println("This worker already exists in this set");
        }
        break;
      case 's': case 'S':
        newWorker = newSalariedEmployee();
        if (!workers.add(newWorker)) {
          System.out.println("This worker already exists in this set");
        }
        break;
      case 'c': case 'C':
        System.out.println("Add worker cancelled");
        break;
      default:
        System.out.println("Invalid command--try again");
    }
  }
  
  /** newVolunteer
    * Method to get data for and create a new Volunteer
    */
  private Worker newVolunteer() {
    // use the AcceptCommand method as a model to prompt for and get the data
    // you need for a Volunteer (name and hours)
    String name = JOptionPane.showInputDialog("Name: ");
    int hours = Integer.parseInt(JOptionPane.showInputDialog("Hours: "));
    return new Volunteer(name, hours);
  } 
  
  /** newHourlyEmployee
    * Method to get data for and create a new HourlyEmployee
    */
  private Worker newHourlyEmployee() {
    // use the AcceptCommand method as a model to prompt for and get the data
    // you need for an HourlyEmployee (name,  hours and hourly rate)
    String name = JOptionPane.showInputDialog("Name: ");
    int hours = Integer.parseInt(JOptionPane.showInputDialog("Hours: "));
    double rate = Double.parseDouble(JOptionPane.showInputDialog("Hourly Rate (ex. 00.00): "));
    return new HourlyEmployee(name, hours, rate);
  } 
  
  /** newSalariedEmployee
    * Method to get data for and create a new SalariedEmployee
    */
  private Worker newSalariedEmployee() {
    // use the AcceptCommand method as a model to prompt for and get the data
    // you need for a SalariedEmployee (name and salary)
    String name = JOptionPane.showInputDialog("Name: ");
    double salary = Double.parseDouble(JOptionPane.showInputDialog("Salary: "));
    return new SalariedEmployee(name, salary);
  } 
  
  /** report
    * Prompt the user for the type of report desired: all workers, hourly workers,
    * all employees, volunteers, hourly employees or salaried employees;
    * print a list of all the workers in the selected category.
    */
  private void report() {
    //********************************************************************* fill in appropriate code */
    System.out.println();
    System.out.println("Which type of worker do you want to see reports on?");
    System.out.println();
    System.out.println("\tV Volunteer");
    System.out.println("\tH Hourly Employee");
    System.out.println("\tS Salaried Employee");
    System.out.println("\tC Cancel report");
    System.out.println();
    
    String s = JOptionPane.showInputDialog("Enter worker type: ");
    char cmd = s.charAt(0);
    
    switch (cmd)
    {
      case 'v': case 'V':
        workers.forEach(worker -> {
           if(worker instanceof Volunteer) 
             System.out.println("Name: "+ ((Volunteer)worker).getName()+ 
                                "\nHours: " + ((Volunteer)worker).getHours());
        });
        break;
      case 'h': case 'H':
        workers.forEach(worker -> {
           if(worker instanceof HourlyEmployee) 
             System.out.println("Name: "+ ((HourlyEmployee)worker).getName()+ 
                                "\nHours: " + ((HourlyEmployee)worker).getHours() +
                                "\nHourly Rate: " +((HourlyEmployee)worker).getHourlyRate());
        });
        break;
      case 's': case 'S':
        workers.forEach(worker -> {
           if(worker instanceof SalariedEmployee) 
             System.out.println("Name: "+ ((SalariedEmployee)worker).getName()+ 
                                "\nMonthly Salary: " + ((SalariedEmployee)worker).getMonthlyPay());
        });
        break;
      case 'c': case 'C':
        System.out.println("Add worker cancelled");
        break;
      default:
        System.out.println("Invalid command--try again");
    }
    workers.forEach(worker -> System.out.println(worker));
  }
  
  /** remove 
    * Prompt the user for a worker name and remove that worker from the set;
    * report if the worker is not found
    */
  private void remove() {
    //********************************************************************* fill in appropriate code */
    String name = JOptionPane.showInputDialog("Name of Worker to Remove: ");
    for (Worker w: workers) {
      if (w.getName().equals(name)) {
        workers.remove(w);
        System.out.println("Worker was successfully removed from set with name: " + name);
        return;
      }
    }
    System.out.println("Worker with name: " + name + " was not found in the set");
  }
  
  /** save
    * Prompt the user for a file name and save the set to the 
    * specified file using an ObjectOutputStream;
    * report an error if an exception occured
    */
  private void save() {
    //********************************************************************* fill in appropriate code */
    String fileName = JOptionPane.showInputDialog("Enter a file name to save the set: ");
    try {
      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
      oos.writeObject(workers);
      oos.close();
    } catch (IOException e) {
      System.out.println("Failed to save set to a file: \n" + e);
    }
  }
  
  /** load
    * Prompt the user for a file name and load a new set from the specified file
    * using an ObjectInputStream;
    * report an error if an exception occured
    */
  private void load() {
    //********************************************************************* fill in appropriate code */
    String fileName = JOptionPane.showInputDialog("Enter a file name where the set was saved: ");
    try {
      ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
      workers = (ZHBinarySearchTree<Worker>)ois.readObject();
      ois.close();
    } catch (IOException e) {
      System.out.println("Failed to load set from file: \n" + e);
    } catch (ClassNotFoundException cnf) {
      System.out.println("Bad input data from file: \n" + cnf);
    }
  }
  
  /** manage 
    * Prompt the user for a worker name and find the worker;
    * if the worker is found, create a VolunteerManager, HourlyEmployeeManager or
    * SalariedEmployeeManager on that worker and run it;
    * otherwise report that the worker is not found
    */
  private void manage() {
    //********************************************************************* fill in appropriate code */
    String name = JOptionPane.showInputDialog("Name: ");
    Worker workerToManage = null;
    for(Worker w : workers){
      if (w.getName().equals(name)){
        workerToManage = w;
        break;
      }
    }
    if (workerToManage == null) {
      System.out.println("Worker was not found for name: " + name);
      return;
    }
    
    if (workerToManage instanceof Volunteer) {
      VolunteerManager vManager = new VolunteerManager((Volunteer)workerToManage);
      vManager.runManager();
    } else if (workerToManage instanceof SalariedEmployee) {
      SalariedEmployeeManager seManager = new SalariedEmployeeManager((SalariedEmployee)workerToManage);
      seManager.runManager();
    } else if (workerToManage instanceof HourlyEmployee) {
      HourlyEmployeeManager heManager = new HourlyEmployeeManager((HourlyEmployee)workerToManage);
      heManager.runManager();
    } else {
      System.out.println("Worker not of the proper supported types");
    }
  }
  
  /** quit
    * Method to terminate the WorkerManager program
    */
  private void quit() {        
    System.out.println("Now exiting the Worker Manager\n");
  }
  
  /** Main program--creates and runs WorkerManager
    * @param args the command line arguments (not used)
    */
  public static void main (String args[]) {
    WorkerManager manager = new WorkerManager ();
    manager.runManager();
  }
}
