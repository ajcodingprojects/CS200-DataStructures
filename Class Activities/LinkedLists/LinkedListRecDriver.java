import mystructures.*;
public class LinkedListRecDriver{
  public static void main(String[] args){
    /********************************* CHOOSE WHICH VERSION TO RUN ***************************************************/
    SimpleList<String> list1 = new LinkedListUsingRecursion<String>();
    
    System.out.println("***********************************************************************************************");
    System.out.println("Initially");
    System.out.println("Size of list1 is : " + list1.size());
    System.out.println("Contents are : " + list1);      
    list1.append("CSCI160");
    System.out.println("***********************************************************************************************");
    System.out.println("Add 'CSCI160' to list1");
    System.out.println("Size of list1 is : " + list1.size());
    System.out.println("Contents are : " + list1);    
    list1.append("CSCI200");
    System.out.println("***********************************************************************************************");
    System.out.println("Add 'CSCI200' to list1");
    System.out.println("Size of list1 is : " + list1.size());
    System.out.println("Contents are : " + list1);    
    list1.append("CSCI230");
    System.out.println("***********************************************************************************************");
    System.out.println("Add 'CSCI230' to list1");
    System.out.println("Size of list1 is : " + list1.size());
    System.out.println("Contents are : " + list1);    
    list1.append("CSCI239");
    System.out.println("***********************************************************************************************");
    System.out.println("Add 'CSCI239' to list1");
    System.out.println("Size of list1 is : " + list1.size());
    System.out.println("Contents are : " + list1);    
    list1.append("CSCI310");
    System.out.println("***********************************************************************************************");
    System.out.println("Add 'CSCI310' to list1");
    System.out.println("Size of list1 is : " + list1.size());
    System.out.println("Contents are : " + list1);
    System.out.println("***********************************************************************************************");  
    System.out.println("get(0) = " + list1.get(0));
    System.out.println("get(1) = " + list1.get(1));
    System.out.println("get(2) = " + list1.get(2));
    System.out.println("get(3) = " + list1.get(3));
    System.out.println("get(4) = " + list1.get(4));    
    try{
      System.out.println("get(5) = " + list1.get(5));     
    }
    catch(IllegalArgumentException iae){
      System.out.println("get(5) : If you see this message then the get method has SUCCESSFULLY failed to get(5)");
    }
    System.out.println("***********************************************************************************************");      
    System.out.println("After Removing CSCI230 from list1");
    list1.remove("CSCI230");
    System.out.println("Size of list1 is : " + list1.size());
    System.out.println("Contents are : " + list1);
    System.out.println("***********************************************************************************************");  
    System.out.println("get(0) = " + list1.get(0));
    System.out.println("get(1) = " + list1.get(1));
    System.out.println("get(2) = " + list1.get(2));
    System.out.println("get(3) = " + list1.get(3));
    try{
      System.out.println("get(4) = " + list1.get(4));     
    }
    catch(IllegalArgumentException iae){
      System.out.println("get(4) : If you see this message then method get has SUCCESSFULLY failed to get(4)");
    }    
    System.out.println("***********************************************************************************************");
    System.out.println("After Removing CSCI160 from list1");
    list1.remove("CSCI160");
    System.out.println("Size of list1 is : " + list1.size());
    System.out.println("Contents are : " + list1);
    System.out.println("***********************************************************************************************");
    System.out.println("After Removing CSCI160 again from list1");
    list1.remove("CSCI160");
    System.out.println("Size of list1 is : " + list1.size());
    System.out.println("Contents are : " + list1);
    System.out.println("***********************************************************************************************");
    System.out.println("After Removing CSCI310 from list1");
    list1.remove("CSCI310");
    System.out.println("Size of list1 is : " + list1.size());
    System.out.println("Contents are : " + list1);
    System.out.println("***********************************************************************************************");
    System.out.println("After Removing CSCI200 from list1");
    list1.remove("CSCI200");
    System.out.println("Size is : " + list1.size());
    System.out.println("Contents are : " + list1);
    System.out.println("***********************************************************************************************");
    System.out.println("After Removing CSCI239 from list1");
    list1.remove("CSCI239");
    System.out.println("Size of list1 is : " + list1.size());
    System.out.println("Contents are : " + list1);    
    System.out.println("***********************************************************************************************");  
    System.out.println("After Removing XXXX from list1");
    list1.remove("XXXX");
    System.out.println("Size of list1 is : " + list1.size());
    System.out.println("Contents are : " + list1);
    System.out.println("***********************************************************************************************");
    list1.append("A");
    list1.append("B");
    list1.append("C");
    list1.append("D");
    list1.append("E");
    list1.append("F");   
    System.out.println("Size of list1 is : " + list1.size());
    System.out.println("Contents are : " + list1);      
    System.out.println("IndexOf(A) is : " + list1.indexOf("A"));
    System.out.println("IndexOf(B) is : " + list1.indexOf("B"));
    System.out.println("IndexOf(C) is : " + list1.indexOf("C"));
    System.out.println("IndexOf(D) is : " + list1.indexOf("D"));
    System.out.println("IndexOf(E) is : " + list1.indexOf("E"));   
    System.out.println("IndexOf(F) is : " + list1.indexOf("F"));      
    System.out.println("IndexOf(G) is : " + list1.indexOf("G"));          
    System.out.println("Contents in reverse are : " + list1.toStringReverse());      
    System.out.println("***********************************************************************************************");    
    
    /********************************* CHOOSE WHICH VERSION TO RUN ***************************************************/    
    //SimpleList<String> list2 = new LinkedListUsingFunctionalRecursion<String>();
    SimpleList<String> list2 = new LinkedListUsingRecursion<String>();
    
    list2.append("1");
    list2.append("2");
    list2.append("3");
    list2.append("4");
    list2.append("3");
    System.out.println("Contents of new list (list2) are : " + list2);
    System.out.println("list1.isSubList(list2) should return false ==> "+ list1.isSubList(list2));
    System.out.println("list2.isSubList(list1) should return false ==> "+ list2.isSubList(list1));   
    System.out.println("list1.isSubList(list1) should return true  ==> "+ list1.isSubList(list1));    
    list1.appendAll(list2);
    System.out.println("Contents after list1.appendAll(list2): " + list1);  
    System.out.println("Contents in reverse are : " + list1.toStringReverse());
    System.out.println("list1.isSubList(list2) should return true ==> "+ list1.isSubList(list2));        
    System.out.println("***********************************************************************************************");
  }
  
}
