/*
 * File: Operand.java
 */

package expressions;

/**
 * Class that represents a Token of type Operand
 * 
 * @author I. Rahal
 * @version September 24, 2022
 */
public abstract class Operand implements Token{
  
 /**
  * {@inheritDoc} 
  */
  public Token.Type getType(){
    return Type.OPERAND;
  }
  
  /**
   * returns the integer value of this Operand
   * 
   * @return the integer value of this Operand 
   */
  public abstract int getValue();
}
