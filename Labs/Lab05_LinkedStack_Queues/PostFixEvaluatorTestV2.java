import expressions.*;
import org.junit.*;
import java.util.*;
import zhstructures.*;
import java.lang.invoke.*;

/**
 * A JUnit test case class for class PostfixEvaluator.
 */
public class PostFixEvaluatorTestV2 extends TestClassStats{
  
  @Test
  public void testEvaluate(){
    int result = PostfixEvaluatorV2.evaluate(InfixToPostfixV2.convert(TokenizerV2.parseString("344+6*90/3+ (9-3)%5")));
    Assert.assertTrue("Expression should evaluate to 525 but instead gave " + result ,result==525);
    passed = true;
  }  
  
  @Test //(expected=IllegalArgumentException.class)
  public void testEvaluateFailsWhenMissingOneOperand(){
    try{
      PostfixEvaluatorV2.evaluate(InfixToPostfixV2.convert(TokenizerV2.parseString("344+6*")));
      passed = false;
    }
    catch (IllegalArgumentException e){
      passed = true;
    }     
  }    
  
  @Test //(expected=IllegalArgumentException.class)
  public void testEvaluateFailsWhenMissingTwoOperands(){
    try{
      PostfixEvaluatorV2.evaluate(InfixToPostfixV2.convert(TokenizerV2.parseString("*")));
      passed = false;
    }
    catch (IllegalArgumentException e){
      passed = true;
    }             
  }    
  
  @Test //(expected=IllegalArgumentException.class)
  public void testEvaluateFailsWithTooManyOperands(){
    try{
          PostfixEvaluatorV2.evaluate(InfixToPostfixV2.convert(TokenizerV2.parseString("344+6*90/3+ (9-3)%5 6")));
      passed = false;
    }
    catch (IllegalArgumentException e){
      passed = true;
    }      
  }  
  
  @AfterClass
  public static void reportStats(){    
    Class me = MethodHandles.lookup().lookupClass();
    System.out.println(tallyStats(me));
  }  
}
