package worker;

import java.io.*;

/** 
 * This class extends HourlyWorker as a HourlyEmployee and implements Employee interface
 * 
 * @author Andrew Nerud, Grant Peroutka
 * @verion 2022
 */

public class HourlyEmployee extends HourlyWorker implements Employee {
 
  
  private double hourlyRate;
  
  /**
   * First constructor for HourlyEmployee
   * 
   * @param name a string name of the HourlyEmployee
   */
  public HourlyEmployee(String name){
   super(name); 
   this.hourlyRate = 0;
  }
  
   /**
   * Second constructor for HourlyEmployee
   * 
   * @param name a string name of the HourlyEmployee
   * @param hour an integer number of hours worked
   * @param hourlyRate a double amount worker is paid per hour
   * @throws IllegalArgumentException if the value of hours or hourlyRate is negative 
   */
  public HourlyEmployee(String name, int hours, double hourlyRate){
    super(name, hours);
    if (hourlyRate < 0) 
      throw new IllegalArgumentException("Cannot have a negative hourlyRate");
    
    this.hourlyRate = hourlyRate;
  }
  
  /**
   * Method to get the hourlyRate of the Employee
   * 
   * @return returns a double of the hourlyRate
   */
  public double getHourlyRate(){
    return hourlyRate;
  }
  
  /**
   * Method to set the rate of the employee
   * 
   * @param rate a double of the employees hourlyRate
   * @throws IllegalArgumentException if the value of rate is negative
   */
  public void setHourlyRate(double rate){
    if (rate < 0) 
      throw new IllegalArgumentException("Cannot have a negative rate");
    this.hourlyRate =  rate;
  }
  
  /**
   * {@inheritDoc}
   */
  public String toString(){
   return "HourlyEmployee"; 
  }
  
  /**
   * {@inheritDoc}
   */
  public double getMonthlyPay(){
   return hourlyRate * getHours(); 
  }
}


