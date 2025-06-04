/*
 * File: AJNIndexedListQueue.java
 */

package ajnstructures;

import java.util.*;
import zhstructures.*;
import java.io.Serializable;

/**
 * Interface for a list accessed by element index (0 .. size-1). 
 * Represents a simplified List
 * 
 * @author Andrew Nerud and Colin Glynn
 * @version October 26, 2022
 */
public class AJNIndexedListQueue<ElementType> implements ZHQueue<ElementType> {
  
  
  /**
   * The number of elements in this queue.
   */
  private AJNIndexedList<ElementType> innerList;
  
  /**
   * Creates a new empty queue.
   */
  public AJNIndexedListQueue() {
    innerList = new AJNLinkedIndexedList<>();
  }
  
  /**
   * {@inheritDoc}
   */ 
  public ElementType peek() {
    if (isEmpty()) 
      throw new NoSuchElementException();
    return innerList.get(0);
  }
  
  
  /**
   * {@inheritDoc}
   */ 
  public void enqueue(ElementType element) {
    if (element == null) 
      throw new IllegalArgumentException();
    innerList.addElementAt(innerList.size(), element);
  }
  
  /**
   * {@inheritDoc}
   */ 
  public ElementType dequeue() {
    if (isEmpty()) 
      throw new NoSuchElementException();
    return innerList.removeElementAt(0);
  }
  
  /**
   * {@inheritDoc}
   */ 
  public boolean isEmpty() {
    return innerList.size() <= 0;
  }
  
  /**
   * {@inheritDoc}
   */ 
  public int size() {
    return innerList.size();
  }
    
  /**
   * {@inheritDoc}
   */ 
  public boolean contains(ElementType element) {
    return innerList.contains(element);
  }
  
  /**
   * {@inheritDoc}
   */ 
  public Iterator<ElementType> iterator() {
    return innerList.iterator();
  }
  
}
