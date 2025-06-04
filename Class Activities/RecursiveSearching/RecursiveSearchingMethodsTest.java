import org.junit.*;                // needed by JUnit4

public class RecursiveSearchingMethodsTest{
  private int[] dataToSearch = {0,10,20,30,40,50,60,70};
  
  @Test
  public void recursiveLinearSearchMatchAtMiddle() {   
    Assert.assertEquals("value 60 is at location 6", 6, RecursiveMethods.recursiveLinearSearch(dataToSearch,60,0));
  }
  
  @Test
  public void recursiveLinearSearchMatchAtStart() {   
    Assert.assertEquals("value 0 is at location 0", 0, RecursiveMethods.recursiveLinearSearch(dataToSearch,0,0));
  }
  
  @Test
  public void recursiveLinearSearchMatchAtEnd() {   
    Assert.assertEquals("value 70 is at location 7",7, RecursiveMethods.recursiveLinearSearch(dataToSearch,70,0));        
  }
  
  @Test
  public void recursiveLinearSearchNoMatches() {   
    Assert.assertEquals("value 80 is NOT in array ",-1, RecursiveMethods.recursiveLinearSearch(dataToSearch,80,0));            
  }
  @Test
  public void recursiveBinarySearchMatchAtMiddle() {   
    Assert.assertEquals("value 60 is at location 6", 6, RecursiveMethods.recursiveBinarySearch(dataToSearch,60,0,dataToSearch.length-1));
  }
  
  @Test
  public void recursiveBinarySearchMatchAtStart() {   
    Assert.assertEquals("value 0 is at location 0", 0, RecursiveMethods.recursiveBinarySearch(dataToSearch,0,0,dataToSearch.length-1));
  }
    
  @Test
  public void recursiveBinarySearchMatchAtEnd() {   
    Assert.assertEquals("value 70 is at location 7",7, RecursiveMethods.recursiveBinarySearch(dataToSearch,70,0,dataToSearch.length-1));        
  }
  
  @Test
  public void recursiveBinarySearchNoMatches() {   
    Assert.assertEquals("value 80 is NOT in array ",-1, RecursiveMethods.recursiveBinarySearch(dataToSearch,80,0,dataToSearch.length-1));            
  }  
}

