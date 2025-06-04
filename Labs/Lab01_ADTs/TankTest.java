/*
 * File: TankTest.java
 */

import tank.*;

import org.junit.*;

/**
 * A JUnit test case class for the DoubleTank class.
 * 
 * Every method preceded with an @Test annotation will be called when running
 * the test with JUnit. Methods preceded with an @Before annotation are re-executed 
 * before each test method is run
 */
public class TankTest {
  
  private Tank emptyTank,    // a tank initalized to be EMPTY
               fullTank,     // a tank initalized to be FULL
               notFullTank;  // a tank initalized to be neither EMPTY nor  FULL
   
  @Before
  public void init() {
    emptyTank = new DoubleTank();        // uses default constructor
    notFullTank = new DoubleTank(250.0);
    notFullTank.add(50.0);
    fullTank = new DoubleTank();
    fullTank.add(DoubleTank.DEFAULT_CAPACITY);
  }
  
  @After
  public void destroy() {
    emptyTank = null;
    notFullTank = null;
    fullTank = null;
  }
  
  @Test
  public void testDefaultConstructor() {
    Assert.assertTrue("emptyTank initially empty", emptyTank.isEmpty());
    Assert.assertTrue("emptyTank capacity is appropriate default", emptyTank.getCapacity()== 
                                                                   DoubleTank.DEFAULT_CAPACITY);
  }
  
  
  @Test
  public void testSecondConstructor(){
    Assert.assertTrue("notFullTank initially NOT empty", !notFullTank.isEmpty());
    Assert.assertTrue("notFullTank should have 50.0",notFullTank.getLevel()==50.0);
    Assert.assertTrue("notFullTank capacity is 250", notFullTank.getCapacity()== 250.0);  
  }
  
  
  @Test(expected = IllegalArgumentException.class)
  public void testAddFailsWhenExceedingCapacity() {
    notFullTank.add(251.0);
  }
  
  
  // Put additional test methods here. Each method name must be preceded with an @Test annotation
  @Test
  public void testAddToEmptyTank() {
    double amount = 50.0;
    emptyTank.add(amount);
    Assert.assertTrue("Testing if the level is properly added to amount for empty tank", emptyTank.getLevel() == amount);
  }
  
  @Test
  public void testAddToNonEmptyTank() {
    double  amount = 1.0;
    double previousLevel = notFullTank.getLevel();
    notFullTank.add(amount);
    Assert.assertTrue("Testing if the level is properly added to amount for non-empty tank", notFullTank.getLevel() == previousLevel + amount);
  }
  
 @Test
  public void testAddUpToCapacity() {
    double  amount = notFullTank.getCapacity() - notFullTank.getLevel();
    notFullTank.add(amount);
    Assert.assertTrue("Testing if the level is at capacity", notFullTank.getLevel() == notFullTank.getCapacity());
  }
 
  @Test (expected = IllegalArgumentException.class)
 public void tesAddFailsWhenExceedingCapacity() {
    System.out.println("Testing if an exception is thrown when adding too much fuel");
    notFullTank.add(100000000);
 } 
  
 @Test (expected = IllegalArgumentException.class)
 public void testAddFailsForNegativeValue() {
    System.out.println("Testing if an exception is thrown when adding a negative amount of fuel");
    notFullTank.add(-10);
  }
  
 @Test
  public void testRemoveFromANonEmptyTank() {
    double  amount = 1.0;
    double previousLevel = notFullTank.getLevel();
    notFullTank.remove(amount);
    Assert.assertTrue("Testing if the level is properly adjusted for removing fuel", notFullTank.getLevel() == previousLevel - amount);
  }
  
 @Test
  public void testRemoveToEmptyATank() {
    notFullTank.remove(notFullTank.getLevel());
    Assert.assertTrue("Testing if the level is empty", notFullTank.isEmpty());
  }
 
 @Test (expected = IllegalArgumentException.class)
 public void testRemoveFailsWhenExceedingLevel() {
    System.out.println("Testing if an exception is thrown when removing too much fuel");
    notFullTank.remove(100000000);
  }
 
 @Test (expected = IllegalArgumentException.class)
 public void testRemoveFailsForNegativeValue() {
    System.out.println("Testing if an exception is thrown when removing a negative amount of fuel");
    notFullTank.remove(-10);
  }
  
 
 @Test (expected = IllegalArgumentException.class)
 public void testSecondConstructorFailsForNegativeAmount() {
   System.out.println("Making sure an exception is throw when inputting a negative capacity number");
   new DoubleTank(-1000);
 }
 
}
