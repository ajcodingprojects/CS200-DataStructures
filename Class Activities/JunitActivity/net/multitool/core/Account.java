package net.multitool.core;

/**
 * A basic Account interface for our budgeting example. 
 * We will use this much to generate Javadocs
 * 
 * @author Imad Rahal
 * @version August 30, 2022
 */
public interface Account {
  
  /**
   * A getter method to access the name of the account
   * 
   * @return a String value representing the name of the account
   */ 
  public String getName();
  
  /**
   * A getter method to access the owner of the account
   * 
   * @return a String value representing owner of the account
   */ 
  public String getOwner();

  /**
   * A getter method to access the current total balance
   * 
   * @return a int value representing the total balance
   */ 
  public int getTotal();
  
  /**
   * Updates and returns the total balance as the old total plus parameter amt provided amt is positive
   * 
   * @param amt the amount to be added to the total balance
   * @return the total balance as the old total balance plus parameter amt
   * @throws IllegalArgumentException if paramter amt is negative
   */
  public int credit(int amt);

  /**
   * Updates and returns the total balance as the old total balance minus parameter provided amt is positive and
   * doesn't exceed total balance
   * 
   * @param amt the amount to be deducted from the total balance
   * @throws IllegalArgumentException if paramter amt is more than current total balance or negative
   */ 
  public void debit (int amt);
} 
