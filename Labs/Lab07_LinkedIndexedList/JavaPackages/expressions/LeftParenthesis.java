/*
 * File: LeftParenthesis.java
 */

package expressions;

/**
 * A type of the Token interface as a LeftParenthesis
 * 
 * @author A. Nerud, G. Peroutka
 * @version Oct 5, 2022
 */
public class LeftParenthesis implements Token {
 
 /**
  * {@inheritDoc}
  */
  public Token.Type getType() {
    return Token.Type.LEFT_PARENTHESIS;
  }
 
 /**
  * {@inheritDoc}
  */
  public String toString() {
    return "(";
  }
 

}
