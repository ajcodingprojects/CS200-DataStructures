import mystructures.*;

import java.util.*;


public class MyQueueDriver {
  
  public static void main(String[] args) {
    
    MyQueue<String> qu=new MyQueueImplementation<String>();
    
    qu.enqueue("a");
    System.out.println("Enqueued     : " + qu.peek());
    qu.enqueue("b");
    System.out.println("Enqueued     : b");
    qu.enqueue("c");
    System.out.println("Enqueued     : c");
    qu.enqueue("d");
    System.out.println("Enqueued     : d");
    qu.enqueue("a");
    System.out.println("Enqueued     : a");    
    qu.enqueue("e");
    System.out.println("Enqueued     : e");
    
    System.out.println("****************************************************************************");    
    System.out.println("Queue has been loaded ... iterating once using enhanced for loop :");
    for(String e : qu){
      System.out.print(e + " ");
    }
    System.out.println();
    System.out.println("****************************************************************************");    
    System.out.println("Queue has been loaded ... iterating twice using enhanced for loop :");
    for(String e : qu){
      System.out.print(e + " ");
    }
    System.out.println();   
    System.out.println("*********************************************");
    System.out.println("Dequeued top : " + qu.dequeue());
    System.out.println("New top is   : " + qu.peek());
    
    System.out.println("*********************************************");
    System.out.println("Dequeued top : " + qu.dequeue());
    System.out.println("New top is   : " + qu.peek());
    
    System.out.println("*********************************************");
    System.out.println("Dequeued top : " + qu.dequeue());
    System.out.println("New top is   : " + qu.peek());
    
    System.out.println("*********************************************");
    System.out.println("Dequeued top : " + qu.dequeue());
    System.out.println("New top is   : " + qu.peek());
    
    System.out.println("*********************************************");
    System.out.println("Dequeued top : " + qu.dequeue());
    System.out.println("New top is   : " + qu.peek());
    
    System.out.println("*********************************************");
    System.out.println("Dequeued top : " + qu.dequeue());
    try{
      qu.peek();
    }
    catch(NoSuchElementException nsee){
      System.out.println("NoSuchElementException correctly caught when peeking at an empty queue");
    }
    
    try{
      qu.dequeue();
    }
    catch(NoSuchElementException nsee){
      System.out.println("NoSuchElementException correctly caught when dequeuing from an empty queue");
    }    
    System.out.println("****************************************************************************");    
    System.out.println("Nothing left to interate over");
    for(String e : qu){
      System.out.println("Value :"+e);
    }  
    
  }
}
