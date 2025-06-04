import java.util.*;
/*
 * **********************************************READ ME *************************************************************
 * PLEASE visit Java's HashMap documentation: https://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html
 * ************************************RERUN class after each exercise below******************************************
 */

/**FINAL EXPECTED OUTPUT:
   ---------------------

#1 *****************************************************************************************
Is map empty ? true
Map's size is  0
Map's contents {}

#2 *****************************************************************************************
Demonstrate 'put()' to add ('CSCI', 37)
Demonstrate 'put()' to add ('MATH', 8)
Demonstrate 'put()' to add ('ECON', 37)
Demonstrate 'put()' to add ('GBUS', 8)
Is map empty ? false
Map's size  is 4
Map's contents: expected={GBUS=8, CSCI=37, MATH=8, ECON=37} ... actual={GBUS=8, CSCI=37, MATH=8, ECON=37}

#3 *****************************************************************************************
Demonstrate 'put()' to modify ECON's Value to 22
Map's contents: expected={GBUS=8, CSCI=37, MATH=8, ECON=22} ... actual={GBUS=8, CSCI=37, MATH=8, ECON=22}

#4 *****************************************************************************************
Demonstrate 'get()' with ECON: 22
Demonstrate 'get()' with BIOL: null

#5 *****************************************************************************************
Demonstrate 'containsKey()' with ECON: true
Demonstrate 'containsKey()' with BIOL: true

#6 *****************************************************************************************
Demonstrate 'containsValue()' with 8: true
Demonstrate 'containsValue()' with 32: false

#7 *****************************************************************************************
Demonstrate 'remove()' for MATH
Demonstrate 'remove()' for BIOL
Is map empty ? false
Map's size  is 3
Map's contents: expected={GBUS=8, CSCI=37, ECON=22} ... actual={GBUS=8, CSCI=37, ECON=22}

#8 *****************************************************************************************
Demonstrate 'values()' to loop over values only
8  37  22  

#9 *****************************************************************************************
Demonstrate 'keySet()' to loop over keys & values 
(GBUS,8)
(CSCI,37)
(ECON,22)
********************************************************************************************* 
 */ 

public class SimpleMapExercise{
  
  public static void main( String[] args ){
    
    System.out.println("#1 *****************************************************************************************");
    //#1 COMPLETE ME: replace "null" with a proper constructor call
    HashMap<String,Integer> map = new HashMap<>(); 
    
    System.out.println( "Is map empty ? " + map.isEmpty() );
    System.out.println( "Map's size is  " + map.size() ); 
    System.out.println( "Map's contents " + map );
    
    
    System.out.println("#2 *****************************************************************************************");
    //#2 COMPLETE ME: call 'put' method to insert the (key, value) pairs shown in the print statements below
    System.out.println( "Demonstrate 'put()' to add ('CSCI', 37)");   
    map.put("CSCI", 37);
    System.out.println( "Demonstrate 'put()' to add ('MATH', 8)");   
    map.put("MATH", 8);
    System.out.println( "Demonstrate 'put()' to add ('ECON', 37)"); 
    map.put("ECON", 37);
    System.out.println( "Demonstrate 'put()' to add ('GBUS', 8)"); 
    map.put("GBUS", 8);
    
    System.out.println( "Is map empty ? " + map.isEmpty() );
    System.out.println( "Map's size  is " + map.size() );
    System.out.println( "Map's contents: expected={GBUS=8, CSCI=37, MATH=8, ECON=37} ... actual=" + map );   
    
    
    System.out.println("#3 *****************************************************************************************");
    //#3 COMPLETE ME: call 'put' method below to update ECON's entry to 22 
    System.out.println( "Demonstrate 'put()' to modify ECON's Value to 22" );
    map.put("ECON", 22);
    System.out.println( "Map's contents: expected={GBUS=8, CSCI=37, MATH=8, ECON=22} ... actual=" + map );   
    
    
    System.out.println("#4 *****************************************************************************************");
    //#4 COMPLETE ME: call 'get' method in place of "???" to find and display ECON's value; repeat for BIOL (which doesn't exist)
    System.out.println( "Demonstrate 'get()' with ECON: " + map.get("ECON"));
    System.out.println( "Demonstrate 'get()' with BIOL: " + map.get("BIOL")); 

    
    
    System.out.println("#5 *****************************************************************************************");
    //#5 COMPLETE ME: call 'containsKey' method in place of "???" to display if ECON is a valid key; repeat for BIOL
    System.out.println( "Demonstrate 'containsKey()' with ECON: " + map.containsKey("ECON"));

    System.out.println( "Demonstrate 'containsKey()' with BIOL: " + map.containsKey("BIOL"));

    
    
    System.out.println("#6 *****************************************************************************************");
    //#6 COMPLETE ME: call 'containsValue' method in place of "???" to display if 8 is a valid value; repeat for 32
    System.out.println( "Demonstrate 'containsValue()' with 8: " + map.containsValue(8));

    System.out.println( "Demonstrate 'containsValue()' with 32: " + map.containsValue(32));

    
    
    System.out.println("#7 *****************************************************************************************");
    //#7 COMPLETE ME: call 'remove' method to remove MATH; repeat for BIOL
    System.out.println( "Demonstrate 'remove()' for MATH" );
    System.out.println(map.remove("MATH"));
    System.out.println( "Demonstrate 'remove()' for BIOL" );
    System.out.println(map.remove("BIOL"));
    
    System.out.println( "Is map empty ? " + map.isEmpty() );
    System.out.println( "Map's size  is " + map.size() );
    System.out.println( "Map's contents " + map );
    System.out.println( "Map's contents: expected={GBUS=8, CSCI=37, ECON=22} ... actual=" + map );       
    
    
    System.out.println("#8 *****************************************************************************************");
    System.out.println( "Demonstrate 'values()' to loop over values only" );
    //#8 COMPLETE ME: replace 'null' with a call to the map's 'values' method
    Collection<Integer> valueset = map.values(); 
    
    //   COMPLETE ME: complete loop below to print all values in map 
    for(Integer s: valueset)
      System.out.print( s + "  " );
    
    System.out.println();    
    
    
    System.out.println("#9 *****************************************************************************************");
    System.out.println( "Demonstrate 'keySet()' to loop over keys & values " );
    //#9 COMPLETE ME: replace 'null' with a call to the map's 'keySet' method
    Set<String> keys = map.keySet(); //????
    
    //COMPLETE ME: complete below to loop over keys and display all (key,value) pairs 
    for(String k: keys)
      System.out.println( "("+k + "," + map.get(k)+")" );
    
    System.out.println("*****************************************************************************************************");
  }
}

