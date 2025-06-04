/*
 * File: AJNLinkedIndexedList.java
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
public class AJNLinkedIndexedList<ElementType> implements AJNIndexedList<ElementType>  {
  
  /**
   * The first node that can be accessed in the list
   */
  private ListNode head;
  
  /**
   * Int variable to keep track of the size of the list
   */
  private int size;
  
  /**
   * This is the default constructor for the class that sets original empty values
   */
  public AJNLinkedIndexedList() {
    head = new ListNode();
    size = 0;
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
  public boolean contains(ElementType element) {
    return this.head.contains(element);
  }
  
  /* (non-Javadoc)
   * @see java.lang.Iterable#iterator()
   */
  public Iterator<ElementType> iterator() {
    return this.head.iterator();
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
  public ElementType get(int index) {
    if (index >= size || index < 0) 
      throw new IndexOutOfBoundsException();
    return this.head.get(index);
  }
  
  /**
   * {@inheritDoc}
   */
  public ElementType set(int index, ElementType newValue) {
    if (index >= size || index < 0) 
      throw new IndexOutOfBoundsException();
    return this.head.set(index, newValue);
  }
  
  /**
   * {@inheritDoc}
   */
  public void addElementAt(int index, ElementType element) {
    if (index > size || index < 0) 
      throw new IndexOutOfBoundsException(); 
    this.head.addElementAt(index, element);
  }
  
  /**
   * {@inheritDoc}
   */
  public ElementType removeElementAt(int index) {
    if (index >= size || index < 0) 
      throw new IndexOutOfBoundsException(); 
    return this.head.removeElementAt(index);
  }
  
  /**
   * {@inheritDoc}
   */
  public int indexOf(ElementType element) {
    return this.head.indexOf(element);
  }
  
  
  /**
   * {@inheritDoc}
   */
  public int lastIndexOf(ElementType element) {
    return this.head.lastIndexOf(0, -1, element);
  }
  
  /**
   * {@inheritDoc}
   */
  public AJNIndexedList<ElementType> subList(int fromIndex, int toIndex) {
    if (fromIndex > size || fromIndex < 0 || toIndex > size || toIndex < 0 || fromIndex > toIndex) 
      throw new IndexOutOfBoundsException();
    AJNIndexedList<ElementType> subList = new AJNLinkedIndexedList<>();
    for (int i = fromIndex; i <= toIndex; i++) {
      subList.addElementAt(i - fromIndex, this.get(i));
    }
    return subList;
  }
  
  /**
   * {@inheritDoc}
   */
  public boolean containsDuplicates() {
    AJNIndexedList<ElementType> comparison = new AJNLinkedIndexedList<>();
    for (ElementType e : this) {
      if (comparison.contains(e)) {
        return true;
      } else {
        comparison.addElementAt(0, e);
      }
    }
    return false;
  }
  
  
  /**
   * Inner class to implement nodes used to build the ZHStack ADT.
   * 
   * Inherited methods:
   *   contains()
   *   isEmpty()
   *   size()
   *   iterator()
   *   
   *   //the remaining methods allow you to access StackNode's element and next
   *   ElementType getElement()
   *   void setElement(ElementType element)
   *   StackNode getNext()
   *   void setNext(StackNode next)
   * 
   */
  private class ListNode extends ZHOneWayListNode<ElementType, ListNode> 
    implements Serializable {
    
    /**
     * Creates a new empty node.
     */
    protected ListNode() {
      super();
    }
    
    /**
     * Creates a new node with the specified data element and next node.
     * 
     * @param element the data element for the new node
     * @param next the next node for the new node
     */
    protected ListNode(ElementType element, ListNode next) {
      super(element, next);
    }
    
    /**
     * {@inheritDoc}
     */
    private ElementType get(int index) {
      if (this.isTerminal()) 
        return null;
      else if (index == 0)
        return this.element;
      else
        return this.next.get(index -1);
    }
    
    /**
     * {@inheritDoc}
     */
    private void addElementAt(int index, ElementType element) {
      if (index == 0) {
        this.next = new ListNode(this.element, this.next);
        this.element = element;
        size++;
      } else
        this.next.addElementAt(index -1, element);
    }
    
    /**
     * {@inheritDoc}
     */
    private ElementType set(int index, ElementType newValue) {
      if (index == 0) {
        ElementType e = this.element;
        this.element = newValue; 
        return e;
      } else
        return this.next.set(index - 1, newValue);
    }
    
    /**
     * {@inheritDoc}
     */
    private int indexOf(ElementType element) {
      if (this.isTerminal()) {
        return -1 - size; 
      } else if (this.element.equals(element)) {
        return 0;
      } else {
        return 1 + this.next.indexOf(element); 
      }
    }
    
    /**
     * {@inheritDoc}
     * @param index to identify where to search, which is the current location in the list
     * @param indexOfLastMatch the last position where we found a match or -1 if we have not found a match yet
     */
    private int lastIndexOf(int index, int indexOfLastMatch, ElementType element) {
      if (this.isTerminal()) {
        return indexOfLastMatch; 
      } else if (this.element.equals(element)) {
        indexOfLastMatch = index;
      } 
      return this.next.lastIndexOf(index + 1, indexOfLastMatch, element);
    }
    
    /**
     * {@inheritDoc}
     */
    private ElementType removeElementAt(int index) {
      if (index == 0) {
        ElementType e = this.element;
        this.element = this.next.element;
        this.next = this.next.next;
        size--;
        return e;
      } else {
        return this.next.removeElementAt(index -1);
      }
    }
    
  }
}

