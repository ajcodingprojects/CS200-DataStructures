/*
 * File: Tokenizer.java
 */

package expressions;
import ajnstructures.*;
import java.util.*;

/**
 * Class that encapsulates methods for extracting tokens from a String
 * that represents an arithmetic expression.  
 * 
 * @author I. Rahal
 * @version April 29, 2022
 */
public class TokenizerV2 {

  /**
   * Returns a Token based on the supplied token string.
   * 
   * @param tokenStr the string the token is to be based on
   * @return a Token based on the supplied token string
   * @throws IllegalArgumentException if tokenStr doesn't represent a valid token
   */
 public static Token makeToken(String tokenStr) {
   Token result = null;
   
   //get first character in tokenStr
   char firstChar=tokenStr.charAt(0);
   
   //if first character is a digit, return an IntegerLiteral
   if(Character.isDigit(firstChar)){
      result = new IntegerLiteral(tokenStr);
   }
   else{//not a digit so it must be a single operator character
        //find out which operator or throw exception if no matches are found
     switch (firstChar){
        case '+' : result = new Plus(); break;
        case '-' : result = new Minus(); break;
        case '*' : result = new Times(); break;
        case '/' : result = new Divide(); break;
        case '(' : result = new LeftParenthesis(); break;
        case ')' : result = new RightParenthesis(); break;
        case '%' : result = new Remainder(); break;
        default: throw new IllegalArgumentException("Invalid expression token");
     }
   }
  
  return result;
 }
 
  /**
   * Parses the supplied token string and returns a queue of tokens.
   * 
   * @param tokensStr the string the tokens are to be parsed from
   * @return a queue of tokens in the same order they appeared in the original string
   * @throws IllegalArgumentException if tokensStr contains unparseable subsequences
   */
 public static AJNLinkedQueue<Token> parseString(String tokensStr) {
  //start with an empty queue of tokens 
  AJNLinkedQueue<Token> queue=new AJNLinkedQueue<Token>();
  
  //loop over all characaters in string tokensStr
  for(int i = 0; i < tokensStr.length(); i++){
    
    //a fast way to check if character at location i in 
    // tokensStr is an operator or a parenthesis 
    if(("+-*%/)(").indexOf(tokensStr.charAt(i))!=-1){
    
      //call makeToken on that character and then
      //enqueue the resulting token to the queuee
      Token token = makeToken(tokensStr.substring(i,i+1));
      queue.enqueue(token);   
    }
    //check if character at location i in tokensStr is a digit 
    else if(Character.isDigit(tokensStr.charAt(i))){
      for(int j = i+1; j <= tokensStr.length(); j++) {
        if (j == tokensStr.length()) {
          Token token = makeToken(tokensStr.substring(i));
          queue.enqueue(token);
          i = j-1;
          break;
        }
        if (!Character.isDigit(tokensStr.charAt(j))) {
          Token token = makeToken(tokensStr.substring(i,j));
          queue.enqueue(token);
          i = j-1;
          break;
        }
      }
    } else if ((" ").indexOf(tokensStr.charAt(i)) == -1) {
      throw new IllegalArgumentException("Illegal Character: " + tokensStr.charAt(i));
    }
    
    
      
  }

  return queue;
 }
}
