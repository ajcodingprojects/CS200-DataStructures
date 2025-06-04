
public class RecursiveMethods {
  
  public static int length(String str) {
    if (str == null || str.equals("")){
      return 0;
    }
    else{
      return 1 + length(str.substring(1));
    }
  }
    
  public static void printChars(String str) {
    if (str == null || str.equals("")) {
      return;
    }
    else {
      System.out.println(str.charAt(0));
      printChars(str.substring(1));
    }
  }
  
  public static void printCharsReverse(String str) {
    if (str == null || str.equals("")) {
      return;
    }
    else {
      printCharsReverse(str.substring(1));
      System.out.println(str.charAt(0));
    }    
  }
  
  public static int factorial(int n) {
    if (n == 1){
      return 1;
    }
    else{
      return n * factorial(n - 1);
    }
  }
  
  public static int fibonacci(int n) {
    if (n < 2){
      return 1;
    }
    else{
      return fibonacci(n - 1) + fibonacci(n - 2);
    }
  }
  
  public static int iterativeLinearSearch(int[] items,int target, int startingAt) {   
    for (int pos = startingAt; pos < items.length; pos++){
      if (items[pos] == target){
        return pos;
      }
    }   
    return -1;
  }
  
  public static int recursiveLinearSearch(int[] items, int target, int startingAt){
//***********COMPLETE ME*******************************************************************************      

    // STUDY iterative version above
    // for unsuccessful search ==> return -1; 
    // for successful search ==> return array location of match (i.e. position in array) 
    if (null == items || startingAt >= items.length)
      return -1;
    else
      return items[startingAt] == target ? startingAt : recursiveLinearSearch(items, target, startingAt + 1);
  }
  
  public static int iterativeBinarySearch(int[] items,int target, int startingAt, int endingAt) {
    while (startingAt <= endingAt){
      int middle = (startingAt + endingAt) / 2;
      if (target==items[middle]){
        return middle; 
      }
      else if (target<items[middle]){
        endingAt = middle - 1;        
      }
      else{
        startingAt = middle + 1; 
      }
    }     
    return -1;
  }  

  
  public static int recursiveBinarySearch(int[] items, int target, int startingAt, int endingAt) {
//***********COMPLETE ME*******************************************************************************      
    
    // STUDY iterative version above
    // What is the base case for an unsuccessful search? return -1
    // What is the base case for a successful search? return location of match
    
    if (null == items || startingAt > endingAt)
      return -1;
    else {
      int middle = (startingAt + endingAt)/2;
      if (target==items[middle]){
        return middle; 
      }
      else if (target<items[middle]){
        return recursiveBinarySearch(items, target, startingAt, middle -1);        
      }
      else{
        return recursiveBinarySearch(items, target, middle +1, endingAt); 
      }
    }
  }
  
  public static void main(String[] args){
    //String examples
    System.out.println("length of CSCI200 : " + RecursiveMethods.length("CSCI162"));
    System.out.println("characters in CSCI200 : ");
    RecursiveMethods.printChars("CSCI200");    
    System.out.println("reverse of CSCI200 : ");
    RecursiveMethods.printCharsReverse("CSCI200");
    
    //math examples
    System.out.println("factorial of 5 : " + RecursiveMethods.factorial(5));
    System.out.println("fibonacci of 8 : " + RecursiveMethods.fibonacci(8));  
    System.out.println();
    //searching examples
    int[] arr = {0,10,20,30,40,50,60,70};
    System.out.println("Iterative linear search: 60 in {0,10,20,30,40,50,60,70} ? : " + RecursiveMethods.iterativeLinearSearch(arr,60,0));
    System.out.println("Iterative linear search: 80 in {0,10,20,30,40,50,60,70} ? : " + RecursiveMethods.iterativeLinearSearch(arr,80,0));
    System.out.println();
    System.out.println("Recursive linear search: 60 in {0,10,20,30,40,50,60,70} ? : " + RecursiveMethods.recursiveLinearSearch(arr,60,0));
    System.out.println("Recursive linear search: 80 in {0,10,20,30,40,50,60,70} ? : " + RecursiveMethods.recursiveLinearSearch(arr,80,0));
    System.out.println();
    System.out.println("Iterative binary search: 60 in {0,10,20,30,40,50,60,70} ? : " + RecursiveMethods.iterativeBinarySearch(arr,60,0,arr.length-1));
    System.out.println("Iterative binary search: 80 in {0,10,20,30,40,50,60,70} ? : " + RecursiveMethods.iterativeBinarySearch(arr,80,0,arr.length-1));
    System.out.println("Iterative binary search: 70 in {0,10,20,30,40,50,60,70} ? : " + RecursiveMethods.iterativeBinarySearch(arr,70,0,arr.length-1));
    System.out.println();
    System.out.println("Recursive binary search: 60 in {0,10,20,30,40,50,60,70} ? : " + RecursiveMethods.recursiveBinarySearch(arr,60,0,arr.length-1));
    System.out.println("Recursive binary search: 80 in {0,10,20,30,40,50,60,70} ? : " + RecursiveMethods.recursiveBinarySearch(arr,80,0,arr.length-1));
    System.out.println("Recursive binary search: 70 in {0,10,20,30,40,50,60,70} ? : " + RecursiveMethods.recursiveBinarySearch(arr,70,0,arr.length-1));    
    System.out.println();    
  }  
}
