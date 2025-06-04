import java.util.*;
import java.io.*;
import mydatastructures.*;

public class GraphDriver{
  
  public static void displayGraphInfo(Graph g){
    System.out.println("Graph g has " + g.getNumV() + " vertices");
    System.out.println("Is graph directed?  " + g.isDirected());
    System.out.println("Show all edges:");
    for(int v = 0; v<g.getNumV();v++){
      Iterator<Edge> edges = g.getEdgeIterator(v);
      if (edges!=null){
        while(edges.hasNext())
          System.out.println(edges.next());
      }
      else{
        System.out.println("DUDE! Complete me before printing");
      }
    }
    System.out.println();
    System.out.println("is there an edge (0,3)? " + g.isEdge(0,3)) ;
    System.out.println("Test: g.getEdge(0,3):"+g.getEdge(0,3));
    System.out.println("is there an edge (0,5)? " + g.isEdge(0,5)) ;
    System.out.println("Test: g.getEdge(0,5):"+g.getEdge(0,5));
    System.out.println("is there an edge (5,0)? " + g.isEdge(5,0)) ;
    System.out.println("Test: g.getEdge(5,0):"+g.getEdge(5,0));     
    System.out.println();
    g.insert(new Edge(0,5,9.4));
    System.out.println("After insertion: g.insert(new Edge(0,5,9.4))");
    System.out.println("is there an edge (0,3)? " + g.isEdge(0,3)) ;
    System.out.println("Test: g.getEdge(0,3):"+g.getEdge(0,3));
    System.out.println("is there an edge (0,5)? " + g.isEdge(0,5)) ;
    System.out.println("Test: g.getEdge(0,5):"+g.getEdge(0,5));
    System.out.println("is there an edge (5,0)? " + g.isEdge(5,0)) ;
    System.out.println("Test: g.getEdge(5,0):"+g.getEdge(5,0));    
    System.out.println();
    g.insert(new Edge(0,5,10.4));   
    System.out.println("After insertion: g.insert(new Edge(0,5,10.4))");
    System.out.println("is there an edge (0,5)? " + g.isEdge(0,5)) ;
    System.out.println("Test: g.getEdge(0,5):"+g.getEdge(0,5));
    System.out.println("is there an edge (5,0)? " + g.isEdge(5,0)) ;
    System.out.println("Test: g.getEdge(5,0):"+g.getEdge(5,0));      
    System.out.println();
  }
  
  public static void main(String[] args){
    System.out.println("*********************************** Weighted, Undirected ");
    Graph g = new MapGraph("datafileWeighted",false);
    GraphDriver.displayGraphInfo(g); 
    System.out.println("\n");
    System.out.println("*********************************** Weighted, Directed  ");    
    g = new MapGraph("datafileWeighted",true);
    GraphDriver.displayGraphInfo(g); 
    System.out.println("\n");
    System.out.println("*********************************** Unweighted, Undirected ");    
    g = new MapGraph("datafileUnweighted",false);
    GraphDriver.displayGraphInfo(g); 
    System.out.println("\n");
    System.out.println("*********************************** Unweighted, Directed ");    
    g = new MapGraph("datafileUnweighted",true);            
    GraphDriver.displayGraphInfo(g); 
  }
  
}