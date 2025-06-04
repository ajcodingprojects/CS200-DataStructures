package mystructures;
public interface SimpleList <E>  extends Iterable<E> {
  public int size() ;
  public String toString();
  public void append(E inElement);
  public E get(int index);
}