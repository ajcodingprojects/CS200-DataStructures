package mydatastructures;
/** 
 * Class for a binary tree that stores type E objects.
 * @author Imad Rahal
 */

public interface BSTInterface <E extends Comparable<E>> {

  public boolean contains(E element);   
  
  public boolean add(E newElement);
  
  public String inOrderTraverse() ;  
  
  public String preOrderTraverse() ;

  public String postOrderTraverse();
    
  public String toString() ;
  
}
