/** A recursive linked list class with recursive methods.*/
package mystructures;

import java.util.*;

@SuppressWarnings("unchecked")
public class LinkedListRec <E> implements SimpleList<E> {
  
  /** The list head */
  private Node head;
  
  public LinkedListRec(){
    /** The last node in the list is always the empty node ... head initially points to the empty node  */
    this.head = new Node(); 
  }
  
  public int size() {
    return this.size(this.head);
  }
  
  private int size(Node currentNode) {
    if (currentNode.isTerminal())
      return 0;
    return 1 + this.size(currentNode.next);
  }
  
  
  public String toString() {
    return this.toString(this.head);
  } 
  
  private String toString(Node currentNode) {
    if (currentNode.isTerminal())
      return "|TERMINAL|";     
    return currentNode.element + "->" + this.toString(currentNode.next);
  } 
  
  public void append(E element) {
    this.append(element, this.head); 
  }
  
  private void append(E element, Node currentNode) {
    if (currentNode.isTerminal()){
      currentNode.element = element;
      currentNode.next = new Node();
    }
    else
      this.append(element, currentNode.next); // Add to rest of list
  }
  
  public E get(int index){
    if(index>= size() || index <0)
      throw new IllegalArgumentException();
    return this.get(index, this.head);
  }
  
  private E get(int index,Node currentNode){
    if(currentNode.isTerminal())
      return null;
    else if(index == 0)
      return currentNode.element;
    else
      return this.get(index-1, currentNode.next);
  }
  
  public Iterator<E> iterator(){
    return new InternalIteratorV2();
  }  
  
  /** A Node is the building block for a single-linked list. */
  private class Node{
    /** The reference to the data element. */
    private E element;
    
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
     * @param element The data stored
     */
    private Node(E element) {
      this.element = element;
      this.next = null;
    }
    
    /** Creates a new node that references another node
      * @param element The data stored
      * @param next The node referenced by new node
      */
    private Node(E element, Node next) {
      this.element = element;
      this.next = next;
    }
    
    /** 
     * Returns true if the node has null data and next instance fields which
     * is used to designate the "terminal" node in this structure .
     * 
     * @return true if this node is a "terminal" node
     */    
    private boolean isTerminal(){
      return this.element == null && this.next == null;
    }
  } //end class Node
  
  /*
   * ******************************************************************************************************************
   * COMPLETE ME: First Internal Iterator Class
   * ******************************************************************************************************************
   * COMPLETE THIS ITERATOR CLASS TO USE currentNode (AN INSTANCE VARIABLE OF TYPE NODE) TO ITERATE OVER THE LIST. 
   * TO CHECK YOUR WORK: Change the iterator() method in the outer class to return an instance of this class, and then 
   * run driver
   */  
  private class InternalIteratorV1 implements Iterator<E>{
    
    /** A reference to the next node to return. */
    private Node currentNode;
    
    public InternalIteratorV1() {
      currentNode = head;
    }
    
    /** 
     * Indicate whether movement forward is defined.
     * @return true if call to next will not throw an exception
     */
    public boolean hasNext() {
      return !currentNode.isTerminal();
    }
    /** 
     * Move the iterator forward and return the next item.
     * @return The next item in the list
     * @throws NoSuchElementException if there is no such object
     */
    public E next() {
      if(!hasNext()){
        throw new NoSuchElementException();
      }
      E element = currentNode.element;
      currentNode = currentNode.next;
      return element;    
    } 
    
    public void remove() {
      throw new UnsupportedOperationException("Can't remove using iterators");
    }
  } //end inner class InternalIteratorV1
  
  /*
   * ******************************************************************************************************************
   * COMPLETE ME: Second Internal Iterator Class
   * ******************************************************************************************************************
   * COMPLETE THIS ITERATOR CLASS TO USE currentIndex (AN INSTANCE VARIABLE OF TYPE int) ALONG WITH THE get METHOD TO 
   * ITERATE OVER THE LIST.
   * TO CHECK YOUR WORK: Change the iterator() method in the outer class to return an instance of this class, and then 
   * run driver
   */ 
  private class InternalIteratorV2 implements Iterator<E>{
    
    /** A reference to the index of the next node to be returned. */
    private int currentIndex = 0;
    
    public InternalIteratorV2() {
      
    }
    
    /** 
     * Indicate whether movement forward is defined.
     * @return true if call to next will not throw an exception
     */
    public boolean hasNext() {
      return !(currentIndex>=size());
    }
    
    /** 
     * Move the iterator forward and return the next item.
     * @return The next item in the list
     * @throws NoSuchElementException if there is no such object
     */
    public E next() {
      if(!hasNext()){
        throw new NoSuchElementException();
      }
      E element = 
      return currentIndex.next;     
    } 
    
    public void remove() {
      throw new UnsupportedOperationException("Can't remove using iterators");
    }
  }//end inner class InternalIteratorV2  
}
