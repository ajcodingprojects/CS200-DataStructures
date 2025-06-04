/**
 File InfixToPostfix.java
 */
package expressions;
import ajnstructures.*;
import java.util.*;

/**
 * Class that converts infix expressions to postfix expressions
 * 
 * @author I. Rahal
 * @version April 29, 2022
 */
public class InfixToPostfixV2 {
  
  /**
   * method for processing operators in an infix expression
   * 
   * @param opStackthe operator Stack
   * @param op the postfix expression
   * @param Operator the operator being evaluated
   */
  private static void processOperator(AJNLinkedStack<Token> opStack, AJNLinkedQueue<Token> postfixQueue, Operator op){
    Token topToken = null;
    if(!opStack.isEmpty()) 
      topToken = opStack.peek();
    while (!opStack.isEmpty() && !(topToken instanceof LeftParenthesis) && topToken instanceof Operator && op.getPrecedence() <= ((Operator)topToken).getPrecedence()){
      postfixQueue.enqueue(opStack.pop());
      if (!opStack.isEmpty()) 
        topToken = opStack.peek();
    }
    
    opStack.push(op);
  }
  
  /**
   * method for processing right parenthesis in an infix expression
   * 
   * @param opStack a stack for the operators
   * @param postfixQueuethe postfix expression
   * @throws IllegalArgumentException if no matching left parenthesis is found
   */
  private static void processRightParenthesis(AJNLinkedStack<Token> opStack, AJNLinkedQueue<Token> postfixQueue){
    while(!(opStack.isEmpty()) && !(opStack.peek() instanceof LeftParenthesis)){
      postfixQueue.enqueue(opStack.pop());
    }
    
    if (opStack.isEmpty()) 
      throw new IllegalArgumentException("Unmatched right Parenthesis");
    
    opStack.pop();
  }
  
  /**
   * method for converting infix to postfix
   * 
   * @param infixQueue the infix expression
   * @return queue the postfix expression
   * @throws IllegalArgumentException if no matching right parenthesis is found
   */
  public static AJNLinkedQueue<Token> convert(AJNLinkedQueue<Token> infixQueue){
    AJNLinkedQueue<Token> postfixQueue = new AJNLinkedQueue<Token>();
    AJNLinkedStack<Token> opStack = new AJNLinkedStack<Token>();
    while(!(infixQueue.isEmpty())){
      if(infixQueue.peek() instanceof Operand){
        postfixQueue.enqueue(infixQueue.dequeue());
      }
      else if(infixQueue.peek() instanceof LeftParenthesis){
        opStack.push(infixQueue.dequeue());
      }
       else if(infixQueue.peek() instanceof RightParenthesis){
        infixQueue.dequeue();
        processRightParenthesis(opStack, postfixQueue);
      }
       else {
         if (!infixQueue.isEmpty() && infixQueue.peek() instanceof Operator)
            processOperator(opStack, postfixQueue, (Operator)infixQueue.dequeue());
       }
      
    }
    
    
    while(!(opStack.isEmpty())){
      Token operator = opStack.pop();
      if (operator instanceof LeftParenthesis){
       throw new IllegalArgumentException("Unmatched left parenthesis");
      }
      postfixQueue.enqueue(operator);
    }
    
    return postfixQueue;
  }
}
