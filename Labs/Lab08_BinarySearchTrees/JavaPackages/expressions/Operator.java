/*
 * File: Operator.java
 */

package expressions;

/**
 * Class that represents a Token of type Operator
 * 
 * @author A. Nerud, G. Peroutka
 * @version Oct 5, 2022
 */
public abstract class Operator implements Token{
  
  /**
  * {@inheritDoc} 
  */
  public Token.Type getType(){
    return Type.OPERATOR;
  }
  
  /**
   * Method to get the precedence of the given operator
   * 
   * @return a precedence of 1 for the Plus and Minus classes, 2 for Times, Divide and Remainder
   */
  public abstract int getPrecedence();
  
  /**
   * Method to perfom the appropriate operation of the given Operator on the Operands
   * 
   * @return an Operand of an new IntegerLiteral that is created as a result of the Operator
   */
  public abstract Operand evaluate(Operand first, Operand second);
  
  
}