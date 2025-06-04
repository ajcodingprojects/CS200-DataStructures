/** An interface for HashMap
 *  @author Koffman, Wolfgang & Rahal
 */
package mydatastructures;
import java.util.*;

public interface MyHashMap <K, V> {
  //Already complete
  public int size();
  public boolean isEmpty();
  public Set<K> keySet();  
  public String toString();
 
  //ToDo
  public V put(K key, V value);
  public V remove(K key);
  public V get(K key);    
  public boolean containsValue(V value);
  public boolean containsKey(K key);
}
