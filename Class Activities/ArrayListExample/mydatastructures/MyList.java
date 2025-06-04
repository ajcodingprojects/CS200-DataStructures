package mydatastructures;
/** 
 * This class implements some of the methods of the Java ArrayList class
 * 
 * @author I Rahal
 * @verion 2022
 */

public interface MyList < ExpectedType >{
  /** 
   * Appends the specified element to the end of this list
   *
   * @param anEtry - The new value to append to the end
   * @return true indicating success
   */
  public boolean add(ExpectedType anEntry);
  
  /** 
   * Get a value in the list based on its index provided 
   *     index is >= 0 and < size
   * 
   * @param index - The index of the desired element
   * @return The contents of the List at that index
   * @throws IndexOutOfBoundsException if index is out of bounds
   */
  public ExpectedType get(int index);
  
  /** 
   * Set the value in the List based on its index provided 
   *     index is >= 0 and < size
   * 
   * @param index - The index of the item desired
   * @param newValue - The new value to store at this position
   * @return The old value at this position
   * @throws IndexOutOfBoundsException if index is out of bounds
   */
  public ExpectedType set(int index, ExpectedType newValue) ;
  
  /** 
   * Get the current size of the List
   * 
   * @return The current size of the List
   */
  public int size() ;

  /** 
   * Remove an entry based on its index provided 
   *     index is >= 0 and < size. No gaps allowed.
   * 
   * @param index - The index of the entry to be removed
   * @return The value removed
   * @throws IndexOutOfBoundsException if index is out of bounds
   */
  public ExpectedType remove(int index) ;
  
  /** 
   * Add an entry to the list by inserting it at the specified index 
   *       provided index is >= 0 and ***<=*** size. Existing Elements 
   *       may need to shift to make room. No gaps allowed.
   * 
   * @param index - The location of the inserted item (between 0 and  
   *      size inclusive)
   * @param theValue - The value to be inserted
   * @return true indicating success
   * @throws IndexOutOfBoundsException if index is out of bounds
   */
  public boolean add(int index,ExpectedType anEntry);
}
