/*
 * File: IntegerLiteral.java
 */

package expressions;

/**
 * Class that represents an IntegerLiteral as a Operand
 * 
 * @author A. Nerud, G. Peroutka
 * @version Oct 5, 2022
 */
public class IntegerLiteral extends Operand {
  
  /**
   * int field to store the value of the given IntegerLiteral
   */
  private int value;
  
  /**
   * First constructor that takes a int value and stores it in the value field
   * 
   * @param value an int that is the value of IntegerLiteral
   */
  public IntegerLiteral(int value) {
    this.value = value;
  }
  
  /**
   * Second constructor that takes a String value and stores it in the value field
   * 
   * @param value a String that will be parsed as the value of IntegerLiteral
   * @throws IllegalArgumentException if the {@param value} cannot be parsed as an int
   */
  public IntegerLiteral(String value) {
    this.value = Integer.parseInt(value);
  }
  
  /**
   * {@inheritDoc}
   */
  public int getValue() {
    return value;
  }
  
  /**
   * Returns the string of the value of the literal
   * 
   * @return the string value of the IntegerLiteral
   */
  public String toString() {
    return value + "";
  }
}
