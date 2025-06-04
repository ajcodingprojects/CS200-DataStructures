package mydatastructures;

public class BinarySearchTreesWithRotations < E extends Comparable <E> > implements BSTInterface <E>{  
  protected BSTNode root;
  
  public BinarySearchTreesWithRotations() {
    this.root = new BSTNode();
  }
  
  public BinarySearchTreesWithRotations(BSTNode root) {
    this.root = root;
  }
  
  public boolean add(E element) {
    return this.add(element, this.root);
  }
  
  private boolean add(E element, BSTNode current){
    if (current.isTerminal()){
      current.element = element;
      current.left = new BSTNode();
      current.right = new BSTNode();
      return true;
    }
    int comp = current.element.compareTo(element);
    if(comp>0){
      //System.out.println("WENT LEFT");
      return this.add(element,current.left);}
    else if(comp<0){
      //System.out.println("WENT RIGHT");
      return this.add(element,current.right);
    }
    else{
      //System.out.println("DUPLICATE");
      return false;
    }
  }
  
  
  public String toString() {
    return this.toString(0, this.root);
  }
  private String toString(int depth, BSTNode current){
    //indent tree nodes properly to look like a tree
    String result = "";
    for (int i = 0; i <= depth; i++) {
      result +=("> ");
    }
    if (current.isTerminal())
      return result + "X \n";
    else 
      return result + current.element + "\n" + this.toString(depth+1,current.left)+ this.toString(depth+1,current.right);
  }    
  

  //No rotations should happen if root doesn't have a right child
  // this method is not recursive since we are ONLY rotating at the root in
  // this exercise
  public void rotateLeft() {
    //COMPLETE ME **********************************************************
    if (this.root.isTerminal() || this.root.right.isTerminal())
      return;
    BSTNode oldRight = this.root.right;
    this.root.right = oldRight.left;
    oldRight.left = this.root;
    this.root = oldRight;
  }
  
  
  //No rotations should happen if root doesn't have a left child
  // this method is not recursive since we are ONLY rotating at the root in
  // this exercise
  public void rotateRight() {
    //COMPLETE ME **********************************************************
    if (this.root.isTerminal() || this.root.left.isTerminal())
      return;
    BSTNode oldLeft = this.root.left;
    this.root.left = oldLeft.right;
    oldLeft.right = this.root;
    this.root = oldLeft;
  }   
  
  /** Class to encapsulate a BST node. */
  private  class BSTNode{
    
    /** The information stored in this node. */
    private E element;
    
    /** Reference to the left child. */
    private BSTNode left;
    
    /** Reference to the right child. */
    private BSTNode right;
    
    private BSTNode() {
    }
    
    private BSTNode(E element) {
      this.element = element;
    }
    
    private BSTNode(E element, BSTNode  left, BSTNode  right){
      this.element = element;
      this.left = left;
      this.right = right;
    }
    
    private boolean isTerminal(){
      return this.element == null && this.left == null && this.right == null;
    }  
  }  
}