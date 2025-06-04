package mydatastructures;
/** 
 * Class for a binary search tree that stores type E objects.
 *   @author Imad Rahal
 * 
 */

public interface BSTInterface < E extends Comparable<E> > {
  
  public String toString() ;
  
  public boolean add(E element);
  
  public void rotateLeft();
  
  public void rotateRight();
 
}
