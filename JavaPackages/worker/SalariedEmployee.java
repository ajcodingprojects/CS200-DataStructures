package worker;

import java.io.*;

/** 
 * This class implements some of the methods pertaining to a worker
 * 
 * @author Andrew Nerud, Grant Peroutka
 * @verion 2022
 */

public class SalariedEmployee implements Employee {
  
  /**
   * String field that is the name of the HourlyWorker
   */
  private String name;
  
   /**
   * double field that is the monthlySalary of the Employee
   */
  private double monthlySalary;
  
  
  /**
   * First constructor for the SalariedEmployee
   *   Instantiates name and monthlySalary fields
   * 
   * @param name a String name of a SalariedEmployee
   */
  public SalariedEmployee(String name) {
    this.name = name;
    this.monthlySalary = 0;
  }
  
   /**
   * Second constructor for the SalariedEmployee
   *   Instantiates name and monthlySalary fields
   * 
   * @param name a String name of a SalariedEmployee
   * @param salary a double of the Salary of the Employee
   * @throws IllegalArgumentException if the value of salary is negative
   */
  public SalariedEmployee(String name, double salary) {
    if (salary < 0) 
      throw new IllegalArgumentException("Cannot have a negative salary");
    
    this.name = name;
    this.monthlySalary = salary;
  }
  
  /**
   * {@inheritDoc}
   */
  public void setMonthlyPay(double pay){
    if (pay < 0) 
      throw new IllegalArgumentException("Cannot have a negative pay");
    this.monthlySalary = pay;
  }
  
  /**
   * {@inheritDoc}
   */
  public double getMonthlyPay(){
    return monthlySalary;
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
  public String toString(){
   return "SalariedEmployee"; 
  }
  
  /**
   * {@inheritDoc}
   */
  public int compareTo(Worker worker) {
    return this.getName().compareTo(worker.getName());
  }
}








