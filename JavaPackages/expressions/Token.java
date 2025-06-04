/*
 * File: Token.java
 */

package expressions;

/**
 * Root interface for expression Tokens hierarchy
 * 
 * @author I. Rahal
 * @version September 24, 2022
 */
public interface Token {

 /**
  * The type of token. A Java enum is a list of comma-separated values that can be 
  * accessed using the enum name such as Type.OPERATOR
  */
 public static enum Type { OPERATOR, OPERAND, LEFT_PARENTHESIS, RIGHT_PARENTHESIS }
 
 /**
  * Return the type of this token.
  * 
  * @return the type of this token (such as Type.OPERATOR for class Operator and its subclasses)
  */
 public Token.Type getType();
 
 /**
  * Return a string representation of this token.
  * 
  * @return a string representation of this token
  */
 public String toString();
 

}
