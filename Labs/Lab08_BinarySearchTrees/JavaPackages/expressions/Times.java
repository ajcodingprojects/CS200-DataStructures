/*
 * File: Times.java
 */

package expressions;

/**
 * Class that represents an Times as a Operator
 * 
 * @author A. Nerud, G. Peroutka
 * @version Oct 5, 2022
 */
public class Times extends Operator {
  
  /**
   * an int encasing the presdence of Times signs
   */
  private static final int presedence = 2;
  
  /**
   * {@inheritDoc}
   */
  public int getPrecedence() {
    return presedence;
  }
  
  /**
   * {@inheritDoc}
   */
  public Operand evaluate(Operand first, Operand second) {
    return new IntegerLiteral(first.getValue() * second.getValue());
  }
  
  /**
   * Returns the string of the value of the Operator
   * 
   * @return the string value of the Times
   */
  public String toString() {
    return "*";
  }
}
