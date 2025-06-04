import expressions.*;
import org.junit.*;
import java.util.*;
import zhstructures.*;
import java.lang.invoke.*;

/**
 * A JUnit test case class for class InfixToPostfix
 */
public class InfixToPostfixTestV2 extends TestClassStats{
  
  @Test
  public void testConvertValid(){
    String input = "344+6*90/3+ (9-3)%5";
    ZHQueue<Token> postfix = InfixToPostfixV2.convert(TokenizerV2.parseString(input));
    Assert.assertTrue("1st token must be 344", postfix.dequeue().toString().equals("344"));
    Assert.assertTrue("2nd token must be 6  ", postfix.dequeue().toString().equals("6"));
    Assert.assertTrue("3rd token must be 90 ", postfix.dequeue().toString().equals("90"));
    Assert.assertTrue("4th token must be *  ", postfix.dequeue().toString().equals("*"));
    Assert.assertTrue("5th token must be 3  ", postfix.dequeue().toString().equals("3"));
    Assert.assertTrue("6th token must be /  ", postfix.dequeue().toString().equals("/"));
    Assert.assertTrue("7th token must be +  ", postfix.dequeue().toString().equals("+"));
    Assert.assertTrue("8th token must be 9  ", postfix.dequeue().toString().equals("9"));
    Assert.assertTrue("9th token must be 3  ", postfix.dequeue().toString().equals("3"));
    Assert.assertTrue("10th token must be - ", postfix.dequeue().toString().equals("-"));
    Assert.assertTrue("11th token must be 5 ", postfix.dequeue().toString().equals("5"));
    Assert.assertTrue("12th token must be % ", postfix.dequeue().toString().equals("%"));
    Assert.assertTrue("13th token must be + ", postfix.dequeue().toString().equals("+"));
    passed = true;
  }
  
  @Test //(expected=IllegalArgumentException.class)
  public void testConvertFailsForExtraLeftParanthesis(){
    try{
      InfixToPostfixV2.convert(TokenizerV2.parseString("344+6*90/3+  (9-3)%(5"));
      passed = false;
    }
    catch (IllegalArgumentException e){
      passed = true;
    }      
  }
  
  @Test //(expected=IllegalArgumentException.class)
  public void testConvertFailsForExtraRightParanthesis(){
    try{
      InfixToPostfixV2.convert(TokenizerV2.parseString("344+6*90/3)+ (9-3)%5"));
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
