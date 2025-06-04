import org.junit.*;                // needed by JUnit4

import net.multitool.core.*;      // gain access to class being tested

/**
 * for JUnit testing of implementations of interface Account.java
 */

public class AccountTest{
  private Account acct1, acct2;
  
  // @Before annotation forces method to re-execute before each test method
  @Before
  public void init(){ 
    System.out.println("Setting up test objects using @Before..");
    acct1 = new AccountImplementation();
    acct2 = new AccountImplementation("Base", "Jon Bon", 15000);
  }
  
  // @After annotation forces method to re-execute after each test method
  @After
  public void destroy(){
    System.out.println("Tearing down test objects using @After...\n");
    acct1 = null;
    acct2 = null;
  }
  
  /**
   * Test that default construtor is successful at setting class fields properly
   */ 
  @Test
  public void testDefaultConstructor(){
    System.out.println("Running @Test method : testDefaultConstructor ...");
    Assert.assertTrue("Balance in acct1 is 0",acct1.getTotal()==0);
    //or using assertEquals  
    Assert.assertEquals("Balance in acct1 should be 0",0,acct1.getTotal());
    Assert.assertNull("Name of acct1 is should be null", acct1.getName());
    Assert.assertNull("Owner of acct1 is should be null",acct1.getOwner());
  }
  
  /**
   * Test that second construtor is successful at setting class fields properly
   */
  @Test
  public void testSecondConstructor(){
    System.out.println("Running @Test method : testSecondConstructor ...");    
    Assert.assertTrue("Balance in acct2 should be 15000",acct2.getTotal()==15000);
    Assert.assertTrue("Name of acct2 is should be 'Base'",acct2.getName().equals("Base"));
    Assert.assertTrue("Owner of acct2 is should be 'Jon Bon'",acct2.getOwner().equals("Jon Bon"));
  }
  
  /**
   *  Test that second construtor fails for a negative total
   */ 
  @Test(expected = IllegalArgumentException.class)
  public void testSecondConstructorFailsForNegativeTotal(){
    System.out.println("Running @Test method : testSecondConstructorFailsForNegativeTotal ...");   
    acct2 = new AccountImplementation("Base", "Jon Bon", -150000);
  } 
  
  /**
   * 1. COMPLETE ME *************************************************************************************************
   * Complete test method to test that method "credit" adds valid credit amounts to total balance properly
   */ 
  @Test
  public void testCreditValidAmount(){
    System.out.println("Running @Test method : testCreditValidAmount ...");    
    int amount = 70;
    acct1.credit(amount);
    Assert.assertTrue("Testing if credit method correctly added amount (total started at 0)", amount == acct1.getTotal());
  } 
  
  /**
   * 2. COMPLETE ME *************************************************************************************************
   * Complete a test method to test that method "credit" fails for negative credit amounts
   */    
  @Test(expected = IllegalArgumentException.class)
  public void testCreditNegativeAmountFails(){
    System.out.println("Running @Test method : testCreditNegativeAmountFails ...");        
    acct1.credit(-50);
  }
    
  /**
   * 3. COMPLETE ME *************************************************************************************************
   * Create a test method to test that method "debit" reduces total balance properly for valid withdrawls
   */     
  @Test
  public void testDebitHappyPath() {
       System.out.println("Running @Test method : testDebitHappyPath ...");  
       int amountToRemove = 50;
       int beforeTotal = acct2.getTotal() - amountToRemove;
       acct2.debit(amountToRemove);
       Assert.assertTrue("Testing if total amount is the same as original total minus the amountToRemove", beforeTotal == acct2.getTotal());
  }
  
  
  
  
  /**
   * 4. COMPLETE ME *************************************************************************************************
   * Create a test method to test that method "debit" fails for negative withdrawls
   */ 
  @Test (expected = IllegalArgumentException.class)
  public void testDebitFailsForNegativeAmt(){
       System.out.println("Running @Test method : testDebitFailsForNegativeAmt ..."); 
       acct2.debit(-134);
  }
  
  
  /**
   * 5. COMPLETE ME *************************************************************************************************
   * Create a test method to test that method "debit" fails for withdrawls that exceed total balance
   */ 
  @Test (expected = IllegalArgumentException.class)
  public void testDebitFailsForOverdraft(){
       System.out.println("Running @Test method : testDebitFailsForOverdraft ..."); 
       acct2.debit(100001);
  }
} // class AccountTest
