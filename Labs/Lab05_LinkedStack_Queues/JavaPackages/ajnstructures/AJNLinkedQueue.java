/*
 * File: AJNLinkedQueue.java
 */
package ajnstructures;

import java.util.*;
import zhstructures.*;

/**
 * Class implementing a ZHQueue using an internal
 * one-way linked structure/node.
 * 
 * @author I. Rahal, J. A. Whitford Holey, and Andrew Nerud, Colin Glynn
 * @version October 12, 2022
 */
public class AJNLinkedQueue<ElementType> implements ZHQueue<ElementType> {
  
  /**
   * The number of elements in this queue.
   */
  private int size = 0;
  /**
   * A reference to the front node in this queue.
   */
  private QueueNode front;
  
   /**
   * A reference to the rear node in this queue.
   */
  private QueueNode rear;
  
  /**
   * Creates a new empty queue.
   */
  public AJNLinkedQueue() {
    this.front = new QueueNode();
    this.rear = this.front;
  }
  
  /**
   * {@inheritDoc}
   */ 
  public ElementType peek() {
    if (isEmpty()) 
      throw new NoSuchElementException();
    return front.getElement();
  }
  
  
  /**
   * {@inheritDoc}
   */ 
  public void enqueue(ElementType element) {
    if (element == null) 
      throw new IllegalArgumentException();
    rear.setElement(element);
    rear.setNext(new QueueNode()); 
    rear = rear.getNext();
    size++;
  }
  
  /**
   * {@inheritDoc}
   */ 
  public ElementType dequeue() {
    if (isEmpty()) 
      throw new NoSuchElementException();
    ElementType popped = front.getElement();
    front = front.getNext();
    size--;
    return popped;
  }
  
  /**
   * {@inheritDoc}
   */ 
  public boolean isEmpty() {
    return size <= 0;
  }
  
  /**
   * {@inheritDoc}
   */ 
  public int size() {
    return size;
  }
    
  /**
   * {@inheritDoc}
   */ 
  public boolean contains(ElementType element) {
    for(ElementType e : this) {
      if (e.equals(element)) return true;
    }
    
    return false;
  }
  
  /**
   * {@inheritDoc}
   */ 
  public Iterator<ElementType> iterator() {
    return this.front.iterator();
  }
  
  /**
   * Inner class to implement nodes used to build the ZHQueue ADT.
   * 
   * Inherited methods:
   *   contains()
   *   isEmpty()
   *   size()
   *   iterator()
   *   
   *   //the remaining methods allow you to access QueueNode's element and next
   *   ElementType getElement()
   *   void setElement(ElementType element)
   *   QueueNode getNext()
   *   void setNext(QueueNode next)
   * 
   */
  protected class QueueNode extends ZHOneWayListNode<ElementType, QueueNode> {
    
    /**
     * Creates a new empty node.
     */
    protected QueueNode() {
      super();
    }
    
    /**
     * Creates a new node with the specified data element and next node.
     * 
     * @param element the data element for the new node
     * @param next the next node for the new node
     */
    protected QueueNode(ElementType element, QueueNode next) {
      super(element, next);
    }
  }
}
