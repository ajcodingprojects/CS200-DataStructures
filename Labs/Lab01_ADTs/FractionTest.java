import org.junit.*;

// add another import to give the test class access to the fraction package
import fraction.*;

/**
 * A JUnit test case class for the IntFraction class.
 * 
 */
public class FractionTest {
  
  private Fraction frac1, frac2, frac3, frac4, frac5, frac6, frac7, frac8;
  
  @Before
  public void init() {
    //frac1 and frac2 are created using constructor 3
    frac1 = new IntFraction(5,7);
    frac2 = new IntFraction(1,2);
    //frac3 is created using constructor 1
    frac3 = new IntFraction();
    //frac4 is created using constructor 2
    frac4 = new IntFraction(5);
    
    
    //testing for IntFraction2 class
    //    Only Constructor 3 needs to be tested with new implementations since 
    frac5 = new IntFraction2(-4, -8);
    frac6 = new IntFraction2(-8, 16);
    frac7 = new IntFraction2(4, 2);
    frac8 = new IntFraction2(400, -62);
  }
  
  
  //1. Test method(s) for default constructor: test instance variable frac3 has the correct numerator  
  //    and denominator 
  @Test
  public void testDefaultConstructor(){
    Assert.assertTrue("Testing if numerator for default = 0", frac3.getNumerator() == 0);
    Assert.assertTrue("Testing if denominator for default = 1", frac3.getDenominator() == 1);
  }
  
  
  //2. Test method(s) for second constructor: test instance variable frac4 has the correct numerator 
  //    and denominator 
  @Test
  public void testSecondConstructor(){
    Assert.assertTrue("Testing if numerator for second constructor = number put in init", frac4.getNumerator() == 5);
    Assert.assertTrue("Testing if denominator for second constructor = 1", frac4.getDenominator() == 1);
  }
  
  
  //3. Test method(s) for third constructor: 
  //3(a). test instance variables frac1 and frac2 have the correct numerator and denominator 
  @Test
  public void testThirdConstructor(){
    Assert.assertTrue("Testing if numerator for third constructor = number put in init frac1", frac1.getNumerator() == 5);
    Assert.assertTrue("Testing if denominator for third constructor =  number put in init frac1", frac1.getDenominator() == 7);
    
    Assert.assertTrue("Testing if numerator for third constructor = number put in init frac2", frac2.getNumerator() == 1);
    Assert.assertTrue("Testing if denominator for third constructor =  number put in init frac2", frac2.getDenominator() == 2);
    
    Assert.assertTrue("Testing if gcd simplifies -n/-d into positive with smaller denominator", frac5.getNumerator() == 1 && frac5.getDenominator() == 2);
    Assert.assertTrue("Testing if gcd simplifies -n/d into negative with smaller denominator", frac6.getNumerator() == -1 && frac6.getDenominator() == 2);
    Assert.assertTrue("Testing if gcd simplifies n/d into positive with smaller denominator", frac7.getNumerator() == 2 && frac7.getDenominator() == 1);
    Assert.assertTrue("Testing if gcd simplifies n/-d into negative with smaller denominator", frac8.getNumerator() == 200 && frac8.getDenominator() == -31);
  }  
  
  //3(b). test contructor 3 fails to create a new fraction object if given a zero denominator
  @Test(expected = IllegalArgumentException.class)
  public void testThirdConstructorFailsForZeroDenominator(){
    System.out.print("Third constructor throws exception for the 0 denominator case");
    new IntFraction(6, 0);
  }
  
  
  //4. Test method(s) for addToThis: Complete method below to test method addToThis returns a 
  //    correct fraction result after adding operand fractions frac1 and frac2 AND that the  
  //    operand fractions (frac1 and frac2) do not change as a result of this operation
  @Test
  public void testAddToThis(){
    Fraction test = (IntFraction) frac1.addToThis(frac2);
    Fraction f1 = new IntFraction(frac1.getNumerator(), frac1.getDenominator());
    Fraction f2 = new IntFraction(frac2.getNumerator(), frac2.getDenominator());
    Fraction addedAmt = new IntFraction(17, 14);
    Assert.assertTrue("Testing if addition works correctly", test.equals(addedAmt));
    Assert.assertTrue("Making sure the frac1 and frac2 numerators and denominators didn't change", f1.equals(frac1) && f2.equals(frac2));
  }
  
  /**
   * Add the following test methods (create a separate, clearly-named test method for each case). 
   *    You may create additional Fraction objects as local variables in your test methods if need be
   *    (such as Fraction test in testAddToThis() above)
   * 
   * 
   * 5. test  method subtractFromThis returns a correct fraction result and that 
   * operand fractions do not change as a result of this operation
   * 
   * 
   * 6. test method multiplyThisBy returns a correct fraction result and that 
   * operand fractions do not change as a result of this operation
   * 
   * 
   * 7(a). test method divideThisBy returns a correct fraction result and that 
   * operand fractions do not change as a result of this operation
   * 
   * 7(b). test method divideThisBy fails if provided a zero fraction as a parameter 
   *
   * 
   * 8(a). test two fractions with the same numerators and denominators are equal 
   * 
   * 8(b). test two fractions may be unequal
   * 
   * 8(c). test  two fractions may still be equal even with the different numerators and denominators 
   *     - e.g. 1: 5/7 and 10/14 
   *     - e.g. 2: 1/2 and -5/-10
   * 
   */

  //5.
  @Test
  public void testSubtractFromThis(){
    Fraction test = (IntFraction) frac1.subtractFromThis(frac2);
    Fraction f1 = new IntFraction(frac1.getNumerator(), frac1.getDenominator());
    Fraction f2 = new IntFraction(frac2.getNumerator(), frac2.getDenominator());
    Fraction subtractedAmount = new IntFraction(3, 14);
    Assert.assertTrue("Testing if subtraction works correctly", test.equals(subtractedAmount));
    Assert.assertTrue("Making sure the frac1 and frac2 numerators and denominators didn't change", f1.equals(frac1) && f2.equals(frac2));
  }
  
  //6.
  @Test
  public void testMultiplyByThis(){
    Fraction test = (IntFraction) frac1.multiplyThisBy(frac2);
    Fraction f1 = new IntFraction(frac1.getNumerator(), frac1.getDenominator());
    Fraction f2 = new IntFraction(frac2.getNumerator(), frac2.getDenominator());
    Fraction multAmt = new IntFraction(5, 14);
    Assert.assertTrue("Testing if multiplication works correctly", test.equals(multAmt));
    Assert.assertTrue("Making sure the frac1 and frac2 numerators and denominators didn't change", f1.equals(frac1) && f2.equals(frac2));
  }
  
  //7a.
  @Test
  public void testDivideByThis(){
    Fraction test = (IntFraction) frac1.divideThisBy(frac2);
    Fraction f1 = new IntFraction(frac1.getNumerator(), frac1.getDenominator());
    Fraction f2 = new IntFraction(frac2.getNumerator(), frac2.getDenominator());
    Fraction divAmt = new IntFraction(10, 7);
    Assert.assertTrue("Testing if division works correctly", test.equals(divAmt));
    Assert.assertTrue("Making sure the frac1 and frac2 numerators and denominators didn't change", f1.equals(frac1) && f2.equals(frac2));
  }
  
  //7b.
  @Test (expected = ArithmeticException.class)
  public void testDivideByThisFailsForZeroDivisor() {
    Fraction test = (IntFraction) frac1.divideThisBy(frac3);
  }
  
  //8a.
  @Test
  public void testEqualsForSame() {
    int n = 20;
    int d = 30;
    Fraction f1 = new IntFraction(n, d);
    Fraction f2 = new IntFraction(n, d);
    Assert.assertTrue("Testing if fractions with same numerator and denominator are equal", f1.equals(f2));
  }
  
  //8b.
  @Test
  public void testNotEqualsForDifferent() {
    Fraction f1 = new IntFraction(10, 90);
    Fraction f2 = new IntFraction(4, 29);
    Assert.assertTrue("Testing if fractions without same numerator and denominator are not equal", !f1.equals(f2));
  }
  
  //8c.
  @Test
  public void testEqualsForDifferentNumAndDen() {
    Fraction f1 = new IntFraction(10, 90);
    Fraction f2 = new IntFraction(1, 9);
    Assert.assertTrue("Testing if fractions with different numerator and denominator are equal", f1.equals(f2));
  }
}