/*
 * File: AJNSet.java
 */

package ajnstructures;

import java.util.Iterator;
import java.io.*;
import zhstructures.*;
import java.util.*;
import java.util.stream.*;


/**
 * A collection that contains no duplicate elements.As implied by its name, this 
 * interface models the mathematical set abstraction.
 * 
 * Unlike the Java Set interface, this version directly supports set
 * intersection, difference and union methods, and these methods generate
 * a new set without modifying either operand.
 * 
 * Please note that Interface ZHCollection already extends Serializable 
 * 
 * @author Andrew Nerud and Grant Peroutka
 * @version September 21, 2022
 */
public class AJNArraySet<ElementType> implements AJNSet<ElementType> {
  
  /**
   * List to keep track of the data
   */
  private ElementType[] elements;
  
  /**
   * Default length variable for constructor with no param
   */
  public static final int DEFAULT_INIT_LENGTH = 512;
  
  /**
   * current length of the list elements
   */
  private int size;
  
  /**
   * The default constructor for the class
   *    initializes the elements to a new list
   *    sets size to zero
   */
  public AJNArraySet() {
   elements = (ElementType[]) new Object[DEFAULT_INIT_LENGTH];
   size = 0;
  }
  
  /**
   * The second constructor for the class
   *    initializes the elements to a new list
   *    sets size to zero
   * 
   * @param initLength an int to set the initial length of the elements list
   * 
   * @thows IllegalArgumentException if the initLength is < 0
   */
  public AJNArraySet(int initLength) {
    if (initLength <= 0)
      throw new IllegalArgumentException("Invalid starting length");
    elements = (ElementType[]) new Object[initLength];
    size = 0;
  }
  
  /**
   * {@inheritDoc}
   */
  public boolean add(ElementType element) {
    if (size == elements.length) {
      reallocate();
    }
    
    if (this.contains(element)) return false;

    elements[size++] = element; 
    
    return true;
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
    for (ElementType e : this) {
      if (e.equals(element))
            return true;
    }
    return false;
  }
  
  /**
   * {@inheritDoc}
   */
  public boolean remove(ElementType element) {
    int index = find(element);
    if (index < 0) return false;
    
    elements[index] = elements[--size];
    
    return true;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public Iterator<ElementType> iterator() {
    return new ArraySetIterator();
  }
    
  /**
   * {@inheritDoc}
   */
  public AJNSet<ElementType> intersection(AJNSet<ElementType> otherSet) {
    AJNSet<ElementType> result = new AJNArraySet<>();
    for (ElementType e : this){
      if( otherSet.contains(e))
           result.add(e);
    }

    return result;
  }
  
  /**
   * {@inheritDoc}
   */
  public AJNSet<ElementType> difference(AJNSet<ElementType> otherSet) {
    AJNSet<ElementType> result = new AJNArraySet<>();
    for (ElementType e : this){
      if( !otherSet.contains(e))
           result.add(e);
    }

    return result;
  }
  
  /**
   * {@inheritDoc}
   */
  public AJNSet<ElementType> union(AJNSet<ElementType> otherSet) {
    AJNSet<ElementType> result = new AJNArraySet<>();
    for (ElementType e : this){
           result.add(e);
    }
    for (ElementType e : otherSet){
           result.add(e);
    }

    return result;
  }
  
  /**
   * {@inheritDoc}
   */
  public boolean subset(AJNSet<ElementType> potentialSubset) {
    AJNSet<ElementType> result = new AJNArraySet<>();
    for (ElementType e : potentialSubset){
     if ( !this.contains(e))
       return false;
    }
    return true;
  }
  
  /** 
   * Allocate a new array to hold the directory
   */
  private void reallocate() {
    ElementType[] newElements = (ElementType[]) new Object[elements.length * 2];
    System.arraycopy(elements, 0, newElements, 0, size);
    elements = newElements;
  }  
  
  private int find(ElementType element) {
    for (int i = 0; i < size; i++) {
      if (elements[i].equals(element))
            return i;
    }
    return -1;
  }
  
  /**
   * Implementing a class for iterator to work
   */
  private  class ArraySetIterator implements Iterator<ElementType>{
    /** position used to traverse elements in the collection*/    
    private int position;
    
    /**
     * Constructor initializes currentPosition to 0
     */
    public ArraySetIterator(){
      this.position = 0;
    }
    
    /**
     * {@inheritDoc}
     */     
    public boolean hasNext(){    
      return this.position < size;
    }
    
    /**
     * {@inheritDoc}
     */    
    public ElementType next(){
      if(!hasNext()){
        throw new NoSuchElementException();
      }
      return elements[this.position++];
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