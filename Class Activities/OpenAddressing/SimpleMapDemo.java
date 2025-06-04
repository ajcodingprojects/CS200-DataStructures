import java.util.*;
import mydatastructures.*;

public class SimpleMapDemo
{
  public static void main( String[] args ){
    System.out.println("#1 **************************************************************************************************");
    MyHashMap<String,Integer> map = new MyHashtableOpen<String,Integer>();   
    
    System.out.println( "Is map empty ? " + map.isEmpty() );
    System.out.println( "Map's size is  " + map.size() ); 
    System.out.println( "Map's contents " + map );
    
    System.out.println("#2 **************************************************************************************************");
    System.out.println( "Demonstrate put(\"CSCI\", 37) for a new entry: " + map.put("CSCI", 37));   
    System.out.println( "Demonstrate put(\"MATH\",  8) for a new entry: " + map.put("MATH", 8));   
    System.out.println( "Demonstrate put(\"ECON\", 37) for a new entry: " + map.put("ECON", 37)); 
    System.out.println( "Demonstrate put(\"GBUS\",  8) for a new entry: " + map.put("GBUS", 8)); 
    
    System.out.println( "Is map empty ? " + map.isEmpty() );
    System.out.println( "Map's size  is " + map.size() );
    System.out.println( "Map's contents " + map );
    
    System.out.println("#3 **************************************************************************************************");
    System.out.println( "Demonstrate put(\"ECON\", 22) to modify ECON's Value from 37 to 22: " + map.put("ECON", 22));
    System.out.println( "Map's contents " + map );
    
    System.out.println("#4 **************************************************************************************************");
    System.out.println( "Demonstrate get(\"ECON\"): " + map.get("ECON"));
    System.out.println( "Demonstrate get(\"BIOL\"): " + map.get("BIOL"));    
    
    System.out.println("#5 **************************************************************************************************");
    System.out.println( "Demonstrate containsKey(\"ECON\"): " + map.containsKey("ECON"));
    System.out.println( "Demonstrate containsKey(\"BIOL\"): " + map.containsKey("BIOL")); 
    
    System.out.println("#6 **************************************************************************************************");
    System.out.println( "Demonstrate containsValue( 8): " + map.containsValue(8));
    System.out.println( "Demonstrate containsValue(31): " + map.containsValue(32));
    
    System.out.println("#7 **************************************************************************************************");
    System.out.println( "Map's contents " + map );
    System.out.println( "Demonstrate remove(\"MATH\"): " + map.remove("MATH"));
    System.out.println( "Demonstrate remove(\"BIOL\"): " + map.remove("BIOL") );
    
    System.out.println( "Is map empty ? " + map.isEmpty() );
    System.out.println( "Map's size  is " + map.size() );
    System.out.println( "Map's contents " + map );
      
    System.out.println("#8 *************************************************************************************************");
    System.out.println( "Demonstrate 'keySet()' to loop over keys & values " );
    Set<String> keys =map.keySet();
    System.out.print( "{");
    for(String k: keys)
      System.out.print( "("+k + "," + map.get(k)+") " );
    System.out.println( "}");
    System.out.println("*****************************************************************************************************");
  }
}

