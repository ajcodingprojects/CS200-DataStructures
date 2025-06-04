import mystructures.*;
import java.util.*;
public class LinkedListRecDriver{
  public static void main(String[] args){
    SimpleList<String> list1 = new LinkedListRec<String>();
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
    System.out.print("ForEach returns         : ");
    for(String s: list1){
      System.out.print(s + "->");
    }
    System.out.println("|TERMINAL|");  
    System.out.println("Iterating again .... ");
    System.out.print("ForEach returns         : ");
    for(String s: list1){
      System.out.print(s + "->");
    }
    System.out.println("|TERMINAL|");  
    System.out.println("***********************************************************************************************");
    ListIterator<String> li = (ListIterator<String>) list1.iterator();
    
    System.out.print("Loop using list iterator going backward  : ");
    while(li.hasPrevious()){
      System.out.print("("+li.previousIndex() + ")"+ li.previous() + " ");
    }     
    System.out.println("");    
    
    System.out.print("Loop using list iterator going forward   : ");
    while(li.hasNext()){
      System.out.print("("+li.nextIndex() + ")"+ li.next()  + " ");
    } 
    System.out.println("");   
    System.out.print("Loop using list iterator going backward  : ");
    while(li.hasPrevious()){
      System.out.print("("+li.previousIndex() + ")"+ li.previous() + " ");
    }     
    System.out.println("");
  }    
  
}
