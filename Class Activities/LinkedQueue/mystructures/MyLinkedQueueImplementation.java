
package mystructures;

import java.util.*;


/**** START HERE: VISIT LINK TO ANIMATION *****************************************************************
  *
  * GO TO THE FOLLOWING (COPY/PASTE URL) 
  * 
  * https://faculty.csbsju.edu/irahal/SW/DataStructuresVisualizations/Lab05_QueueLL.html
  */







/** 
 * Class to implement interface MyQueue as a linked list.
 * 
 * @author Rahal
 * @version 09/27/2022
 */


public class MyLinkedQueueImplementation < ElementType > implements MyQueue < ElementType > {  
  // Data Fields
  /** The reference to the front of the queue where we dequeue. */
  private Node front;
  
  /** The reference to the rear of the queue where we enqueue. */
  private Node rear;
  
  /** create an empty queue denoted by an empty front = rear node. */  
  public MyLinkedQueueImplementation(){
//**** COMPLETE ME:  STACK HAD THE FOLLOWING *****************************************************************
    /*
     * this.top = new Node ();
     */ 
    this.front = new Node();
    this.rear = this.front;
  }  
  
  public void enqueue(ElementType element) {
//**** COMPLETE ME:  STACK HAD THE FOLLOWING *****************************************************************
    /*
     * this.top = new Node(element, this.top);
     */ 
    this.rear.element = element;
    this.rear.next = new Node();
    this.rear = this.rear.next;
    
  }  
  
  public ElementType peek() {
//**** COMPLETE ME:  STACK HAD THE FOLLOWING *****************************************************************
    /*
     if (this.isEmpty()){
     throw new NoSuchElementException("Can't PEEK an empty stack");
     }
     return this.top.element;
     */
    if (this.front.isTerminal()){
     throw new NoSuchElementException("Can't PEEK an empty stack");
     }
    return this.front.element;
  }
  
  public ElementType dequeue() {
//**** COMPLETE ME:  STACK HAD THE FOLLOWING *****************************************************************
    /*
     if (this.isEmpty()){
     throw new NoSuchElementException("Can't POP an empty stack");
     }
     ElementType result = this.top.element;
     this.top = this.top.next;
     return result;
     */
    if (this.isEmpty()){
     throw new NoSuchElementException("Can't POP an empty stack");
     }
    ElementType returnVal = front.element;
    front = front.next;
    return returnVal;
  }
  
  
  public boolean isEmpty() {
    //**** COMPLETE ME: STACK HAD THE FOLLOWING *****************************************************************
    /*
     * return this.top.isTerminal();
     */
    return this.front.isTerminal();
  }
  
  public boolean contains(ElementType element){
//**** COMPLETE ME:  STACK HAD THE FOLLOWING *****************************************************************
    /*
     for(ElementType e: this){
     if(e.equals(element)){
     return true;
     }
     }
     return false;
     */
    for(ElementType e : this) {
      if (e.equals(element))
        return true;
    }
    return false;
  } 
  
  public Iterator<ElementType> iterator(){
    return new InternalIterator();
  }  
  
  /** A Node is the building block for a single-linked list. */
  private class Node{
    // Data Fields
    /** The reference to the element. */
    private ElementType element;
    
    /** The reference to the next node. */
    private Node next;
    
    // Constructors
    /** 
     * Creates a new empty node with null next and element fields.
     */
    private Node() {
      this.element = null;
      this.next = null;
    }    
    /** 
     * Creates a new node with a null next field.
     * @param elementItem The element stored
     */
    private Node(ElementType elementItem) {
      this.element = elementItem;
      this.next = null;
    }
    
    /** 
     * Creates a new node that references another node.
     * @param elementItem The element stored
     * @param nodeRef The node referenced by new node
     */
    private Node( ElementType elementItem, Node nodeRef) {
      this.element = elementItem;
      this.next = nodeRef;
    }
    
    /** 
     * Returns true if the node has null element and next instance fields which
     * is used to designate the "terminal" node in this structure .
     * 
     * @return true if this node is a "terminal" node
     */    
    private boolean isTerminal(){
      return this.element == null && this.next == null;
    }    
  } //end class Node
  
  
  /**
   * Class to implement Iterator interface needed for method iterator()
   */   
  private  class InternalIterator implements Iterator<ElementType>{  
    /** currentNode used to traverse elements in the collection*/
    private Node currentNode;
    
    /**
     * Constructor initializes currentNode to top
     */
    private InternalIterator(){
//**** COMPLETE ME:  STACK HAD THE FOLLOWING *****************************************************************
      //this.currentNode = top;
      this.currentNode = front;
    }
    
    /**
     * {@inheritDoc}
     */  
    public boolean hasNext(){
//**** COMPLETE ME:  STACK HAD THE FOLLOWING *****************************************************************
      //return (!this.currentNode.isTerminal());
      return !this.currentNode.isTerminal();
    }
    
    /**
     * {@inheritDoc}
     */    
    public ElementType next(){
//**** COMPLETE ME:  STACK HAD THE FOLLOWING *****************************************************************
      /* if(!this.hasNext()){
       throw new NoSuchElementException();
       }
       ElementType currentElement = this.currentNode.element;
       this.currentNode = this.currentNode.next;
       return currentElement;
       }*/
      if(!this.hasNext()){
        throw new NoSuchElementException();
      }
      ElementType currentElement = this.currentNode.element;
      this.currentNode = this.currentNode.next;
      return currentElement;
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
