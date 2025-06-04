/*
 * File: RightParenthesis.java
 */

package expressions;

/**
 * A type of the Token interface as a RightParenthesis
 * 
 * @author A. Nerud, G. Peroutka
 * @version Oct 5, 2022
 */
public class RightParenthesis implements Token {
 
 /**
  * {@inheritDoc}
  */
  public Token.Type getType() {
    return Token.Type.RIGHT_PARENTHESIS;
  }
 
 /**
  * {@inheritDoc}
  */
  public String toString() {
    return ")";
  }
 

}
