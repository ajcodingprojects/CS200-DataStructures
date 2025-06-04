package worker;

import java.io.*;
/** 
 * This class implements some of the methods pertaining to a worker
 * 
 * @author Andrew Nerud, Grant Peroutka
 * @verion 2022
 */

public interface Worker extends Serializable, Comparable<Worker> {
  
  /**
   * Getter for the name of the worker
   * 
   * @return a String the name of the worker
   */
  public String getName();
  
   /**
   * Method to check if a worker is the same as another worker
   *     if {@param other} is not a worker then it returns false
   * 
   * @param other is a Object passed in
   * @return boolean whether or not the Worker's name are the same
   */
  public boolean equals(Object other);
  
   /**
   * Method to put the worker object into a readable string
   * 
   * @return String a name of the worker
   */
  public String toString();
  
   /**
   * Gets the hash code for the worker object
   *   The hash code correlates to the hash code of the string
   * 
   * @return int hash code value for the name
   */
  public int hashCode();
  
  /**
   * {@inheritDoc}
   */
  public int compareTo(Worker worker);
}