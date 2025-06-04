/*
 * File MyQueue.java
 */

package mystructures;

import java.util.*;
/**
 * Interface for a queue class.
 * 
 * @author I. Rahal
 * @version September 15, 2022
 */
public interface MyQueue<ElementType> extends MyCollection<ElementType> {
 
 /**
  * Returns the first element in the queue without removing it.
  * 
  * @return the first element in the queue
  * @throws NoSuchElementException if this queue is empty
  */
 public ElementType peek();
 
 /**
  * Removes and returns the first element in this queue.
  * 
  * @return the first element in this queue
  * @throws NoSuchElementException if this queue is empty
  */
 public ElementType dequeue();
 
 /**
  * Adds a new element to the back of this queue.
  * 
  * @param element the element to be added
  */
 public void enqueue(ElementType element);

}
