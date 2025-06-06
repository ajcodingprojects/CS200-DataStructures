import ajnstructures.*;
import org.junit.*;
import java.util.*;
import java.lang.reflect.*;
import java.lang.annotation.*;
import java.lang.invoke.*;
/**
 * A JUnit test case class for class <Foo>LinkedIndexedList  
 * 
 * @author Imad M Rahal
 * @version October 19, 2022
 */
public class IndexedListTest extends TestClassStats{
  
  private AJNIndexedList<Integer> notEmptyList, emptyList, withDuplicatesList;
  
  @Before
  public void init(){
    emptyList = new AJNLinkedIndexedList<Integer>();
    
    notEmptyList = new AJNLinkedIndexedList<Integer>();    
    notEmptyList.addElementAt(0,10);
    notEmptyList.addElementAt(1,20);
    notEmptyList.addElementAt(2,30);
    notEmptyList.addElementAt(3,40);
    notEmptyList.addElementAt(2,25);   
    
    withDuplicatesList  = new AJNLinkedIndexedList<Integer>();
    withDuplicatesList.addElementAt(0,10);
    withDuplicatesList.addElementAt(1,10);
    withDuplicatesList.addElementAt(2,30);
    withDuplicatesList.addElementAt(3,30);
    withDuplicatesList.addElementAt(4,50);       
    withDuplicatesList.addElementAt(5,50);       
  }
  
  //testing method isEmpty
  @Test 
  public void testIsEmptyReturnsFalse(){
    Assert.assertFalse("notEmptyList is not empty ",notEmptyList.isEmpty());
    Assert.assertFalse("withDuplicatesList is not empty ",withDuplicatesList.isEmpty());
    passed = true;    
  }
  
  @Test 
  public void testIsEmptyReturnsTrue(){
    Assert.assertTrue("emptyList is empty ",emptyList.isEmpty());
    passed = true;    
  } 
  
  
  //testing method size  
  @Test 
  public void testSize(){
    Assert.assertTrue("notEmptyList contains 5 elements ",notEmptyList.size()==5);
    Assert.assertTrue("withDuplicatesList contains 6 elements ",withDuplicatesList.size()==6);
    Assert.assertTrue("emptyList contains 0 elements ",emptyList.size()==0);     
    passed = true;    
  }
  
  
  //testing method get    
  @Test 
  public void testGetFromStart(){
    Assert.assertTrue("notEmptyList contains element 10 at location 0",(int) notEmptyList.get(0)==10);
    Assert.assertTrue("withDuplicatesList contains element 10 at location 0",(int) withDuplicatesList.get(0)==10);
    passed = true;    
  }
  
  @Test 
  public void testGetFromEnd(){
    Assert.assertTrue("notEmptyList contains element 40 at location 4",(int) notEmptyList.get(4)==40);
    Assert.assertTrue("withDuplicatesList contains element 50 at location 5",(int) withDuplicatesList.get(5)==50);  
    passed = true;    
  }
  
  @Test 
  public void testGetFromTheMiddle(){
    Assert.assertTrue("notEmptyList contains element 20 at location 1",(int) notEmptyList.get(1)==20);
    Assert.assertTrue("notEmptyList contains element 25 at location 2",(int) notEmptyList.get(2)==25);    
    Assert.assertTrue("notEmptyList contains element 30 at location 3",(int) notEmptyList.get(3)==30);
    Assert.assertTrue("withDuplicatesList contains element 10 at location 1",(int) withDuplicatesList.get(1)==10);    
    Assert.assertTrue("withDuplicatesList contains element 30 at location 2",(int) withDuplicatesList.get(2)==30);
    Assert.assertTrue("withDuplicatesList contains element 30 at location 3",(int) withDuplicatesList.get(3)==30);
    Assert.assertTrue("withDuplicatesList contains element 50 at location 4",(int) withDuplicatesList.get(4)==50);
    passed = true;    
  }  
  
  @Test //(expected=IndexOutOfBoundsException.class)
  public void testGetFailsForIndexEqualToSize(){
    try{
      emptyList.get(0);
      passed = false;
      Assert.fail("testGetFailsForIndexEqualToSize should have failed");
    }
    catch (IndexOutOfBoundsException e){
      passed = true;
    }        
    
  }
  
  @Test //(expected=IndexOutOfBoundsException.class)
  public void testGetFailsForIndexLargerThanSize(){
    try{
      notEmptyList.get(6);
      passed = false;
      Assert.fail("testGetFailsForIndexLargerThanSize should have failed");
    }
    catch (IndexOutOfBoundsException e){
      passed = true;
    }        
  }
  
  @Test //(expected=IndexOutOfBoundsException.class)
  public void testGetFailsForNegativeIndex(){
    try{
      notEmptyList.get(-1);
      passed = false;
      Assert.fail("testGetFailsForNegativeIndexgativeIndex should have failed");
    }
    catch (IndexOutOfBoundsException e){
      passed = true;
    }       
  }
  
  //testing method addElementAt    
  @Test
  public void testAddElementAtStart(){
    notEmptyList.addElementAt(0,10);
    Assert.assertTrue("notEmptyList contains element 10 at location 0",(int) notEmptyList.get(0)==10);
    Assert.assertTrue("notEmptyList contains element 10 at location 1",(int) notEmptyList.get(1)==10);
    Assert.assertTrue("notEmptyList contains element 20 at location 2",(int) notEmptyList.get(2)==20);    
    Assert.assertTrue("notEmptyList contains element 25 at location 3",(int) notEmptyList.get(3)==25);
    Assert.assertTrue("notEmptyList contains element 30 at location 4",(int) notEmptyList.get(4)==30);
    Assert.assertTrue("notEmptyList contains element 40 at location 5",(int) notEmptyList.get(5)==40);
    Assert.assertTrue("Size of notEmptyList is now 6",withDuplicatesList.size()==6);   
    passed = true;    
  }
  
  @Test
  public void testAddElementAtEnd(){
    notEmptyList.addElementAt(5,10);
    Assert.assertTrue("notEmptyList contains element 10 at location 0",(int) notEmptyList.get(0)==10);
    Assert.assertTrue("notEmptyList contains element 20 at location 1",(int) notEmptyList.get(1)==20);    
    Assert.assertTrue("notEmptyList contains element 25 at location 2",(int) notEmptyList.get(2)==25);
    Assert.assertTrue("notEmptyList contains element 30 at location 3",(int) notEmptyList.get(3)==30);
    Assert.assertTrue("notEmptyList contains element 40 at location 4",(int) notEmptyList.get(4)==40);
    Assert.assertTrue("notEmptyList contains element 10 at location 5",(int) notEmptyList.get(5)==10);
    Assert.assertTrue("Size of notEmptyList is now 6",notEmptyList.size()==6);   
    passed = true;    
  }
  
  @Test
  public void testAddElementAtInTheMiddle(){
    notEmptyList.addElementAt(3,10);
    Assert.assertTrue("notEmptyList contains element 10 at location 0",(int) notEmptyList.get(0)==10);
    Assert.assertTrue("notEmptyList contains element 20 at location 1",(int) notEmptyList.get(1)==20);    
    Assert.assertTrue("notEmptyList contains element 25 at location 2",(int) notEmptyList.get(2)==25);
    Assert.assertTrue("notEmptyList contains element 10 at location 3",(int) notEmptyList.get(3)==10);
    Assert.assertTrue("notEmptyList contains element 30 at location 4",(int) notEmptyList.get(4)==30);
    Assert.assertTrue("notEmptyList contains element 40 at location 5",(int) notEmptyList.get(5)==40);
    Assert.assertTrue("Size of notEmptyList is now 6",notEmptyList.size()==6);    
    passed = true;    
  }
  
  @Test //(expected=IndexOutOfBoundsException.class)
  public void testAddElementAtFailsForIndexLargerThanSize(){
    try{
      emptyList.addElementAt(1,50);
      passed = false;
      Assert.fail("testAddElementAtFailsForIndexLargerThanSize should have failed");
    }
    catch (IndexOutOfBoundsException e){
      passed = true;
    }    
  }
  
  @Test //(expected=IndexOutOfBoundsException.class)
  public void testAddElementAtFailsForNegativeIndex(){
    try{
      notEmptyList.addElementAt(-1,50);
      passed = false;
      Assert.fail("testAddElementAtFailsForNegativeIndex should have failed");
    }
    catch (IndexOutOfBoundsException e){
      passed = true;
    }      
  }
  
//testing method contains  
  @Test 
  public void testContainsReturnsFalse(){
    Assert.assertFalse("notEmptyList does not contain element 50 ",notEmptyList.contains(50));
    Assert.assertFalse("withDuplicatesList does not contain element 60 ",withDuplicatesList.contains(60));
    Assert.assertFalse("emptyList does not contain element 10 ",emptyList.contains(10));
    passed = true;    
  } 
  
  @Test 
  public void testContainsAtStart(){
    Assert.assertTrue("notEmptyList contains element 10 ",notEmptyList.contains(10));
    Assert.assertTrue("withDuplicatesList contains element 10 ",withDuplicatesList.contains(10));    
    passed = true;    
  }
  
  @Test 
  public void testContainsAtEnd(){
    Assert.assertTrue("notEmptyList contains element 40 ",notEmptyList.contains(40));
    Assert.assertTrue("withDuplicatesList contains element 50 ",withDuplicatesList.contains(50));  
    passed = true;    
  }  
  
  @Test 
  public void testContainsInTheMiddle(){
    Assert.assertTrue("notEmptyList contains element 20 ",notEmptyList.contains(20));
    Assert.assertTrue("notEmptyList contains element 25 ",notEmptyList.contains(25));
    Assert.assertTrue("notEmptyList contains element 30 ",notEmptyList.contains(30));;
    Assert.assertTrue("withDuplicatesList contains element 30 ",withDuplicatesList.contains(30));
    passed = true;    
  }
  
  //testing method iterator  
  @Test
  public void testIteratorForEmptyLists(){
    int i = 0;
    for (Integer element : emptyList) {
      Assert.assertTrue("emptyList contains element " + element, emptyList.contains(element));
      i++;
    }
    Assert.assertTrue("emptyList contains the same number of elements in iterator ",emptyList.size()==i);    
    passed = true;
  }  
  
  @Test
  public void testIteratorForNonEmptyLists(){
    int i = 0;
    for (Integer element : notEmptyList) {
      Assert.assertTrue("notEmptyList contains element " + element, notEmptyList.contains(element));
      i++;
    }
    Assert.assertTrue("notEmptyList contains the same number of elements in iterator ",notEmptyList.size()==i);
    i = 0;
    for (Integer element : withDuplicatesList) {
      Assert.assertTrue("withDuplicatesList contains element " + element, withDuplicatesList.contains(element));
      i++;
    }
    Assert.assertTrue("withDuplicatesList contains the same number of elements in iterator ",withDuplicatesList.size()==i);    
    passed = true;    
  }
  
  //testing method set  
  @Test
  public void testSetAtStart(){
    Assert.assertTrue("notEmptyList contains old element 10 at location 0",(int) notEmptyList.set(0,100)==10);
    Assert.assertTrue("notEmptyList contains new element 100 at location 0",(int) notEmptyList.get(0)==100);
    
    Assert.assertTrue("withDuplicatesList contains old element 10 at location 0",(int) withDuplicatesList.set(0,100)==10);
    Assert.assertTrue("withDuplicatesList contains new element 100 at location 0",(int) withDuplicatesList.get(0)==100);    
    passed = true;
  }
  
  @Test
  public void testSetAtEnd(){
    Assert.assertTrue("notEmptyList contains old element 40 at location 4",(int) notEmptyList.set(4,400)==40);
    Assert.assertTrue("notEmptyList contains new element 400 at location 4",(int) notEmptyList.get(4)==400);
    
    Assert.assertTrue("withDuplicatesList contains old element 50 at location 5",(int) withDuplicatesList.set(5,500)==50);
    Assert.assertTrue("withDuplicatesList contains new element 500 at location 5",(int) withDuplicatesList.get(5)==500);     
    passed = true;    
  }
  
  @Test
  public void testSetInTheMiddel(){
    Assert.assertTrue("withDuplicatesList contains old element 10 at location 1",(int) withDuplicatesList.set(1,100)==10);
    Assert.assertTrue("withDuplicatesList contains new element 100 at location 1",(int) withDuplicatesList.get(1)==100);
    Assert.assertTrue("withDuplicatesList contains old element 30 at location 3",(int) withDuplicatesList.set(3,300)==30);
    Assert.assertTrue("withDuplicatesList contains new element 300 at location 3",(int) withDuplicatesList.get(3)==300);
    passed = true;    
  }
  
  @Test //(expected=IndexOutOfBoundsException.class)
  public void testSetFailsForIndexEqualToSize(){    
    try{
      emptyList.set(0,400);
      passed = false;
      Assert.fail("testSetFailsForIndexEqualToSize should have failed");
    }
    catch (IndexOutOfBoundsException e){
      passed = true;
    }        
  }
  
  @Test //(expected=IndexOutOfBoundsException.class)
  public void testSetFailsForIndexLargerThanSize(){
    try{
      notEmptyList.set(6,400);
      passed = false;
      Assert.fail("testSetFailsForIndexLargerThanSize should have failed");
    }
    catch (IndexOutOfBoundsException e){
      passed = true;
    }      
  }
  
  @Test //(expected=IndexOutOfBoundsException.class)
  public void testSetFailsForNegativeIndex(){
    try{
      notEmptyList.set(-1,400);
      passed = false;
      Assert.fail("testSetFailsForNegativeIndex should have failed");
    }
    catch (IndexOutOfBoundsException e){
      passed = true;
    }        
  }  
  
  //testing method indexOf   
  @Test
  public void testIndexOfReturnsNegativeOne(){
    Assert.assertTrue("notEmptyList does not contain element 50 ", notEmptyList.indexOf(50)==-1); 
    Assert.assertTrue("withDuplicatesList does not contain element 60 ", withDuplicatesList.indexOf(60)==-1);  
    Assert.assertTrue("emptyList does not contain element 50 ", emptyList.indexOf(50)==-1); 
    passed = true;    
  }
  
  
  @Test
  public void testIndexOfForListsWithNoDuplicates(){
    Assert.assertTrue("first location for value 10 in notEmptyList is 0 ", notEmptyList.indexOf(10)==0);
    Assert.assertTrue("first location for value 20 in notEmptyList is 1 ", notEmptyList.indexOf(20)==1);
    Assert.assertTrue("first location for value 25 in notEmptyList is 2 ", notEmptyList.indexOf(25)==2);
    Assert.assertTrue("first location for value 30 in notEmptyList is 3 ", notEmptyList.indexOf(30)==3);
    Assert.assertTrue("first location for value 40 in notEmptyList is 4 ", notEmptyList.indexOf(40)==4);
    passed = true;
  }
  
  @Test
  public void testIndexOfForListsWithDuplicates(){
    Assert.assertTrue("first location for value 10 in withDuplicatesList is 0 ", withDuplicatesList.indexOf(10)==0);
    Assert.assertTrue("first location for value 30 in withDuplicatesList is 2 ", withDuplicatesList.indexOf(30)==2);
    Assert.assertTrue("first location for value 50 in withDuplicatesList is 4", withDuplicatesList.indexOf(50)==4); 
    passed = true;    
  }
  
  //testing method lastIndexOf
  @Test 
  public void testLastIndexOfReturnsNegativeOne(){;
    Assert.assertTrue("Last location for value 50 in notEmptyList is -1", notEmptyList.lastIndexOf(50)==-1);
    Assert.assertTrue("Last location for value 60 in withDuplicatesList is -1", withDuplicatesList.lastIndexOf(60)==-1);
    Assert.assertTrue("Last location for value 50 in emptyList is -1", emptyList.lastIndexOf(50)==-1);
    passed = true;    
  }
  
  @Test 
  public void testLastIndexOfForListsWithNoDuplicates(){
    Assert.assertTrue("Last location for value 10 in notEmptyList is 0 ", notEmptyList.lastIndexOf(10)==0);
    Assert.assertTrue("Last location for value 20 in notEmptyList is 1 ", notEmptyList.lastIndexOf(20)==1);
    Assert.assertTrue("Last location for value 25 in notEmptyList is 2 ", notEmptyList.lastIndexOf(25)==2);
    Assert.assertTrue("Last location for value 30 in notEmptyList is 3 ", notEmptyList.lastIndexOf(30)==3);
    Assert.assertTrue("Last location for value 40 in notEmptyList is 4 ", notEmptyList.lastIndexOf(40)==4);    
    passed = true;    
  }  
  
  @Test 
  public void testLastIndexOfForListsWithDuplicates(){
    Assert.assertTrue("Last location for value 10 in withDuplicatesList is 1 ", withDuplicatesList.lastIndexOf(10)==1);
    Assert.assertTrue("Last location for value 30 in withDuplicatesList is 3 ", withDuplicatesList.lastIndexOf(30)==3);
    Assert.assertTrue("Last location for value 50 in withDuplicatesList is 5", withDuplicatesList.lastIndexOf(50)==5);
    passed = true;    
  }  
  
  //testing method removeElementAt 
  @Test
  public void  testRemoveElementAtStart(){
    Assert.assertTrue("withDuplicatesList contains element 10 at location 0 ", withDuplicatesList.indexOf(10)==0);
    Assert.assertTrue("withDuplicatesList contains element 30 at location 2 ", withDuplicatesList.indexOf(30)==2);
    Assert.assertTrue("withDuplicatesList contains element 50 at location 4 ", withDuplicatesList.indexOf(50)==4);
    Assert.assertTrue("Size of withDuplicatesList is originally 6",withDuplicatesList.size()==6);
    
    Assert.assertTrue("Removing element at location 0",(int) withDuplicatesList.removeElementAt(0)==10);
    Assert.assertTrue("withDuplicatesList contains element 10 at location 0 ", withDuplicatesList.indexOf(10)==0);
    Assert.assertTrue("withDuplicatesList contains element 30 at location 1 ", withDuplicatesList.indexOf(30)==1);
    Assert.assertTrue("withDuplicatesList contains element 50 at location 3 ", withDuplicatesList.indexOf(50)==3);
    Assert.assertTrue("Size of withDuplicatesList is now 5",withDuplicatesList.size()==5);
    
    Assert.assertTrue("Removing element at location 0",(int) withDuplicatesList.removeElementAt(0)==10);
    Assert.assertTrue("withDuplicatesList does not contain element 10  ", withDuplicatesList.indexOf(10)==-1);
    Assert.assertTrue("withDuplicatesList contains element 30 at location 0 ", withDuplicatesList.indexOf(30)==0);
    Assert.assertTrue("withDuplicatesList contains element 50 at location 2 ", withDuplicatesList.indexOf(50)==2);
    Assert.assertTrue("Size of withDuplicatesList is now 4",withDuplicatesList.size()==4);    
    passed = true;    
  }
  
  @Test
  public void  testRemoveElementAtEnd(){
    Assert.assertTrue("withDuplicatesList contains element 10 at location 0 ", withDuplicatesList.indexOf(10)==0);
    Assert.assertTrue("withDuplicatesList contains element 30 at location 2 ", withDuplicatesList.indexOf(30)==2);
    Assert.assertTrue("withDuplicatesList contains element 50 at location 4 ", withDuplicatesList.indexOf(50)==4);
    Assert.assertTrue("Size of withDuplicatesList is originally 6",withDuplicatesList.size()==6);
    
    Assert.assertTrue("Removing element at location 5",(int) withDuplicatesList.removeElementAt(5)==50);
    Assert.assertTrue("withDuplicatesList contains element 10 at location 0 ", withDuplicatesList.indexOf(10)==0);
    Assert.assertTrue("withDuplicatesList contains element 30 at location 2 ", withDuplicatesList.indexOf(30)==2);
    Assert.assertTrue("withDuplicatesList contains element 50 at location 4 ", withDuplicatesList.indexOf(50)==4);
    Assert.assertTrue("Size of withDuplicatesList is now 5",withDuplicatesList.size()==5);
    
    Assert.assertTrue("Removing element at location 4",(int) withDuplicatesList.removeElementAt(4)==50);
    Assert.assertTrue("withDuplicatesList contains element 10 at location 0 ", withDuplicatesList.indexOf(10)==0);
    Assert.assertTrue("withDuplicatesList contains element 30 at location 2 ", withDuplicatesList.indexOf(30)==2);
    Assert.assertTrue("withDuplicatesList does not contain element 50 ", withDuplicatesList.indexOf(50)==-1);
    Assert.assertTrue("Size of withDuplicatesList is now 4",withDuplicatesList.size()==4);   
    passed = true;    
  }
  
  @Test
  public void  testRemoveElementAtInTheMiddle(){
    Assert.assertTrue("notEmptyList contains element 10 at location 0 ", notEmptyList.indexOf(10)==0);
    Assert.assertTrue("notEmptyList contains element 20 at location 1 ", notEmptyList.indexOf(20)==1);
    Assert.assertTrue("notEmptyList contains element 25 at location 2 ", notEmptyList.indexOf(25)==2);
    Assert.assertTrue("notEmptyList contains element 30 at location 3 ", notEmptyList.indexOf(30)==3);
    Assert.assertTrue("notEmptyList contains element 40 at location 4 ", notEmptyList.indexOf(40)==4);
    Assert.assertTrue("Size of notEmptyList is originally 5",notEmptyList.size()==5);
    
    Assert.assertTrue("Removing element at location 2",(int) notEmptyList.removeElementAt(2)==25);
    Assert.assertTrue("notEmptyList contains element 10 at location 0 ", notEmptyList.indexOf(10)==0);
    Assert.assertTrue("notEmptyList contains element 20 at location 1 ", notEmptyList.indexOf(20)==1);
    Assert.assertTrue("notEmptyList does not contain element 25 ... returns -1 ", notEmptyList.indexOf(25)==-1);
    Assert.assertTrue("notEmptyList contains element 30 at location 2 ", notEmptyList.indexOf(30)==2);
    Assert.assertTrue("notEmptyList contains element 40 at location 3 ", notEmptyList.indexOf(40)==3);
    Assert.assertTrue("Size of notEmptyList is now 4",notEmptyList.size()==4);
    
    Assert.assertTrue("Removing element at location 1",(int) notEmptyList.removeElementAt(1)==20);
    Assert.assertTrue("notEmptyList contains element 10 at location 0 ", notEmptyList.indexOf(10)==0);
    Assert.assertTrue("notEmptyList does not contain element 20 ... returns -1 ", notEmptyList.indexOf(20)==-1);
    Assert.assertTrue("notEmptyList does not contain element 25 ... returns -1 ", notEmptyList.indexOf(25)==-1);
    Assert.assertTrue("notEmptyList contains element 30 at location 1 ", notEmptyList.indexOf(30)==1);
    Assert.assertTrue("notEmptyList contains element 40 at location 2 ", notEmptyList.indexOf(40)==2);
    Assert.assertTrue("Size of notEmptyList is now 1",notEmptyList.size()==3);
    passed = true;    
  }
  
  @Test//(expected=IndexOutOfBoundsException.class)
  public void  testRemoveElementAtFailsForIndexLargerThanSize(){
    try{
      emptyList.removeElementAt(6);
      passed = false;
      Assert.fail("testRemoveElementAtFailsForIndexLargerThanSize should have failed");
    }
    catch (IndexOutOfBoundsException e){
      passed = true;
    }        
    
  }
  
  @Test //(expected=IndexOutOfBoundsException.class)
  public void  testRemoveElementAtFailsForIndexEqualToSize(){
    try{
      emptyList.removeElementAt(0);
      passed = false;
      Assert.fail("testRemoveElementAtFailsForIndexEqualToSize should have failed");
    }
    catch (IndexOutOfBoundsException e){
      passed = true;
    }    
  }                                                    
  
  @Test //(expected=IndexOutOfBoundsException.class)
  public void  testRemoveElementAtFailsForNegativeIndex(){
    try{
      notEmptyList.removeElementAt(-1);
      passed = false;
      Assert.fail("testRemoveElementAtFailsForNegativeIndex should have failed");
    }
    catch (IndexOutOfBoundsException e){
      passed = true;
    }
  }                                                    
  
  
  //testing method subList
  @Test 
  public void testSubListFromStart(){
    emptyList = notEmptyList.subList(0,3);
    Assert.assertTrue("emptyList contains element 10 at location 0 ", emptyList.indexOf(10)==0);
    Assert.assertTrue("emptyList contains element 20 at location 1 ", emptyList.indexOf(20)==1);
    Assert.assertTrue("emptyList contains element 25 at location 2 ", emptyList.indexOf(25)==2);
    Assert.assertTrue("emptyList contains element 30 at location 3 ", emptyList.indexOf(30)==3);
    Assert.assertTrue("emptyList does not contain element 40 ", emptyList.indexOf(40)==-1);  
    passed = true;    
  }
  
  @Test 
  public void testSubListToEnd(){    
    emptyList = notEmptyList.subList(1,4);
    Assert.assertTrue("emptyList contains element 20 at location 0 ", emptyList.indexOf(20)==0);
    Assert.assertTrue("emptyList contains element 25 at location 1 ", emptyList.indexOf(25)==1);
    Assert.assertTrue("emptyList contains element 30 at location 2 ", emptyList.indexOf(30)==2);
    Assert.assertTrue("emptyList contains element 40 at location 3 ", emptyList.indexOf(40)==3);    
    Assert.assertTrue("emptyList does not contain element 10 ", emptyList.indexOf(10)==-1);  
    passed = true;    
  }
  
  @Test 
  public void testSubListInTheMiddle(){    
    emptyList = notEmptyList.subList(1,2);    
    Assert.assertTrue("emptyList contains element 20 at location 0 ", emptyList.indexOf(20)==0);
    Assert.assertTrue("emptyList contains element 25 at location 1 ", emptyList.indexOf(25)==1);
    Assert.assertTrue("emptyList does not contain element 30 ", emptyList.indexOf(30)==-1);
    Assert.assertTrue("emptyList does not contain element 40 ", emptyList.indexOf(40)==-1);    
    Assert.assertTrue("emptyList does not contain element 10 ", emptyList.indexOf(10)==-1); 
    passed = true;    
  }
  
  @Test 
  public void testSubListToForAllElements(){   
    emptyList = notEmptyList.subList(0,4);
    Assert.assertTrue("notEmptyList contains element 10 at location 0 ", emptyList.indexOf(10)==0);
    Assert.assertTrue("notEmptyList contains element 20 at location 1 ", emptyList.indexOf(20)==1);
    Assert.assertTrue("notEmptyList contains element 25 at location 2 ", emptyList.indexOf(25)==2);
    Assert.assertTrue("notEmptyList contains element 30 at location 3 ", emptyList.indexOf(30)==3);
    Assert.assertTrue("notEmptyList contains element 40 at location 4 ", emptyList.indexOf(40)==4);
    Assert.assertTrue("notEmptyList does not contain element 50 ", notEmptyList.indexOf(50)==-1); 
    passed = true;    
  }
  
  @Test //(expected=IndexOutOfBoundsException.class) 
  public void testSubListFailsForNegativeIndex(){       
    try{
      notEmptyList.subList(-1,3);
      passed = false;
      Assert.fail("testSubListFailsForNegativeIndex should have failed");
    }
    catch (IndexOutOfBoundsException e){
      passed = true;
    }         
  }
  
  @Test //(expected=IndexOutOfBoundsException.class) 
  public void testSubListFailsForIndexLargerThanSize(){         
    try{
      notEmptyList.subList(1,6);
      passed = false;
      Assert.fail("testSubListFailsForIndexLargerThanSize should have failed");
    }
    catch (IndexOutOfBoundsException e){
      passed = true;
    }     
  }  
  
  @Test //(expected=IndexOutOfBoundsException.class) 
  public void testSubListFailsForIndexEqualToSize(){             
    try{
      notEmptyList.subList(1,5);
      passed = false;
      Assert.fail("testSubListFailsForIndexEqualToSize should have failed");
    }
    catch (IndexOutOfBoundsException e){
      passed = true;
    }       
  }    
  
  @Test //(expected=IndexOutOfBoundsException.class) 
  public void testSubListFailsForFromIndexLargerThanToIndex(){ 
    try{
      notEmptyList.subList(3,2); 
      passed = false;
      Assert.fail("testSubListFailsForFromIndexLargerThanToIndex should have failed");
    }
    catch (IndexOutOfBoundsException e){
      passed = true;
    }      
    
  }    
  
  //testing method containsDuplicates
  @Test 
  public void testContainsDuplicatesReturnsTrue(){     
    Assert.assertTrue("withDuplicatesList contains duplicates",withDuplicatesList.containsDuplicates()); 
    passed = true;    
  }  
  
  @Test 
  public void testContainsDuplicatesReturnsFalse(){
    Assert.assertFalse("notEmptyList contains no duplicates",notEmptyList.containsDuplicates()); 
    Assert.assertFalse("emptyList contains no duplicates",notEmptyList.containsDuplicates());        
    passed = true;    
  } 
  
  
  @Test
  public void testOuterClassStructure() throws SecurityException, NoSuchMethodException{
    Class fas = notEmptyList.getClass();
    Class fs0 = fas.getInterfaces()[0]; // List ADT interface
    
    Assert.assertTrue(fas.getSimpleName() + " is a class that implements ajnstructures.AJNIndexedList " ,  
                      !fas.isInterface() &&
                      !Modifier.isAbstract(fas.getModifiers()));
    
    Assert.assertTrue(fs0.getSimpleName() + " should reside inside your structures package ",
                      fas.getPackage().getName().equals(fs0.getPackage().getName()));    
    
    Map<String,String>  allFields = new HashMap<String,String>(){
      {
        put("size", "int");
        put("head", "ListNode");
      }
    };
    testFields(fas,allFields, true);  
    
    Map<String,String>  allMethods = new HashMap<String,String>() {
      {
        put("isEmpty", "boolean");
        put("contains", "boolean");
        put("iterator","Iterator");
        put("size","int");
        put("get","Object");
        put("set","Object");
        put("addElementAt","void");
        put("removeElementAt","Object");      
        put("indexOf","int");  
        put("lastIndexOf","int");  
        put("subList",fs0.getSimpleName());         
        put("containsDuplicates","boolean"); 
      }      
    }; 
    testMethods(fas,allMethods, false); 
    
    Constructor[] constructors  = fas.getDeclaredConstructors();
    Assert.assertEquals(fas.getName() + " should have at least 1 constructor", 1, constructors.length);
    
    for (Constructor con: constructors){
      String paramList = "";
      for(Class cl: con.getParameterTypes()){
        paramList += cl.getSimpleName();
      }
      Assert.assertTrue(fas.getName() + " should contain constructor: public " + con.getName() + " with 0 paramaters " , paramList.equals(""));  
    }
    passed = true;    
  }
  
  @Test  
  public void testInnerClassStructure()  throws SecurityException, NoSuchMethodException{
    Class fas = notEmptyList.getClass();
    Class fs0 = fas.getInterfaces()[0]; // List ADT interface    
    Class inner = fas.getDeclaredClasses()[0];
    Class innerSuper = inner.getSuperclass(); 
    
    Assert.assertTrue(inner.getSimpleName() + " is a private inner class that extends ZHOneWayListNode<ElementType, StackNode> " ,  
                      !inner.isInterface() &&
                      Modifier.isPrivate(inner.getModifiers()) &&
                      innerSuper.getSimpleName().equals("ZHOneWayListNode"));
    
    Field[] fields = inner.getDeclaredFields();
    int numberOfFields = 0;
    for(Field f : fields){
      if (!f.isSynthetic()){
        numberOfFields++;
      }  
    }
    Assert.assertEquals(inner.getName() + " should contain NO declated fields", 0 ,  numberOfFields);
    
    Map<String,String> allMethods = new HashMap<String,String>() {
      { 
        put("get","Object");
        put("set","Object");
        put("addElementAt","void");
        put("removeElementAt","Object");      
        put("indexOf","int");  
        put("lastIndexOf","int");  
      }      
    }; 
    testMethods(inner,allMethods, true); 
    
    Constructor[] constructors  = inner.getDeclaredConstructors();
    Map<Integer, String> allConstructors = new HashMap<Integer, String>() {
      {
        put(0, "");
        put(2, "ObjectListNode");
      }      
    };   
    int numberOfConstructors = 0;
    int numberOfParams = 0;
    String paramList = "";  
    
    for (Constructor con: constructors){
      if(!con.isSynthetic()){
        for(Class p: con.getParameterTypes()){
          if (!p.getSimpleName().equals(fas.getSimpleName())){ //for inner classes , the formal parameter types include the explicit enclosing instance as the first parameter.
            numberOfParams++;
            paramList += p.getSimpleName();
          }
        }
        Assert.assertEquals(inner.getName() + " should contain constructor: protected ListNode with " + numberOfParams + " paramater(s)" , 
                            allConstructors.get(numberOfParams), paramList);        
        paramList = "";
        numberOfParams=0;
      }
    }
    Assert.assertEquals(inner.getName() + " should have at least 2 constructors", 2, constructors.length);    
    passed = true;    
  } 
  
  //Helper method to check if a given class contains the expected fields 
  private void testFields(Class c, Map<String,String> allFields, boolean isPrivate) 
    throws SecurityException{          
    Field[] fields = c.getDeclaredFields();
  
    boolean found = false;
    int numberOfFields = 0;
    for (String f1: allFields.keySet()){
      //System.out.println(f1 + " : " + allFields.get(f1));
      for (Field f2: fields){
        //System.out.println("   vs " + Modifier.isPrivate(f2.getModifiers()) + " " + f2.getName() + " : " + f2.getType().getSimpleName());
        if (f1.equals(f2.getName()) && f2.getType().getSimpleName().equals(allFields.get(f1))){ 
          found = true;
          if (isPrivate && !Modifier.isPrivate(f2.getModifiers())){
            found = false;
          }
        }
        if (!f2.isSynthetic()){
          numberOfFields++;
        }
      }
      //System.out.println("   ==>  " + found );
      if(!found){
        Assert.fail(c.getName() + " should contain field: " + allFields.get(f1) + " " + f1);
      }
      found = false;
    }      
    Assert.assertEquals(c.getName() + " should contain the following " + allFields.size() + " declared fields : "  + allFields , 
                        allFields.size(), fields.length);    
  }
  
//Helper method to check if a given class contains the expected methods 
  private void testMethods(Class c, Map<String,String> allMethods, boolean isPrivate) 
    throws SecurityException{          
    Method[] methods = c.getDeclaredMethods();
    boolean found = false;
    int numberOfMethods = 0;   
    for (String m1: allMethods.keySet()){
      //System.out.println(m1);
      numberOfMethods = 0;
      for (Method m2: methods){
        //System.out.println("   vs " + Modifier.isPrivate(m2.getModifiers()) + " " + m2.getName() + " : " + m2.getReturnType().getSimpleName());        
        if (m1.equals(m2.getName()) && m2.getReturnType().getSimpleName().equals(allMethods.get(m1))){
          found = true;
          if (isPrivate && !Modifier.isPrivate(m2.getModifiers())){
            found = false;
          }
        }
        if (!m2.isSynthetic()){
          numberOfMethods++;
        }        
      }
      //System.out.println("   ==>  " + found );
      if(!found){
        Assert.fail(c.getName() + " should contain method: " + allMethods.get(m1) +" " + m1);
      }
      found = false;
    }     
    Assert.assertEquals(c.getName() + " should contain the following " + allMethods.size() + " declared methods : "  + allMethods , 
                        allMethods.size(), numberOfMethods);  
  }
  
  @AfterClass
  public static void reportStats(){    
    Class me = MethodHandles.lookup().lookupClass();
    System.out.println(tallyStats(me));
  }   
}
