/** A recursive linked list class with recursive methods.*/
package mystructures;

import java.util.*;

@SuppressWarnings("unchecked")
public class LinkedListUsingRecursion<E> implements SimpleList<E> {
  
  /** The list head */
  private Node head;
  
  /** The last node in the list is always the empty node 
    * head initially points to the empty node  
    */  
  public LinkedListUsingRecursion(){
    this.head = new Node(); 
  }
  
  /**********************************************************************************************************************
    * EXERCISE 1: 
    *    READ and UNDERSTAND methods implemented using FUNCTIONAL recursion --- ASK QUESTIONS!
    *    NOTE how each class method has a private recursion version in OUTER class 
    *********************************************************************************************************************/
  /*** 1.1 size: uses functional recursion ***/
  public int size() {
    return this.size(this.head);
  }
  private int size(Node current) {
    if (current.isTerminal())
      return 0;
    else
      return 1 + this.size(current.next);
  }     
  
  /*** 1.2 toString: uses functional recursion ***/
  public String toString() {
    return this.toString(this.head);
  } 
  private String toString(Node current) {
    if (current.isTerminal())
      return "|TERMINAL|";     
    else
      return current.element + "->" + this.toString(current.next);
  }   
  
  
  /**********************************************************************************************************************
    * EXERCISE 2: 
    *    READ and UNDERSTAND methods implemented using STRUCTURAL recursion --- ASK QUESTIONS!
    *    NOTE how each class method has a private recursive versions in INNER class (at the bottom)
    *********************************************************************************************************************/ 
  /*** 2.1 contains: uses structural recursion ***/
  public boolean contains(E element) {
    return  this.head.contains(element); 
  }  
  
  /*** 2.2 append: uses structural recursion ***/  
  public void append(E element) {
    this.head.append(element);
  }  
  
  
  /**********************************************************************************************************************
    * EXERCISE 3:  
    *    IMPLEMENT the following two methods using FUNCTIONAL recursion
    *    NOTE you need to create a private recursive version with suitable parameters in the OUTER class for each method below
    *********************************************************************************************************************/   
  /*** 3.1 remove: Solve using FUNCTIONAL recursion like size & toString ***/    
  public boolean remove(E outElement){
    return remove(outElement, head);
  }    
  
  private boolean remove(E outElement, Node current) {
    if (current.isTerminal()) return false;
    
    if (current.element.equals(outElement)) {
      current.element = current.next.element;
      current.next = current.next.next;
      return true;
    } else
      return remove(outElement, current.next);
    
  }
  
  /*** 3.2 get: Solve using FUNCTIONAL recursion like size & toString ***/    
  public E get(int index){
    if (index >= size() || index < 0)
      throw new IllegalArgumentException();
    return get(index, head);
  }  
  
  private E get(int index, Node current){
    if (index == 0)
      return current.element;
    return get(index - 1, current.next);
  }
  
  
  
  /**********************************************************************************************************************
    * EXERCISE 4: 
    *    IMPLEMENT the following two methods using   
    *    NOTE you need to create a private recursive version with suitable parameters in the INNER class for each method below
    *********************************************************************************************************************/     
  /*** toStringReverse: Solve using STRUCTURAL recursion like contains & append  ***/    
  public String toStringReverse(){
    return head.toStringReverse();
  }  
  
  /*** indexOf: Solve using STRUCTURAL recursion like contains & append ***/  
  public int indexOf(E element){
    return head.indexOf(element);
  }     
  
  
  /**********************************************************************************************************************
    * EXERCISE 5: 
    *    IMPLEMENT the following two methods ITERATIVELY (using loops) instead RECURSIVELY
    *    NO additional methods need to be created
    *********************************************************************************************************************/   
  /*** appendAll ***/ 
  public void appendAll(SimpleList<E> l){
    for (int i = 0; i < l.size(); i++) {
      this.append(l.get(i));
    }
  }
  
  /*** isSubList ***/ 
  public boolean isSubList(SimpleList<E> potentialSubList){
    for (int i = 0; i < potentialSubList.size(); i++) { 
      if(this.indexOf(potentialSubList.get(i)) < 0)
        return false ;
    }
    return true;
  }
  
  
  /** A Node is the building block for a single-linked list. */
  private class Node {
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
    
    
    
    private boolean contains(E element) {
      if (this.isTerminal())
        return false;
      else if (element.equals(this.element))
        return true;
      else
        return this.next.contains(element);
    }   
    
    
    private void append( E element) {
      if (this.isTerminal()){
        this.element = element;
        this.next = new Node ();
      }
      else
        this.next.append(element); // Add to rest of list.      
    }
    
    private String toStringReverse() {
      if (isTerminal())
        return "|TERMINAL|";
      
      return next.toStringReverse() + "->" + element;
    }
    
    private int indexOf(E element){
     if (isTerminal())
       return -size() - 1;
     if (this.element.equals(element))
       return 0;
     
     return next.indexOf(element) + 1;
    }
    
  } //end class Node
}
