/**
 * Driver Class for the game
 * 
 */

import java.io.*;
import java.util.*;

/**
 * Grant Peroutka and Andrew Nerud
 */
public class GameSimulator {
  
  public static void main(String args[]) {
    GameLayout game = new GameLayout("LocationsList.txt", "ConnectionsList.txt");
    
    System.out.println("\n********************All Location Names*********************");
    Iterator<String> locationNames = game.allLocations();
    while (locationNames.hasNext()) {
     System.out.println(locationNames.next()); 
    }
    
        
    System.out.println("\n********************Location Properties*********************");
    String currentPosition = game.getCopCurrentLocation();
    System.out.println("Current Location: " + currentPosition);
    System.out.println(game.get(currentPosition));
    
    System.out.println("\n********************Location Connections*********************");
    System.out.println("Current Location: " + currentPosition);
    Iterator<String> currentConnections = game.allLocationConnections(currentPosition);
    while (currentConnections.hasNext()) {
      System.out.println(currentConnections.next());
    }
    
    System.out.println("\n********************Shifting Locations*********************");
    System.out.println("Current Location: " + currentPosition);
    game.moveEntity(game.getCop(), "Minneapolis");
    
    System.out.println("Movied to: " + game.getCopCurrentLocation());
    
    
    System.out.println("\n********************Search for Robber*********************");
    System.out.println("Starting Search at Cop's current position \n\tRobber is currently at: " + game.breathRobberSearch(game.getCopCurrentLocation()));
    
    System.out.println("\n********************Write / Save*********************");
    game.write("GameSaved.txt");
    System.out.println("Game saved to file name: GameSaved.txt");
    GameLayout fromSaved = new GameLayout();
    fromSaved.getSaved("GameSaved.txt");
    System.out.println("Game restored from file name: GameSaved.txt");
    String currentPosition1 = fromSaved.getCopCurrentLocation();
    System.out.println("Current Location: " + currentPosition1);
    System.out.println(fromSaved.get(currentPosition1));
    
    
    
  }
}









