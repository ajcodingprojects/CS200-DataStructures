import java.io.*;
/** 
 * Class that represents a computer.
 * 
 * @author Koffman & Wolfgang
 * @version 08/31/2009
 * */

public class Computer implements Serializable{
  /**
   * The name of the computer manufacturer
   */
  private String manufacturer;
  /**
   * The processor of the computer
   */  
  private String processor;
  /**
   * The size of the computer's RAM in GB
   */    
  private int ramSize;


  // Methods
  /** 
   * Initializes a Computer object with all properties specified.
   * 
   * @param man The computer manufacturer
   * @param processor The processor type
   * @param ram The RAM size
   */
  public Computer(String manufacturer, String processor, int ramSize) {
    this.manufacturer = manufacturer ;
    this.processor = processor;
    this.ramSize = ramSize;
  }
  /**
   * Accessor method which returns the ramSize
   * 
   * @return An int representing the size of the computer's RAM in MB 
   */ 
  public int getRamSize() {
    return this.ramSize;
  }

  /**
   * Accessor method which returns the manufacturer
   * 
   * @return A String representing the computer manufacturer
   */
  public String getManufacturer() {
    return this.manufacturer;
  }

  /**
   * Accessor method which returns the processor
   * 
   * @return A String representing the computer processor
   */
  public String getProcessor() {
    return this.processor;
  }
 
  /**
   * Mutator method to set the ramSize
   * 
   * @param newSize an int that represents the new ramSize
   */ 
  public void setRamSize(int newSize) {
    this.ramSize = newSize;
  }
 
  /**
   * Mutator method to set the manufacturer
   * 
   * @param newManufacturer a String that represents the new manufacturer
   */ 
  public void setManufacturer(String newManufacturer) {
    this.manufacturer = newManufacturer;
  }
  
  /**
   * Mutator method to set the processor
   * 
   * @param newProcessor a String that represents the new processor
   */ 
  public void setProcessor(String newProcessor) {
    this.processor = newProcessor;
  }
  
  /**
   * An overriden method that returns the a description of the computer
   * 
   * @return A String that describes the computer
   */ 
  public String toString() {
    String result = "Manufacturer: " + this.manufacturer +
        "\nCPU: " + this.processor +
        "\nRAM: " + this.ramSize + " gigabytes";
    return result;
  }
}
