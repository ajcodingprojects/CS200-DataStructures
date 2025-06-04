/**
 * Overarching parent class for all entities(cops/robbers)
 * 
 */

import java.io.*;
import java.util.*;

/**
 * Grant Peroutka and Andrew Nerud
 */
public class PeopleEntities implements Serializable {
  
  //The current location of the entity
  private String currentLocation;
  
  /**
   * Default constructor for the class
   */
  public PeopleEntities() {
    this.currentLocation = "Start";
  }
  
  /**
   * Getter for the current location
   */
  public String getCurrentLocation() {
    return currentLocation;
  }
  
  /**
   * Setter for the current location
   * 
   * @param location a String of a new location
   */
  public void setCurrentLocation(String location) {
    this.currentLocation = location;
  }
  
  
}