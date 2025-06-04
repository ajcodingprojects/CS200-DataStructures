package mystructures;

public interface SimpleList <E> {
  //already implemented
  public int size() ;
  public String toString();
  public boolean contains(E element);
  public void append(E inElement);

  //******************************* ADDITIONAL METHODS TO COMPLETE *************************
  /**
   * This method is recursive
   * 
   * Finds and removes the first element with a value equal to parameter outElement and returns 
   * true if such an element exists. Otherwise, false is returned. 
   * 
   * @param outElement the element to remove from list
   * @return true if parameter outData exists in the list and has been removed. 
   *               Otherwise, false is returned. 
   */ 
  public boolean remove(E outElement);
  
  /**
   * This method is recursive
   * 
   * Finds and returns the element at the specified index if such an index is valid 
   * (i.e., between 0 and size-1); an exception is thrown otherwise
   * 
   * Pre: index should be in the range of [0, size-1], inclusive
   * @param index the location in the list of the element to return
   * @return the element at specified index if such an index is valid 
   *         (i.e., between 0 and size-1); an exception is thrown otherwise
   * @throws IndexOutOfBoundsException of pre condition is false
   */   
  public E get(int index);
   
  /**
   * This method is recursive
   * 
   * Returns the index (starting from 0) of the first node containing parameter element 
   * if it exists in the list. Otherwise, -1 is returned. 
   * 
   * @param element the element to search for
   * @return int the index (starting from 0) of the node containing parameter element 
   *         if it exists in the list. Otherwise, -1 is returned..
   */ 
  public int indexOf(E element);
  
  /**
   * This method is NOT recursive
   * 
   * appends all the elements stored in the parameter list to the end of this list; 
   * use methods size() & get() to complete this method
   * @param otherList the list to append to the end of this list.
   */ 
  public void appendAll(SimpleList<E> otherList);
  
  /**
   * This method is recursive
   * 
   * Returns a string containing the contents of this list in reverse order, 
   * separated by single space: E.g., for list 1-->2-->3-->|TERMINAL|, it should return 
   * 3 2 1
   * @return String containing the contents of the list in reverse orderse.
   */
  public String toStringReverse();

  /**
   * This method is NOT recursive
   * 
   * An accessor method which returns true if all the elements in specified 
   * parameter potentialisSubList exist in this list (i.e. checks if 
   * potentialisSubList is a sub-list of this list); false is returned otherwise.
   *
   * Post: this list and parameter potentialisSubList should not be 
   *       modified after the execution of this method.
   * 
   * @param potentialSubList the list to check whether it is a sub-list of 
   *        this list or not.
   * @return boolean true if parameter potentialisSubList is a sub-list of 
   *         this set; false otherwise.
   */
  public boolean isSubList(SimpleList<E> potentialSubList); 
}