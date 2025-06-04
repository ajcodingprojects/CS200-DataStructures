/**
 File PostfixEvaluator.java
 */
package expressions;

import java.util.*;

/**
 * Class that evaluates postfix expressions
 * 
 * @author A. Nerud, G. Peroutka
 * @version Oct 5, 2022
 */
public class PostfixEvaluator {
  
  /**
   * Method to evaluate a given postfix queue
   * 
   * @param postfixQueue a Queue<Token> that will be evaluated
   * 
   * @return the final int value of the end operation
   * @throws IllegalArgumentException if operators don't match properly with operands
   */
  public static int evaluate(Queue<Token> postfixQueue) {
    Deque<Token> evalStack = new ArrayDeque<>();
    System.out.println("----------------------------");
    if (null == postfixQueue || postfixQueue.isEmpty()) 
      throw new IllegalArgumentException("Nothing to evaluate");
    
    while (!postfixQueue.isEmpty()) {
      if (postfixQueue.peek() instanceof Operator) {
        Operator op = (Operator)postfixQueue.remove();
        System.out.println(op.toString());
        
        if (evalStack.isEmpty() || !(evalStack.peek() instanceof Operand)) 
          throw new IllegalArgumentException("Operator with no Operands");
        Operand operand1 = (Operand)evalStack.pop();
        
        if (evalStack.isEmpty() || !(evalStack.peek() instanceof Operand))
          throw new IllegalArgumentException("Operator with only one Operand");
        Operand operand2 = (Operand)evalStack.pop();
        
        evalStack.push(op.evaluate(operand2, operand1));
        
      } else {
        evalStack.push(postfixQueue.remove());
        System.out.println(evalStack.peek());
      }
    }
    System.out.println("******************");
    final int value = ((IntegerLiteral)evalStack.remove()).getValue();
    if (!evalStack.isEmpty())
          throw new IllegalArgumentException("Too many operands");
    
    return value;
  }
  
  
  
}