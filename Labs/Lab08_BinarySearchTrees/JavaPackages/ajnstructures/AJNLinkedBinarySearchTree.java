/*
 * File: AJNLinkedbinarySearchTree.java
 */
package ajnstructures;

import java.util.*;
import zhstructures.*;

/**
 * Class implementing a ZHBinarySearchTree using an internal
 * one-way linked structure/node.
 * 
 * @author Andrew Nerud, Colin Glynn
 * @version November 9, 2022
 */
public class AJNLinkedBinarySearchTree<E extends Comparable<E>> implements ZHBinarySearchTree<E> {
  
  /**
   * Local field for the root of the binary search tree that is a BSTNode
   */
  private BSTNode root;
  
  /**
   * Local field to keep track of the size of the BST
   */
  private int size;
  
  /**
   * Default constructor for the BST that instantiates the local fields 
   */
  public AJNLinkedBinarySearchTree() {
    this.root = new BSTNode();
    this.size = 0;
  }
  
  /**
   * {@inheritDoc}
   */
  public boolean add(E element) {
    return this.root.add(element);
  }
  
  /**
   * {@inheritDoc}
   */
  public boolean contains(E element) {
    return this.root.contains(element);
  }
  
  /**
   * {@inheritDoc}
   */
  public E get(E element) {
    return this.root.get(element);
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
  public Iterator<E> iterator() {
    return this.root.iterator();
  }
  
  /**
   * {@inheritDoc}
   */
  public boolean remove(E element) {
    return this.root.remove(element);
  }
  
  /**
   * {@inheritDoc}
   */
  public int size() {
    return this.size;
  }
  
  /**
   * The inner node class for the binary search tree that extends ZHBinaryTreeNode
   */
  private class BSTNode extends ZHBinaryTreeNode<E, BSTNode> {
    
    /**
     * Default constructor for the BSTNode class that instantiates the local fields 
     */
    public BSTNode() {
      super();
    }
    
    /**
     * Second constructor for the BSTNode class that instantiates the local fields 
     * 
     * @param element an E of the value the BSTNode stores
     */
    public BSTNode(E element) {
      super(element);
    }
    
    /**
     * Third constructor for the BSTNode class that instantiates the local fields 
     * 
     * @param element an E of the value the BSTNode stores
     * @param leftChild a BSTNode that is the leftChild reference node
     * @param rightChild a BSTNode that is the rightChild reference node
     */
    public BSTNode(E element, BSTNode leftChild, BSTNode rightChild) {
      super(leftChild, element, rightChild);
    }
    
    /**
     * {@inheritDoc}
     */
    private boolean add(E element) {
      if (this.isEmpty()) {
        this.element = element;
        this.leftChild = new BSTNode();
        this.rightChild = new BSTNode();
        size++;
        return true;
      }
      
      int compared = this.element.compareTo(element);
      if (compared == 0)
        return false;
      else if (compared < 0)
        return this.rightChild.add(element);
      else
        return this.leftChild.add(element);
      
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(E element) {
      if (this.isEmpty())
        return false;
      
      int compared = this.element.compareTo(element);
      if (compared == 0)
        return true;
      else if (compared < 0)
        return this.rightChild.contains(element);
      else
        return this.leftChild.contains(element);
    }
    
    /**
     * {@inheritDoc}
     */
    private E get(E element) {
      if (this.isEmpty())
        return null;
      
      int compared = this.element.compareTo(element);
      if (compared == 0)
        return this.element;
      else if (compared < 0)
        return this.rightChild.get(element);
      else
        return this.leftChild.get(element);
    }
    
    /**
     * {@inheritDoc}
     */
    private boolean remove(E element) {
      if (this.isEmpty())
        return false;
      
      int compared = this.element.compareTo(element);
      if (compared == 0) {
        if (this.rightChild.isEmpty())
          this.copyNodeToThis(this.leftChild);
        else if (this.leftChild.isEmpty())
          this.copyNodeToThis(this.rightChild);
        else
          this.element = this.rightChild.removeAndReturnLeftmost();
        size--;
        return true;
      }
      else if (compared < 0)
        return this.rightChild.remove(element);
      else
        return this.leftChild.remove(element);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
      return this.inorderIterator();
    }
    
    
    /**
     * Replaces values of instance fields element, leftChild and rightChild in this node with those from
     * parameter otherNode.
     * @param otherNode the node from which values of instance variables are to be copied into this node.
     */
    private void copyNodeToThis(BSTNode otherNode) {
      this.element = otherNode.element;
      this.leftChild = otherNode.leftChild;
      this.rightChild = otherNode.rightChild;
    }
    
    /**
     * Removes and returns the leftmost element in this sub-tree.
     * @return the former leftmost element in this sub-tree.
     * @throws NoSuchElementException if this sub-tree is empty.
     */
    private E removeAndReturnLeftmost() {
      if (this.isEmpty()) {
        throw new NoSuchElementException(); 
      } 
      if (this.leftChild.isEmpty()) {
        E oldVal = this.element;
        this.copyNodeToThis(this.rightChild);
        return oldVal;
      } else {
        return this.leftChild.removeAndReturnLeftmost(); 
      }
    }
    
  }
}





