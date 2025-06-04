package net.multitool.core;

/**
 * A basic Account class for our budgeting example. 
 * It implements interface Account
 * 
 * @author Imad Rahal
 * @version August 30, 2022
 */
public class AccountImplementation implements Account{
  /**
   *  a name to identify this account
   */ 
  private String name;

  /**
   * the user assigned to this account
   */ 
  protected String owner; 
  /**
   * total amt allocated to this account in cents
   */ 
  int total; 
  
  /**
   * Default constructor: sets account name and owner to null 
   * and the total balance to 0
   */ 
  public AccountImplementation(){
    this.name = null;
    this.owner = null;
    this.total = 0;}

  /**
   * Another constructor which sets account name, owner and total to the three parameters
   * @param name The name of the account
   * @param owner The name of owner of the account
   * @param total The intitial balance of the account
   * @throws IllegalArgumentException if paramter total is negative 
   *   (meaning: Pre: Parameter total should not be negative)
   */
  public AccountImplementation(String name, String owner, int total){
    if (total<0)
      throw new IllegalArgumentException("Balance can't be negative");
    this.name = name;
    this.owner = owner;
    this.total = total;}
   
  /** 
   * {@inheritDoc}
   */
  public int getTotal(){
    return total;}
  
  /** 
   * {@inheritDoc}
   */
  public String getName(){
    return name;}
  
  /** 
   * {@inheritDoc}
   */
  public String getOwner(){
    return owner;}

  /** 
   * {@inheritDoc}
   */  public int credit(int amt){  
    if (amt<0)
      throw new IllegalArgumentException("Can't add a negative amount");
    total += amt;
    return total;
  }

  /** 
   * {@inheritDoc}
   */public void debit(int amt){
    if (amt>getTotal() || amt<0)
      throw new IllegalArgumentException("Balance not sufficient OR amt is negative");
    total -= amt;
  }
} 
