package worker;

import java.io.*;

/** 
 * This class implements some of the methods pertaining to a worker
 * 
 * @author Andrew Nerud, Grant Peroutka
 * @verion 2022
 */

public abstract class HourlyWorker implements Worker {
  
  /**
   * String field that is the name of the HourlyWorker
   */
  private String name;
  
  /**
   * int field that is the hours the HourlyWorker has worked
   */
  private int hours;
  
  /**
   * First constructor for the HourlyWorker
   *   Instantiates name and hour fields
   * 
   * @param name a String name of a HourlyWorker
   */
  public HourlyWorker(String name) {
    this.name = name;
    this.hours = 0;
  }
  
  /**
   * Second constructor for the HourlyWorker
   *   Instantiates name and hour fields
   * 
   * @param name a String name of a HourlyWorker
   * @param hours a int number of hours worked
   * @throws IllegalArgumentException if the value of hours is negative
   */
  public HourlyWorker(String name, int hours) {
    if (hours < 0) 
      throw new IllegalArgumentException("Cannot have a negative number of hours");
    
    this.name = name;
    this.hours = hours;
  }
  
  /**
   * Getter for the hours worked by the worker
   * 
   * @return an int the number of hours the HourlyWorker worked
   */
  public int getHours() {
    return this.hours;
  }
  
  /**
   * Method to add a number of hours to the existing hours
   * 
   * @throws IllegalArgumentException if the value of hours is negative
   */
  public void addHours(int hours) {
    if (hours < 0) 
      throw new IllegalArgumentException("Cannot have a negative number of hours");
    
    this.hours += hours;
  }
  
  /**
   * Method to reset the HourlyWorker's hours to zero
   */
  public void resetHours() {
    this.hours = 0;
  }
  
  /**
   * {@inheritDoc}
   */
  public String getName() {
    return this.name;
  }
  
   /**
   * {@inheritDoc}
   */
  public boolean equals(Object other) {
    if (!(other instanceof Worker)) return false;
    
    return this.getName().equals(((Worker)other).getName());
  }
  
  /**
   * {@inheritDoc}
   */
  public int hashCode() {
    return this.getName().hashCode();
  }
  
  /**
   * {@inheritDoc}
   */
  public int compareTo(Worker worker) {
    return this.getName().compareTo(worker.getName());
  }
 
}