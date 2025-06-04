package worker;

import java.io.*;
/** 
 * This class implements some of the methods pertaining to an Employee
 * 
 * @author Andrew Nerud, Grant Peroutka
 * @verion 2022
 */

public interface Employee extends Worker {
  
  /**
   * Returns the monthly pay for the Employee
   * 
   * @return a double of the employees monthly pay
   */
  public double getMonthlyPay();
}