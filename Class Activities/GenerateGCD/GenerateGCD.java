class GenerateGCDIncomplete{

  private static int badGCDCount = 0;
  private static int goodGCDCount = 0;
  
  public static int badGCD(int a, int b){
    int min = Math.min(a,b);
    for(int i = min; i > 0; i--){
      badGCDCount++;
      if (a%i==0 && b%i==0) 
        return i;
    }
    return 1;
  }
  
  public static int goodGCDIterative(int a, int b){
    //COMPLETE ME USING A WHILE LOOP **********************************************************************************
    // remember to increment variable goodGCDCount properly
    
    while (b != 0) {
      goodGCDCount++;
      int tempA = a;
      a = b;
      b = tempA % b;
    }
    return a;
  }

  public static int goodGCDRecursive(int a, int b){
    //COMPLETE ME USING RECURCION ***********************************************************************************
    // remember to increment variable goodGCDCount properly
    //goodGCDCount++;
    if (b == 0)
      return a;
    return goodGCDRecursive(b, a%b);
  }
  
  
  public static void main(String args[]){
    badGCDCount= 0;
    System.out.println("badGCD Found GCD of GCD(11200,5500)           --- "+badGCD(11200,5500)+ 
                       " --- after " + badGCDCount + " comparisons");
    goodGCDCount= 0;
    System.out.println("goodGCDIterative Found GCD of GCD(11200,5500) --- "+goodGCDIterative(11200,5500)+ 
                       " --- after " + goodGCDCount + " comparisons");
    goodGCDCount= 0;
    System.out.println("goodGCDRecurive Found GCD of GCD(11200,5500)  --- "+goodGCDRecursive(11200,5500)+ 
                       " --- after " + goodGCDCount + " comparisons");
    
    badGCDCount= 0;
    System.out.println("badGCD Found GCD of GCD(11200,5501)           --- "+badGCD(11200,5501)+ 
                       " --- after " + badGCDCount + " comparisons");
    goodGCDCount= 0;
    System.out.println("goodGCDIterative Found GCD of GCD(11200,5501) --- "+goodGCDIterative(11200,5501)+ 
                       " --- after " + goodGCDCount + " comparisons");
    goodGCDCount= 0;
    System.out.println("goodGCDRecurive Found GCD of GCD(11200,5501)  --- "+goodGCDRecursive(11200,5501)+ 
                       " --- after " + goodGCDCount + " comparisons");
    
  }
  
  
  
  
  
  
} 
