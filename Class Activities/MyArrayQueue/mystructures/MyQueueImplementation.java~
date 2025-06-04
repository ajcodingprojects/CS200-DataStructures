package mystructures;

import java.util.*;
import java.util.stream.*;

/// START HERE ******************************************************************************************

/* COMPLETE ALL METHODS BELOW MARKED WITH *****COMPLETE ME **** 
 * 
 * NOTE: for your convenience, I am enclosing solution for our MyArrayStack implementation
 * 
 * FIRST TASK: choose which end of queue to enqueue to and which end to dequeue from
 */
/// START HERE ******************************************************************************************







/** 
 * Class to implement interface MyQueue as an array.
 * 
 * @author Rahal
 * @version 09/16/2022
 */
public class MyQueueImplementation < ElementType > implements MyQueue<ElementType>{
  // Data Fields
  /** The default initial capacity */
  private static final int INITIAL_CAPACITY = 10;
  
  /** The underlying data array */
  private ElementType[] theData;
  
  /** The current size */
  private int size = 0;
  
  /** The current capacity */
  private int capacity = 0;
  
  /** 
   * Construct an empty MyQueueImplementation with the default
   * initial capacity
   */
  public MyQueueImplementation() {
    this.capacity = INITIAL_CAPACITY;
    this.theData = (ElementType[])new Object[this.capacity];
  }
  /**
   * {@inheritDoc}
   */
  public void enqueue(ElementType element){
//**************************************COMPLETE ME ***********************************************
// THIS IS WHAT WE DID FOR ARRAY STACK IMPLEMENTATION
//    if (this.size == this.capacity) {
//      this.reallocate();
//    }
//    this.theData[this.size++] = element;
    
    if (this.size == this.capacity) {
      this.reallocate();
    }

    this.theData[this.size++] = element;
  }
  
  /**
   * {@inheritDoc}
   */
  public ElementType peek(){
//**************************************COMPLETE ME ***********************************************
// THIS IS WHAT WE DID FOR ARRAY STACK IMPLEMENTATION    
//    if(this.isEmpty())
//      throw new NoSuchElementException("Can't PEEK an empty stack");
//    return this.theData[size-1];
    if (this.isEmpty()) {
      throw new NoSuchElementException("Can't PEEK an empty stack");
    }
    
    return theData[0];
  }
  
  /**
   * {@inheritDoc}
   */
  public ElementType dequeue(){
//**************************************COMPLETE ME ***********************************************
// THIS IS WHAT WE DID FOR ARRAY STACK IMPLEMENTATION    
//    if(this.isEmpty())
//      throw new NoSuchElementException("Can't POP an empty stack");
//    ElementType top = this.theData[size-1];
//    this.size--;
//    return top;
    if(this.isEmpty())
      throw new NoSuchElementException("Can't POP an empty stack");
    ElementType firstOut = this.peek();
    for (int i = 1; i < size; i++){
      theData[i-1] = theData[i];
    }
    size--;
    return firstOut;
  } 
  
  /**
   * Helper method to double the  size of theData
   */
  private void reallocate() {
    this.capacity = 2 * this.capacity;
    ElementType[] newData = (ElementType[])new Object[this.capacity];
    System.arraycopy(this.theData, 0, newData, 0, this.size);
    this.theData = newData;
  } 
  
  /**
   * {@inheritDoc}
   */
  public boolean isEmpty(){
   return this.size==0;
  }
  
  /**
   * {@inheritDoc}
   */
  public boolean contains(ElementType element){
//**************************************COMPLETE ME ***********************************************
// THIS IS WHAT WE DID FOR ARRAY STACK IMPLEMENTATION    
//    for(ElementType e: this){
//      if(e.equals(element)){
//        return true;
//      }
//    }
    return Arrays.stream(theData).anyMatch(e -> element.equals(e));
    
  }
  
  /**
   * {@inheritDoc}
   */
  public Iterator<ElementType> iterator(){
//**************************************COMPLETE ME ***********************************************
// THIS IS WHAT WE DID FOR ARRAY STACK IMPLEMENTATION    
//    return new InternalIterator();

    return new InternalIterator();
  }
  
  /**
   * Class to implement Iterator interface needed for method iterator()
   */ 
  private  class InternalIterator implements Iterator<ElementType>{
    /** position used to traverse elements in the collection*/    
    private int position;
    
    /**
     * Constructor initializes currentPosition to 0
     */
    public InternalIterator(){
//**************************************COMPLETE ME ***********************************************
// THIS IS WHAT WE DID FOR ARRAY STACK IMPLEMENTATION      
//this.position=0;
      this.position = 0;
    }
    
    /**
     * {@inheritDoc}
     */     
    public boolean hasNext(){
//**************************************COMPLETE ME ***********************************************
// THIS IS WHAT WE DID FOR ARRAY STACK IMPLEMENTATION     
//return this.position<size;      
      return this.position < size;
    }
    
    /**
     * {@inheritDoc}
     */    
    public ElementType next(){
//**************************************COMPLETE ME ***********************************************
// THIS IS WHAT WE DID FOR ARRAY STACK IMPLEMENTATION      
//      if(!hasNext()){
//        throw new NoSuchElementException();
//      }
//      return theData[this.position++];
//    }
      if(!hasNext()){
        throw new NoSuchElementException();
      }
      return theData[this.position++];
    }
      
    /**
     * {@inheritDoc}
     * @throws UnsupportedOperationException because operation is not supported
     */ 
    public void remove(){
      throw new UnsupportedOperationException("Remove");
    }
    
  }
}
