public class BinaryToDecimal {
  
  /*PROBLEM 1*/
  //user-friendly version is COMPLETE
  public static int convertUnsigned(String binaryStr) {
    return convertUnsigned(binaryStr,0);
  }
  
  //recusive version, with extra params, is incomplete
  public static int convertUnsigned(String binary, int index) {
    /*
     * for binary string "1110011":
     * "1110011" = 1*2^6 + 1*2^5 + 1*2^4 + 0*2^3 + 0*2^2 + 1*2^1 + 1*2^0
     *           = 64 + 32 + 16 + 0 + 0 + 2 + 1 
     *           = 115 
     * 
     * base case:
     *     depends on both, string and index
     *     0 is returned
     *
     * general case: 
     *     here is an example "101": you should add 2^2 (for the leftmost 1) 
     *     to whatever results from recursively calling the method on the 
     *     rest of the binary string, "01"
     */    
    if (binary == null || index >= binary.length()){
     return 0;
    } else {
      final int realExp = binary.length()-index-1;
      final int powerOfTwo = (int)Math.pow(2, realExp);
      System.out.println("Val: " + powerOfTwo + "\t| Char: " + binary.charAt(index));
      return Character.getNumericValue(binary.charAt(index)) * powerOfTwo + convertUnsigned(binary, index+1);
    }
  }
  
  /*PROBLEM 2*/
  //user-friendly version is COMPLETE  
  public static int convertSigned(String binaryStr) {
    return convertSigned(binaryStr,0);
  }
  
  //recusive version, with extra params, is incomplete
  public static int convertSigned(String binary, int index) {
    /*
     * very similar to above but leftmost digit should be negated
     * "1110011" = -1*2^6 + 1*2^5 + 1*2^4 + 0*2^3 + 0*2^2 + 1*2^1 + 1*2^0
     *           = -64 + 32 + 16 + 0 + 0 + 2 + 1 
     *           = -13 
     */      
    if (binary == null || index >= binary.length()){
     return 0;
    } else {
      final int realExp = binary.length()-index-1;
      final int powerOfTwo = (int)Math.pow(2, realExp);
      System.out.println("Num Value: " + powerOfTwo + "\t| Char: " + binary.charAt(index));
      return (index == 0 ? -1 : 1) * Character.getNumericValue(binary.charAt(index)) * powerOfTwo + convertSigned(binary, index+1);
    }
  }  
  
  
  public static void main(String args[]){
//    String binaryNum = "1110011";
//    System.out.println("For Unsigned, Expected: " +Integer.parseInt(binaryNum,2) + " and Actual: " + convertUnsigned(binaryNum));
//    System.out.println(" --- ");
//    StringBuilder onesComplementBuilder = new StringBuilder();
//    for(char bit : binaryNum.toCharArray()) {
//      onesComplementBuilder.append((bit == '0') ? 1 : 0);
//    }
//    String onesComplement = onesComplementBuilder.toString();
//    int converted = Integer.valueOf(onesComplement, 2);
//    int value = -(converted + 1);    
//    System.out.println("For Signed, Expected: " + value + " and Actual: " + convertSigned(binaryNum));
//    System.out.println(" --- ");
    
    String[] numbers = {"1110011", "10001110", "11111111", "10100010", "10101010101", "0", "1"};
    for(String binaryNum : numbers) {
      System.out.println("For Binary: " + binaryNum + "\n----");
      System.out.println("For Unsigned, Expected: " +Integer.parseInt(binaryNum,2) + " and Actual: " + convertUnsigned(binaryNum));
      System.out.println(" --- ");
      StringBuilder onesComplementBuilder = new StringBuilder();
      for(char bit : binaryNum.toCharArray()) {
        onesComplementBuilder.append((bit == '0') ? 1 : 0);
      }
      String onesComplement = onesComplementBuilder.toString();
      int converted = Integer.valueOf(onesComplement, 2);
      int value = -(converted + 1);    
      System.out.println("For Signed, Expected: " + value + " and Actual: " + convertSigned(binaryNum));
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ");
    }
  }
}
