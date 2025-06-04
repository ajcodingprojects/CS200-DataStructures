
import mydatastructures.*;

public class BinaryTreeDriver {
  
  public static void main(String args[]) {
    BSTInterface<Integer> bst = new BinarySearchTreesWithRotations<Integer>();
    System.out.println("bst.add(12) : " + bst.add(12));
    System.out.println("bst.add(17) : " + bst.add(17));
    System.out.println("bst.add(25) : " + bst.add(25));
    System.out.println("bst.add( 9) : " + bst.add(9));
    System.out.println("bst.add( 8) : " + bst.add(8));    
    System.out.println("bst.add(11) : " + bst.add(11));  
    System.out.println("bst.add(10) : " + bst.add(10));
    System.out.println(); 
    System.out.println("*********************************************************************************");
    System.out.println("Tree before rotations:");
    System.out.println(bst);  
    System.out.println("Tree after a right rotation on root:");
    bst.rotateRight();
    System.out.println(bst);   
    System.out.println("Tree after a second right rotation on root:");
    bst.rotateRight();
    System.out.println(bst);     
    System.out.println("Tree after a third right rotation on root ... no change:");
    bst.rotateRight();
    System.out.println(bst);     
    System.out.println("Tree after a left rotation on root:");
    bst.rotateLeft();
    System.out.println(bst);   
    System.out.println("Tree after a second left rotation on root ... restores original tree:");
    bst.rotateLeft();
    System.out.println(bst);     
    System.out.println("Tree after a third left rotation on root:");
    bst.rotateLeft();
    System.out.println(bst);    
    System.out.println("Tree after a fourth left rotation on root:");
    bst.rotateLeft();
    System.out.println(bst);     
    System.out.println("Tree after a fifth left rotation on root ... no change:");
    bst.rotateLeft();
    System.out.println(bst);     
    System.out.println("*********************************************************************************");
  }
}