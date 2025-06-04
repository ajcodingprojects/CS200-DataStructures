import expressions.*;
import org.junit.*;
import java.util.*;
import java.lang.reflect.*;

/**
 * A JUnit test case class for the Token hierarchy.
 */
public class TokenHierarchyTest {
  
  @Test
  public void testIntegerLiteralIntegerParamConstructor(){
    IntegerLiteral il = new IntegerLiteral(20);
    
    Assert.assertTrue( "getValue() for IntegerLiteral returns 20 ",
                      il.getValue()==20);  
    
    Assert.assertTrue( "toString() for IntegerLiteral returns \"20\" ",
                      il.toString().equals("20"));                         
  }
  
  @Test
  public void testIntegerLiteralStringParamConstructor(){
    IntegerLiteral il = new IntegerLiteral("-20");
    
    Assert.assertTrue( "getValue() for IntegerLiteral returns -20 ",
                      il.getValue()==-20);  
    
    Assert.assertTrue( "toString() for IntegerLiteral returns -\"20\" ",
                      il.toString().equals("-20"));  
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testIntegerLiteralStringParamConstructorFails(){
    new IntegerLiteral("20x");
    
  }
  
  @Test
  public void testPolymorphismForIntegerLiteral(){
    Token il = new IntegerLiteral(1);
    Assert.assertTrue( "IntegerLiteral is a Token ",
                      il instanceof Token);
    
    Assert.assertTrue( "IntegerLiteral is an Operand ",
                      il instanceof Operand);
    
    Assert.assertFalse( "IntegerLiteral is NOT a LeftParenthesis ",
                       il instanceof LeftParenthesis);
    
    Assert.assertFalse("IntegerLiteral is NOT a RightParenthesis ",
                       il instanceof RightParenthesis);
    
    Assert.assertFalse("IntegerLiteral is NOT an Operator ",
                       il instanceof Operator);    
  }
  
  @Test
  public void testLeftParenthesisMethods(){
    LeftParenthesis op = new LeftParenthesis();
    
    Assert.assertTrue( "toString() for LeftParenthesis returns ( ",
                      op.toString().equals("("));                         
  }
  
  @Test
  public void testPolymorphismForLeftParenthesis(){
    Token op = new LeftParenthesis();
    Assert.assertTrue( "LeftParenthesis is a Token ",
                      op instanceof Token);
    
    Assert.assertFalse( "LeftParenthesis is NOT an Operator ",
                       op instanceof Operator);
    
    Assert.assertFalse("LeftParenthesis is NOT a RightParenthesis ",
                       op instanceof RightParenthesis);
    
    Assert.assertFalse("LeftParenthesis is NOT an Operand ",
                       op instanceof Operand);    
  }  
  
  @Test
  public void testRightParenthesisMethods(){
    RightParenthesis op = new RightParenthesis();
    
    Assert.assertTrue( "toString() for RightParenthesis returns ) ",
                      op.toString().equals(")"));                         
  }
  
  @Test
  public void testPolymorphismForRightParenthesis(){
    Token op = new RightParenthesis();
    Assert.assertTrue( "RightParenthesis is a Token ",
                      op instanceof Token);
    
    Assert.assertFalse( "RightParenthesis is NOT an Operator ",
                       op instanceof Operator);
    
    Assert.assertFalse("RightParenthesis is NOT a LeftParenthesis ",
                       op instanceof LeftParenthesis);
    
    Assert.assertFalse("RightParenthesis is NOT an Operand ",
                       op instanceof Operand);    
  }    
  @Test
  public void testPlusMethods(){
    Plus op = new Plus();
    
    Assert.assertTrue( "getPrecedence() for Plus returns 1 ",
                      op.getPrecedence()==1);  
    
    Assert.assertTrue( "toString() for Plus returns + ",
                      op.toString().equals("+"));                      
    
    Operand left = new IntegerLiteral(5);
    Operand right = new IntegerLiteral(13);
    Operand answer =  op.evaluate(left, right);
    
    Assert.assertTrue( "Evaluate for 5 and 13 returns 18 ",
                      answer.getValue()==(new IntegerLiteral(18)).getValue());   
  }
  
  @Test
  public void testPolymorphismForPlus(){
    Token op = new Plus();
    Assert.assertTrue( "Plus is a Token ",
                      op instanceof Token);
    
    Assert.assertTrue( "Plus is an Operator ",
                      op instanceof Operator);
    
    Assert.assertFalse( "Plus is NOT a LeftParenthesis ",
                       op instanceof LeftParenthesis);
    
    Assert.assertFalse("Plus is NOT a RightParenthesis ",
                       op instanceof RightParenthesis);
    
    Assert.assertFalse("Plus is NOT an Operand ",
                       op instanceof Operand);    
  }
  
  @Test
  public void testMinusMethods(){
    Minus op = new Minus();
    
    Assert.assertTrue( "getPrecedence() for Minus returns 1 ",
                      op.getPrecedence()==1);  
    
    Assert.assertTrue( "toString() for Minus returns - ",
                      op.toString().equals("-"));      
    
    Operand left = new IntegerLiteral(5);
    Operand right = new IntegerLiteral(13);
    Operand answer =  op.evaluate(left, right);
    
    Assert.assertTrue( "Evaluate for 5 and 13 returns -8 ",
                      answer.getValue()==(new IntegerLiteral(-8)).getValue());  
    
    answer =  op.evaluate(right, left);
    
    Assert.assertTrue( "Evaluate for 13 and 5 returns 8 ",
                      answer.getValue()==(new IntegerLiteral(8)).getValue());     
  }
  
  @Test
  public void testPolymorphismForMinus(){
    Token op = new Minus();
    Assert.assertTrue( "Minus is a Token ",
                      op instanceof Token);
    
    Assert.assertTrue( "Minus is an Operator ",
                      op instanceof Operator);
    
    Assert.assertFalse( "Minus is NOT a LeftParenthesis ",
                       op instanceof LeftParenthesis);
    
    Assert.assertFalse("Minus is NOT a RightParenthesis ",
                       op instanceof RightParenthesis);
    
    Assert.assertFalse("Minus is NOT an Operand ",
                       op instanceof Operand);    
  }
  
  @Test
  public void testTimesMethods(){
    Times op = new Times();
    
    Assert.assertTrue( "getPrecedence() for Times returns 2 ",
                      op.getPrecedence()==2);  
    
    Assert.assertTrue( "toString() for Times returns - ",
                      op.toString().equals("*"));      
    
    Operand left = new IntegerLiteral(5);
    Operand right = new IntegerLiteral(13);
    Operand answer =  op.evaluate(left, right);
    
    Assert.assertTrue( "Evaluate for 5 and 13 returns 65 ",
                      answer.getValue()==(new IntegerLiteral(65)).getValue());   
  }
  
  @Test
  public void testPolymorphismForTimes(){
    Token op = new Times();
    Assert.assertTrue( "Times is a Token ",
                      op instanceof Token);
    
    Assert.assertTrue( "Times is an Operator ",
                      op instanceof Operator);
    
    Assert.assertFalse( "Times is NOT a LeftParenthesis ",
                       op instanceof LeftParenthesis);
    
    Assert.assertFalse("Times is NOT a RightParenthesis ",
                       op instanceof RightParenthesis);
    
    Assert.assertFalse("Times is NOT an Operand ",
                       op instanceof Operand);    
  }  
  
  @Test
  public void testDivideMethods(){
    Divide op = new Divide();
    
    Assert.assertTrue( "getPrecedence() for Divide returns 2 ",
                      op.getPrecedence()==2);  
    
    Assert.assertTrue( "toString() for Divide returns / ",
                      op.toString().equals("/"));      
    
    Operand left = new IntegerLiteral(5);
    Operand right = new IntegerLiteral(13);
    Operand answer =  op.evaluate(left, right);
    
    Assert.assertTrue( "Evaluate for 5 and 13 returns 0 ",
                      answer.getValue()==(new IntegerLiteral(0)).getValue());   
    
    answer =  op.evaluate(right, left);  
    
    Assert.assertTrue( "Evaluate for 13 and 5 returns 2 ",
                      answer.getValue()==(new IntegerLiteral(2)).getValue());  
  }  
  
  @Test
  public void testPolymorphismForDivide(){
    Token op = new Divide();
    Assert.assertTrue( "Divide is a Token ",
                      op instanceof Token);
    
    Assert.assertTrue( "Divide is an Operator ",
                      op instanceof Operator);
    
    Assert.assertFalse( "Divide is NOT a LeftParenthesis ",
                       op instanceof LeftParenthesis);
    
    Assert.assertFalse("Divide is NOT a RightParenthesis ",
                       op instanceof RightParenthesis);
    
    Assert.assertFalse("Divide is NOT an Operand ",
                       op instanceof Operand);    
  }  
  
  @Test
  public void testRemainderMethods(){
    Remainder op = new Remainder();
    
    Assert.assertTrue( "getPrecedence() for Remainder returns 2 ",
                      op.getPrecedence()==2);  
    
    Assert.assertTrue( "toString() for Remainder returns % ",
                      op.toString().equals("%"));      
    
    Operand left = new IntegerLiteral(5);
    Operand right = new IntegerLiteral(13);
    Operand answer =  op.evaluate(left, right);
    
    Assert.assertTrue( "Evaluate for 5 and 13 returns 5 ",
                      answer.getValue()==(new IntegerLiteral(5)).getValue());   
    
    answer =  op.evaluate(right, left);  
    
    Assert.assertTrue( "Evaluate for 13 and 5 returns 3 ",
                      answer.getValue()==(new IntegerLiteral(3)).getValue());  
  }  
  
  @Test
  public void testPolymorphismForRemainder(){
    Token op = new Remainder();
    Assert.assertTrue( "Remainder is a Token ",
                      op instanceof Token);
    
    Assert.assertTrue( "Remainder is an Operator ",
                      op instanceof Operator);
    
    Assert.assertFalse( "Remainder is NOT a LeftParenthesis ",
                       op instanceof LeftParenthesis);
    
    Assert.assertFalse("Remainder is NOT a RightParenthesis ",
                       op instanceof RightParenthesis);
    
    Assert.assertFalse("Remainder is NOT an Operand ",
                       op instanceof Operand);    
  }  
  
  
  @Test
  public void tesRemainingMethods(){
    Token il = new IntegerLiteral(20);
    Assert.assertEquals( "Token's getType() returns Type.OPERAND for IntegerLiteral",
                        il.getType(), Token.Type.OPERAND);
    
    Token op = new Plus();
    Assert.assertEquals( "Token's getType() returns Type.OPERATOR for Plus",
                        op.getType(), Token.Type.OPERATOR);
    
    Token lp = new LeftParenthesis();
    Assert.assertEquals( "Token's getType() returns Type.LEFT_PARENTHESIS for LeftParethesis",
                        lp.getType(), Token.Type.LEFT_PARENTHESIS);
    
    Token rp = new RightParenthesis();
    Assert.assertEquals( "Token's getType() returns Type.RIGH_PARENTHESIS for RightParethesis",
                        rp.getType(), Token.Type.RIGHT_PARENTHESIS); 
    
    Assert.assertTrue( "Token has a toString() method ",
                      il.toString().equals("20"));   
    
    Assert.assertTrue( "Operator has a getPrecedence() method ",
                      ((Operator)op).getPrecedence()==1); 
    
    Assert.assertTrue( "Operator has an evaluate(...) method ",
                      ((Operator)op).evaluate((Operand)il,(Operand)il).getValue()==40); 
    
    Assert.assertTrue( "Operand has a getValue() method ",
                      ((Operand)il).getValue()==20);     
  }
  
  @Test
  public void testTokenInterfaceStructure() throws SecurityException{
    Class<expressions.Token> token = expressions.Token.class;
    Assert.assertTrue(token.getSimpleName() + " is an interface in package expressions" ,  
                      token.isInterface() &&
                      token.getInterfaces().length==0 && 
                      token.getPackage().getName().equals("expressions"));   
    
    Class<expressions.Token.Type> type = expressions.Token.Type.class;
    Assert.assertTrue(token.getName() + " should contain a public static enum called Type" ,
                      type.getName().equals("expressions.Token$Type") && 
                      type.isEnum() &&
                      Modifier.isPublic(type.getModifiers()) &&
                      Modifier.isStatic(type.getModifiers()));
    String possibleValues = "OPERATOROPERANDLEFT_PARENTHESISRIGHT_PARENTHESIS";
    for (int i=0; i<type.getEnumConstants().length;i++){
      Assert.assertTrue("possible values for enum should be:{ OPERATOR, OPERAND, LEFT_PARENTHESIS, RIGHT_PARENTHESIS }",
                        possibleValues.indexOf(type.getEnumConstants()[i].toString())>-1);
    }
    
    Map<String,String> allMethods = new HashMap<String,String>() {
      {
        put("getType", "Type");
        put("toString", "String");
      }
    };
    testMethods(token,allMethods);      
  }
  
  @Test
  public void testOperandClassStructure() throws SecurityException, NoSuchMethodException{
    Class<expressions.Operand> operand = expressions.Operand.class;
    Assert.assertTrue(operand.getSimpleName() + " is an abstract class in package expressions that implements Token" ,  
                      !operand.isInterface() &&
                      Modifier.isPublic(operand.getModifiers()) &&
                      Modifier.isAbstract(operand.getModifiers()) &&
                      operand.getInterfaces()[0].getSimpleName().equals("Token") && 
                      operand.getPackage().getName().equals("expressions"));         
    
    Map<String,String> allFields = new HashMap<String,String>();
    testFields(operand,allFields); 
    
    Map<String,String> allMethods = new HashMap<String,String>() {
      {
        put("getType", "Type");
        put("getValue", "int");
      }
    };
    testMethods(operand,allMethods); 
    Assert.assertTrue("getValue is an abstract method " ,  
                      Modifier.isAbstract(operand.getMethod("getValue").getModifiers()));    
  }
  
  @Test
  public void testOperatorClassStructure() throws SecurityException, NoSuchMethodException{
    Class<expressions.Operator> operator = expressions.Operator.class;
    Assert.assertTrue(operator.getSimpleName() + " is an abstract class in package expressions that implements Token" ,  
                      !operator.isInterface() &&
                      Modifier.isPublic(operator.getModifiers()) &&
                      Modifier.isAbstract(operator.getModifiers()) &&
                      operator.getInterfaces()[0].getSimpleName().equals("Token") && 
                      operator.getPackage().getName().equals("expressions"));         
    
    Map<String,String> allFields = new HashMap<String,String>();
    testFields(operator,allFields); 
    
    Map<String,String> allMethods = new HashMap<String,String>() {
      {
        put("getType", "Type");
        put("getPrecedence", "int");
        put("evaluate", "Operand");
      }
    };
    testMethods(operator,allMethods); 
    Assert.assertTrue("getPrecedence is an abstract method " ,  
                      Modifier.isAbstract(operator.getMethod("getPrecedence").getModifiers()));    
  } 
  
  @Test
  public void testLeftParenthesisClassStructure() throws SecurityException, NoSuchMethodException{
    Class<expressions.LeftParenthesis> left = expressions.LeftParenthesis.class;
    Assert.assertTrue(left.getSimpleName() + " is a class in package expressions that implements Token" ,  
                      !left.isInterface() &&
                      Modifier.isPublic(left.getModifiers()) &&
                      !Modifier.isAbstract(left.getModifiers()) &&
                      left.getInterfaces()[0].getSimpleName().equals("Token") && 
                      left.getPackage().getName().equals("expressions"));         
    
    Map<String,String> allFields = new HashMap<String,String>();
    testFields(left,allFields); 
    
    Map<String,String> allMethods = new HashMap<String,String>() {
      {
        put("getType", "Type");
        put("toString", "String");
      }
    };
    testMethods(left,allMethods); 
  }  
  
  @Test
  public void testRightParenthesisClassStructure() throws SecurityException, NoSuchMethodException{
    Class<expressions.RightParenthesis> right = expressions.RightParenthesis.class;
    Assert.assertTrue(right.getSimpleName() + " is an class in package expressions that implements Token" ,  
                      !right.isInterface() &&
                      Modifier.isPublic(right.getModifiers()) &&
                      !Modifier.isAbstract(right.getModifiers()) &&
                      right.getInterfaces()[0].getSimpleName().equals("Token") && 
                      right.getPackage().getName().equals("expressions"));         
    
    Map<String,String> allFields = new HashMap<String,String>();
    testFields(right,allFields); 
    
    Map<String,String> allMethods = new HashMap<String,String>() {
      {
        put("getType", "Type");
        put("toString", "String");
      }
    };
    testMethods(right,allMethods); 
  }    
  
  
  @Test
  public void testIntegerLiteralClassStructure() throws SecurityException, NoSuchMethodException{
    Class<expressions.IntegerLiteral> intLit = expressions.IntegerLiteral.class;
    Assert.assertTrue(intLit.getSimpleName() + " is a class in package expressions that implements Token" ,  
                      !intLit.isInterface() &&
                      Modifier.isPublic(intLit.getModifiers()) &&
                      !Modifier.isAbstract(intLit.getModifiers()) &&
                      intLit.getSuperclass().getSimpleName().equals("Operand") && 
                      intLit.getPackage().getName().equals("expressions"));         
    
    Map<String,String> allFields = new HashMap<String,String>() {
      {
        put("value", "int");
      }
    };
    testFields(intLit,allFields); 
    
    Map<String,String> allMethods = new HashMap<String,String>() {
      {
        put("getValue", "int");
        put("toString", "String");
      }
    };
    testMethods(intLit,allMethods); 
    
    Constructor[] constructors  = intLit.getDeclaredConstructors();
    Assert.assertEquals(intLit.getName() + " should have at least 2 constructors", 
                        2, constructors.length);
    
    for (Constructor con: constructors){
      String paramList = "";
      for(Class cl: con.getParameterTypes()){
        paramList += cl.getSimpleName();
      }
      Assert.assertTrue(intLit.getName() + " should contain constructor: public " + con.getName() + " with " + con.getParameterCount() + " paramaters " , 
                        paramList.equals("int") || paramList.equals("String"));  
    }
  }    
  
  @Test
  public void testLeafOperatorClassStructure() throws SecurityException, NoSuchMethodException{
    Class[] operators = { expressions.Plus.class, expressions.Minus.class, expressions.Times.class, 
                          expressions.Divide.class, expressions.Remainder.class};
    for(Class c: operators){
      Assert.assertTrue(c.getSimpleName() + " is a class in package expressions that extends Operator" ,  
                           !c.isInterface() &&
                           Modifier.isPublic(c.getModifiers()) &&
                           !Modifier.isAbstract(c.getModifiers()) &&
                           c.getSuperclass().getSimpleName().equals("Operator") && 
                           c.getPackage().getName().equals("expressions"));         
    
      Field[] fields = c.getDeclaredFields();
      Assert.assertEquals(c.getName() + " should have 1 declared field ", 1, fields.length);    
      Assert.assertTrue(c.getName() + " should contain static final field: " + 
                        fields[0].getType().getSimpleName() + " " + fields[0].getName(),
                        fields[0].getType().getSimpleName().equals("int") &&
                        Modifier.isFinal(fields[0].getModifiers()) &&
                        Modifier.isStatic(fields[0].getModifiers()));
    
      Map<String,String> allMethods = new HashMap<String,String>() {
        {
          put("getPrecedence", "int");
          put("evaluate", "Operand");
          put("toString", "String");
        }
      };
      testMethods(c,allMethods); 
    }
  }  
  //Helper method to check if a given class contains the expected fields 
  private void testFields(Class c, Map<String,String> allFields) 
    throws SecurityException{          
    Field[] fields = c.getDeclaredFields();
    Assert.assertEquals(c.getName() + " should have " + allFields.size() + " declared fields", 
                        allFields.size(), fields.length);    
    for (Field f: fields){
      //System.out.println(f+ "\n");
      Assert.assertTrue(c.getName() + " should contain field: " + f.getType().getSimpleName() + " " + f.getName(),
                        allFields.containsKey(f.getName()) && 
                        allFields.get(f.getName()).equals(f.getType().getSimpleName()));      
      if(!f.getName().equals(f.getName().toUpperCase())){ //upper case fields are usually not private
        Assert.assertTrue( f.getName() + " should be private " , Modifier.isPrivate(f.getModifiers()));
      }
    }
  } 
  
  //Helper method to check if a given class contains the expected methods 
  private void testMethods(Class c, Map<String,String> allMethods) 
    throws SecurityException{          
    Method[] methods = c.getDeclaredMethods();
    int numberOfMethods = 0;
    for (Method m: methods){
      //System.out.println(m+ "\n");
      if (!m.isSynthetic()){
        numberOfMethods++;
        Assert.assertTrue(c.getName() + " should contain method: public " + m.getReturnType().getSimpleName() +" " + m.getName(), 
                          allMethods.containsKey(m.getName()) && 
                          allMethods.get(m.getName()).equals(m.getReturnType().getSimpleName()));
      }
    }
    Assert.assertEquals(c.getName() + " should have " + allMethods.size() + " declared methods", 
                        allMethods.size(), numberOfMethods);
  }   
}
