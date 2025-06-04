/**
 * Driver Class for the game
 * 
 */
import javax.swing.*;
import java.io.*;
import java.util.*;

/**
 * Grant Peroutka and Andrew Nerud
 * Date: 12/7/2022
 */
public class GameSimulator {
  
  /**
   * The gameLayout to keep track of
   */
  private GameLayout gl;
  
  /**
   * Default constructor for the class that creates a new gameLayout
   */
  public GameSimulator(){
    System.out.println("Welcome to the Game Simulator");
    gl = new GameLayout("LocationsList.txt", "ConnectionsList.txt");
    gl.moveRobber(false);
    gl.moveRobber(false);
    gl.moveRobber(false);
  }
  
  
  /**
   * Main method that runs simulator
   */
  public static void main(String args[]) {
    GameSimulator gs = new GameSimulator();
    gs.simulateGame();
  }
  
  
  /**
   * Method to run the game for the user to interact with
   */
  public void simulateGame() {
    char cmd;
    do
    {
      menu ();
      cmd = acceptCommand ();
      cmd = doCommand (cmd);
    }
    while ((cmd != 'q') && (cmd != 'Q'));
  }
  
  /**System.out.println("Current Location: " + currentPosition);
    game.moveEntity(game.getCop(), "Minneapolis");
    
    System.out.println("Movied to: " + game.getCopCurrentLocation());
    * Method to display the menu
    */
  private void menu() {
    System.out.println();
    System.out.println("\tL List all possible locations");
    System.out.println("\tP List properties at current location");
    System.out.println("\tC List all current location connections");
    System.out.println("\tM Move to a connected location");
    System.out.println("\tS Search for the robber using breadth-first search");
    System.out.println("\tZ Save the current game");
    System.out.println("\tG Get last saved game");
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
  private char doCommand(char cmd) {
    switch (cmd)
    {
      case 'l': case 'L':
        Iterator<String> locationNames = gl.allLocations();
        while (locationNames.hasNext()) {
          System.out.println(locationNames.next()); 
        }
        break;
      case 'p': case 'P':
        System.out.println("Current Location: " + gl.getCopCurrentLocation());
        System.out.println(gl.get(gl.getCopCurrentLocation()));
        break;
      case 'c': case 'C':
        System.out.println("Current Location: " + gl.getCopCurrentLocation());
        Iterator<String> currentConnections = gl.allLocationConnections(gl.getCopCurrentLocation());
        while (currentConnections.hasNext()) {
          System.out.println(currentConnections.next());
        }
        break;
      case 'm': case 'M':
        String s = JOptionPane.showInputDialog("Enter location to move to: ");
        System.out.println("Current Location: " + gl.getCopCurrentLocation());
        gl.moveCop(s);
        System.out.println("Movied to: " + gl.getCopCurrentLocation());
        if (gl.isRobberFound()) {
          System.out.println("Robber Found");
          gl.robberToJail();
          quit(); 
          cmd = 'q';
          break;
        }
        if(!("Jail").equals(gl.breathRobberSearch(gl.getCopCurrentLocation())))
          gl.moveRobber(true);
        break;
      case 's': case 'S':
        System.out.println("Starting Search at Cop's current position \n\tRobber is currently at: " + gl.breathRobberSearch(gl.getCopCurrentLocation()));
        break;
      case 'z': case 'Z':
        gl.write("GameSaved.txt");
        System.out.println("Game saved to file name: GameSaved.txt");
        break;
      case 'g': case 'G':
        gl.getSaved("GameSaved.txt");
        System.out.println("Game restored from file name: GameSaved.txt");
        break;
      case 'q': case 'Q':
        quit ();
        break;
        
      default:
        System.out.println("Invalid command--try again");
    }
    return cmd;
  }
  
  /** quit
    * Method to terminate the WorkerManager program
    */
  private void quit() {        
    System.out.println("Now exiting the game simultor \n");
  }
  
  
}









