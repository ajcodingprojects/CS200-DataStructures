import mydatastructures.*;
import java.util.*;
import org.junit.*;

public  class MyListTest {
  
  private MyList<String> myList;
  
  @Before
  public void init() {
    myList = new MyArrayList<String>();
    myList.add("160");
    myList.add("200");
    myList.add("230");
    myList.add("310");
  }
  
  @Test
  public void testConstructor(){
    Assert.assertTrue("size of myList is 4", myList.size()==4);
    Assert.assertTrue("myList.get(0) is 160", myList.get(0).equals("160"));
    Assert.assertTrue("myList.get(1) is 200", myList.get(1).equals("200"));
    Assert.assertTrue("myList.get(2) is 230", myList.get(2).equals("230"));
    Assert.assertTrue("myList.get(3) is 310", myList.get(3).equals("310")); 
  }
  
  @Test  
  public void testAdd(){
    Assert.assertTrue(myList.add("239"));
    Assert.assertTrue("size of myList is 5", myList.size()==5);
    Assert.assertTrue("myList.get(0) is 160", myList.get(0).equals("160"));
    Assert.assertTrue("myList.get(1) is 200", myList.get(1).equals("200"));
    Assert.assertTrue("myList.get(2) is 230", myList.get(2).equals("230"));
    Assert.assertTrue("myList.get(3) is 310", myList.get(3).equals("310"));  
    Assert.assertTrue("myList.get(4) is 239", myList.get(4).equals("239"));    
  }
  
  @Test
  public void testAddBeyondCapacity(){
    Assert.assertTrue(myList.add("239"));
    Assert.assertTrue(myList.add("338"));    
    Assert.assertTrue("size of myList is 6", myList.size()==6);
    Assert.assertTrue(myList.add("339"));  
    Assert.assertTrue("size of myList is 7", myList.size() == 7);    
    Assert.assertTrue("myList.get(0) is 160", myList.get(0).equals("160"));
    Assert.assertTrue("myList.get(1) is 200", myList.get(1).equals("200"));
    Assert.assertTrue("myList.get(2) is 230", myList.get(2).equals("230"));
    Assert.assertTrue("myList.get(3) is 310", myList.get(3).equals("310"));  
    Assert.assertTrue("myList.get(4) is 239", myList.get(4).equals("239")); 
    Assert.assertTrue("myList.get(5) is 338", myList.get(5).equals("338")); 
    Assert.assertTrue("myList.get(6) is 339", myList.get(6).equals("339"));     
  }
  
  @Test  
  public void testSet(){
    for(int i = 0; i<myList.size();i++){
      String val = myList.get(i);
      Assert.assertTrue("get("+i+") should return "+val,myList.set(i,"CSCI-"+val).equals(val));
    }
    Assert.assertTrue("size of myList is 4", myList.size()==4);
    Assert.assertTrue("myList.get(0) is CSCI-160", myList.get(0).equals("CSCI-160"));
    Assert.assertTrue("myList.get(1) is CSCI-200", myList.get(1).equals("CSCI-200"));
    Assert.assertTrue("myList.get(2) is CSCI-230", myList.get(2).equals("CSCI-230"));
    Assert.assertTrue("myList.get(3) is CSCI-310", myList.get(3).equals("CSCI-310"));    
  }
  
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void testSetFailsForIndexEqualToSize(){
    myList.set(4,"CSCI-239");
  }
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void testSetFailsForIndexLargerThanSize(){
    myList.set(5,"CSCI-239");
  }
  
  @Test(expected=IndexOutOfBoundsException.class)  
  public void testSetFailsForNegativeIndex(){
    myList.set(-5,"CSCI-239");
  }  
  
  @Test    
  public void testRemoveFromStart(){
    Assert.assertTrue("remove(0) should return 160",myList.remove(0).equals("160"));
    Assert.assertTrue("size of myList is 3", myList.size()==3);
    Assert.assertTrue("myList.get(0) is 200", myList.get(0).equals("200"));
    Assert.assertTrue("myList.get(1) is 230", myList.get(1).equals("230"));
    Assert.assertTrue("myList.get(2) is 310", myList.get(2).equals("310")); 
  }
  
  @Test  
  public void testRemoveFromMiddle(){
    Assert.assertTrue("remove(1) should return 200",myList.remove(1).equals("200"));
    Assert.assertTrue("size of myList is 3", myList.size()==3);
    Assert.assertTrue("myList.get(0) is 160", myList.get(0).equals("160"));
    Assert.assertTrue("myList.get(1) is 230", myList.get(1).equals("230"));
    Assert.assertTrue("myList.get(2) is 310", myList.get(2).equals("310")); 
  }
  
  @Test  
  public void testRemoveFromEnd(){
    Assert.assertTrue("remove(3) should return 310",myList.remove(3).equals("310"));
    Assert.assertTrue("size of myList is 3", myList.size()==3);
    Assert.assertTrue("myList.get(0) is 160", myList.get(0).equals("160"));
    Assert.assertTrue("myList.get(1) is 200", myList.get(1).equals("200"));
    Assert.assertTrue("myList.get(2) is 230", myList.get(2).equals("230")); 
  }
  
  @Test  
  public void testRemoveToEmpty(){
    Assert.assertTrue("remove(3) should return 310",myList.remove(3).equals("310"));
    Assert.assertTrue("remove(2) should return 230",myList.remove(2).equals("230"));
    Assert.assertTrue("remove(1) should return 200",myList.remove(1).equals("200"));
    Assert.assertTrue("remove(0) should return 160",myList.remove(0).equals("160"));
    Assert.assertTrue("size of myList is 0", myList.size()==0);    
  }
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void testRemoveFailsForIndexEqualToSize(){
    myList.remove(4);
  }
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void testRemoveFailsForIndexLargerThanSize(){
    myList.remove(5);
  }
  
  @Test(expected=IndexOutOfBoundsException.class)  
  public void testRemoveFailsForNegativeIndex(){
    myList.remove(-1);
  }  
  
  @Test    
  public void testAddUsingIndexAtStart(){
    Assert.assertTrue(myList.add(0,"239"));
    Assert.assertTrue("size of myList is 5", myList.size()==5);
    Assert.assertTrue("myList.get(0) is 239", myList.get(0).equals("239"));       
    Assert.assertTrue("myList.get(1) is 160", myList.get(1).equals("160"));
    Assert.assertTrue("myList.get(2) is 200", myList.get(2).equals("200"));
    Assert.assertTrue("myList.get(3) is 230", myList.get(3).equals("230"));
    Assert.assertTrue("myList.get(4) is 310", myList.get(4).equals("310"));   
  }
  
  @Test  
  public void testAddUsingIndexAtMiddle(){
    Assert.assertTrue(myList.add(2,"239"));
    Assert.assertTrue("size of myList is 5", myList.size()==5);
    Assert.assertTrue("myList.get(0) is 160", myList.get(0).equals("160"));
    Assert.assertTrue("myList.get(1) is 200", myList.get(1).equals("200"));
    Assert.assertTrue("myList.get(2) is 239", myList.get(2).equals("239"));           
    Assert.assertTrue("myList.get(3) is 230", myList.get(3).equals("230"));
    Assert.assertTrue("myList.get(4) is 310", myList.get(4).equals("310"));  
  }
  
  @Test  
  public void testAddUsingIndexAtEnd(){
    Assert.assertTrue(myList.add(4,"239"));
    Assert.assertTrue("size of myList is 5", myList.size()==5);
    Assert.assertTrue("myList.get(0) is 160", myList.get(0).equals("160"));
    Assert.assertTrue("myList.get(1) is 200", myList.get(1).equals("200"));           
    Assert.assertTrue("myList.get(2) is 230", myList.get(2).equals("230"));
    Assert.assertTrue("myList.get(3) is 310", myList.get(3).equals("310"));  
    Assert.assertTrue("myList.get(4) is 239", myList.get(4).equals("239"));    
  }
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void testAddUsingIndexLargerThanSize(){
    myList.add(5,"xxx");
  }
  
  @Test(expected=IndexOutOfBoundsException.class)  
  public void testAddUsingNegativeIndex(){
    myList.add(-1,"xxx");
  }  
}