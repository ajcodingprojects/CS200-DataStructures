/*
 * File: DoubleTank.java
 */

package tank;

/** 
 * Class DoubleTank implements interface Tank
 * 
 * @author Andrew Nerud, Grant Peroutka
 * @version TODAY'S 9/7/2022
 */

public class DoubleTank implements Tank {
  
  /**
   * A constant to hold default capacity used when creating 
   * a DoubleTank using default (or no parameter) contructor
   */
  public final static double DEFAULT_CAPACITY = 100.0;
  
  /**
   * The amount of fuel in the DoubleTank
   */
   private double level;
  
   /**
    * The maximum amount of fuel the DoubleTank can hold at one time
    */
   private double capacity;
   

  /**
   * Default no parameter constructor: Sets level to 0.0 and 
   * capacity to constant DEFAULT_CAPACITY
   */
  public DoubleTank(){
    this.level = 0.0;
    this.capacity = DEFAULT_CAPACITY;
  }
  
  
  /**
   * One parameter constructor: Sets level to 0.0 and the capacity to a positive number.
   * 
   * @param capacity a double amount of fuel that the DoubleTank can hold.
   * @throws IllegalArgumentException if the @param capacity is less than or equal to zero.
   */
  public DoubleTank(double capacity) {
    this.level = 0.0;
    if (capacity <= 0)
      throw new IllegalArgumentException("Cannot have no or negative capacity for fuel in the tank");
    this.capacity = capacity;
  }
  
  /**
   * Returns a String describing the DoubleTank instance
   *
   * @return a String containing the DoubleTank's level and capacity values
   */
  public String toString(){
    return "The tank has a level of: " + level + ", and a capacity of: " + capacity;
  }
  
  
  /** 
   * {@inheritDoc} 
   */
  public boolean isEmpty(){
    return level == 0.0;
  }
  
  /**
   * {@inheritDoc}
   */  
  public boolean isFull(){
    return level == capacity;
  }
  
  /**
   * {@inheritDoc}
   */  
  public double getCapacity(){
    return capacity;
  }
  
  /**
   * {@inheritDoc}
   */  
  public double getLevel(){
    return level;
  }
  
  /**
   * {@inheritDoc}
   */  
  public void add(double amount){
    if (amount <= 0 || amount + level > capacity)
      throw new IllegalArgumentException("Invalid amount of fuel to be added");
    level += amount;
  }
  
  /**
   * {@inheritDoc}
   */  
  public void remove(double amount){
     if (amount <= 0 || level - amount< 0)
      throw new IllegalArgumentException("Invalid amount of fuel to be removed");
    level -= amount;
  }  
  
}
