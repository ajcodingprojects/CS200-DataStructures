/*
 * Fraction.java
 */

package fraction;

/** 
 * Fraction is an interface for objects that represent rational numbers
 * as fractions
 * 
 * @author Andrew Nerud and Grant Peroutka
 * @version 9-7-2022
 */
public class IntFraction2 implements Fraction {
  /**
   * Numerator for fraction
   */
  private int numerator;
  
  /**
   * Denominator for fraction
   */
  private int denominator;
  
  /**
   * Default constructor that sets numerator to zero and denominator to one
   */
  public IntFraction2(){
    this.numerator = 0;
    this.denominator = 1;
    
  }
  
   /**
   * Default constructor that sets numerator to @param numerator and denominator to one
   * 
   * @param numerator an int value as a fractions numerator
   */
  public IntFraction2(int numerator){
    this.numerator = numerator;
    this.denominator = 1;
    
  }
  
  
   /**
   * Default constructor that sets numerator to @param numerator and denominator to @param denominator
   * 
   * @param numerator an int value as a fractions numerator
   * @param denominator an int value as a fractions denominator
   */
  public IntFraction2(int numerator, int denominator){
    if (denominator == 0) throw new IllegalArgumentException("Need a non-zero denominator");
    int  factor = gcd(numerator, denominator);
    this.numerator = numerator/factor;
    this.denominator = denominator/factor;
  }
  
  
   /**
   * {@inheritDoc}
   */
  public int getNumerator(){
    return numerator;
  
  }
  
   /**
   * {@inheritDoc}
   */
  public int getDenominator(){
   return denominator; 
    
  }
  
   /**
   * {@inheritDoc}
   */
  public Fraction addToThis(Fraction addend){
    if (this.getDenominator() == addend.getDenominator())
      return  new IntFraction(this.getNumerator() + addend.getNumerator(), this.getDenominator());
    int totalNumerator = this.getNumerator() * addend.getDenominator() + addend.getNumerator() * this.getDenominator();
    int totalDenominator = this.getDenominator() * addend.getDenominator();
    return  new IntFraction2(totalNumerator, totalDenominator);
    
  }
  
   /**
   * {@inheritDoc}
   */
  public Fraction subtractFromThis(Fraction subtrahend){
    if (this.getDenominator() == subtrahend.getDenominator())
      return  new IntFraction(this.getNumerator() - subtrahend.getNumerator(), this.getDenominator());
    int totalNumerator = this.getNumerator() * subtrahend.getDenominator() - subtrahend.getNumerator() * this.getDenominator();
    int totalDenominator = this.getDenominator() * subtrahend.getDenominator();
    return  new IntFraction2(totalNumerator, totalDenominator);
    
  }
  
  
 /**
   * {@inheritDoc}
   */
  public Fraction multiplyThisBy(Fraction multiplier){
    int totalNumerator = this.getNumerator() * multiplier.getNumerator();
    int totalDenominator = this.getDenominator() * multiplier.getDenominator();
    return  new IntFraction2(totalNumerator, totalDenominator);
  }
   /**
   * {@inheritDoc}
   */
    public Fraction divideThisBy(Fraction divisor){
      if (divisor.getNumerator() == 0)
        throw new ArithmeticException("Cannot divide with a zero fraction");
      int totalNumerator = this.getNumerator() * divisor.getDenominator();
      int totalDenominator = this.getDenominator() * divisor.getNumerator();
      return  new IntFraction2(totalNumerator, totalDenominator);
      
    }
  
   /**
   * {@inheritDoc}
   */
    public boolean equals(Object other){
      double thisVal = ((double)this.getNumerator())/this.getDenominator();
      try {
        Fraction otherFraction = (Fraction) other;
        double otherVal = ((double)otherFraction.getNumerator())/otherFraction.getDenominator();
        return thisVal == otherVal;
      } catch (ClassCastException cce) {
        return false;
      }
      
    }
  

    /**
     * Returns the greatest common factor for the numerator and denominator
     * 
     * @param numerator an int which is the numerator of the fraction
     * @param denominator an int which is the numerator of the fraction
     */
    private int gcd(int numerator, int denominator) {
      if (numerator == 0) return denominator;
      int large = Math.abs(numerator >= denominator ? numerator : denominator);
      int small = Math.abs(numerator >= denominator ? denominator : numerator);
      
      for (int i = small; i >= 1; i--) {
        if(large % i == 0 && small % i == 0) 
          return numerator < 0 && denominator < 0 ? -i : i;
      }
      return 1;
    }
   
  
}
