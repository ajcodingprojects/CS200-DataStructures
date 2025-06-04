/*
 * File: Tank.java
 */

package tank;

/** 
 * Tank is an interface for objects that hold a quantity of some substance
 * up to a maximum capacity.
 * 
 * @author John Miller, Imad Rahal and J. Andrew Holey
 * @version September 02, 2022
 */
public interface Tank
{
  /**
   * Method to see whether or not the tank' level is empty
   * 
   * @return a boolean whether the tank is empty or not
   */
  public boolean isEmpty();
  
  /**
   * Method to see whether the tank's level is full or not
   *
   * @return a boolean whether the tank is full or not
   */
  public boolean isFull();
  
  /**
   * Getter for the tank's capacity
   *
   * @return double of the tank's capacity
   */
  public double getCapacity();
  
  /**
   * Getter for the tank's level
   *
   * @return double of the tank's level
   */
  public double getLevel();
 
  /**
   * Method to add fuel to the tank
   *
   * @param amount a double of fuel to be added
   * @throws IllegalArugmentException if the @param amount is less than or equal to zero
   *     or makes the level greater than the total capacity
   */
  public void add(double amount);
  
  /**
   * Method to remove fuel from the tank
   *
   * @param amount a double of fuel to be removed
   * @throws IllegalArugmentException if the @param amount is less than or equal to zero
   *     or makes the level less than 0
   */
  public void remove(double amount);

}
