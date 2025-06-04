package mydatastructures;
import java.util.*;
import java.io.*;


/** 
 * A graph is a Map of vertices (keys) and a set of edges (values). Vertices 
 * are represented by integers from 0 to n - 1. Edges are ordered pairs of vertices.
 */

public class MapGraph implements Graph {
  
  // Data Field
  
  /** The number of vertices */
  private int numV;
  
  /** Flag to indicate whether this is a directed graph */
  private boolean directed;
  
  /** A map to contain the edges that originate with each vertex. */
  private Map<Integer,Set<Edge>> edges;
  
  /** Construct a graph with the specified number of vertices and directionality.
    * @param numV The number of vertices
    * @param directed The directionality flag
    */
  public MapGraph(int numV, boolean directed) {
    this.numV = numV;
    this.directed = directed;
    this.edges = new HashMap<Integer,Set<Edge>>();
  }
  
  /** 
   * Construct a graph and load the data from an input file. The first line  
   * of the input file should contain the number of vertices, followed by
   * a series of lines, each line with two or three data values. The first 
   * is the source, the second is the destination, and the optional third is 
   * the weight.
   * @param fileName The file to read data from
   * @param directed true if this is a directed graph, false otherwise
   */
  public MapGraph(String fileName, boolean directed) {
    try{
      Scanner fileSC = new Scanner(new File(fileName));    
      String line = fileSC.nextLine(); // first line is number of vertices
      this.numV = Integer.parseInt(line);
      this.directed = directed;
      this.edges = new HashMap<Integer,Set<Edge>>();
      
      while (fileSC.hasNextLine()){
        line = fileSC.nextLine();
        Scanner lineSC = new Scanner(line);
        int source = lineSC.nextInt();
        int dest = lineSC.nextInt();
        double weight = 1.0;
        if (lineSC.hasNextDouble()){
          weight = lineSC.nextDouble();
        }
        insert(new Edge(source, dest, weight));
        lineSC.close();
      }
      fileSC.close();
    }    
    catch(IOException ioe){
      return;
    }    
    
  }
  
  /** 
   *  {@inheritdoc}
   */
  public int getNumV() {
    return this.numV;
  }
  
  /** 
   * {@inheritdoc}
   */
  public boolean isDirected() {
    return this.directed;
  }
  
  /**
   * {@inheritdoc}
   */
  public boolean isEdge(int source, int dest) {
    Set<Edge> connections = this.edges.get(source);
    if (connections!=null){
      return this.edges.get(source).contains(new Edge(source, dest));
    } else {
      return false;
    }
  }
  
  
  /** Insert a new edge into the graph.
    * @param edge The new edge
    */
  public void insert(Edge edge) {
    //COMPLETE ME **********************************************************************************   
    /*
     * first: use isEdge to check if a similar edge already exists from the "edge"'s source to destination, 
     *         if so, remove existing edge
     *         for an undirected graph, remove the opposite edge as well
     * Second: add "edge" to the source's set of edges --- which may not exist yet if
     *         this is the first edge out of the source
     *         Again, for an undirected graph, add the opposite edge as well
     * Third: Life is too short so have Fun!!!*/
    
    
    //#1
    Integer src = edge.getSource();
    Integer dest = edge.getDest();
    if (isEdge(src, dest)) {
      edges.get(src).remove(new Edge(src, dest));
      if (!directed)
        edges.get(dest).remove(new Edge(dest, src));
    }
    //#2
    if (edges.get(src) == null) 
      edges.put(src, new HashSet<>());
      
    if (edges.get(dest) == null) 
      edges.put(dest, new HashSet<>());
      
    
    edges.get(src).add(edge);
    if (!directed)
      edges.get(dest).add(new Edge(dest, src, edge.getWeight()));
  } 
  
  
  /** Get the edge between two vertices. If an edge does not exist, 
    * an Edge with a weight of Double.POSITIVE_INFINITY is returned.
    * @param source The source
    * @param dest The destination
    * @return the edge between these two vertices. If an edge does not exist, 
    * an Edge with a weight of Double.POSITIVE_INFINITY is returned.
    */
  public Edge getEdge(int source, int dest) {
    //COMPLETE ME **********************************************************************************    
    /* Search for Edge "target" in the Edges for "source"
     * Either return the matching edge, if found, or Edge "target" which 
     * has a weight of infinity --- meaning that it doesn't exist
     */ 
    
    //remember to use an enhaced for loop and the equals method from class Edge
    
    if (edges.get(source) != null && edges.get(dest) != null) {
      for (Edge e : edges.get(source)) {
        if (e.equals(new Edge(source, dest)))
          return e;
      }
    }
    
    return new Edge(source, dest, Double.POSITIVE_INFINITY);// Desired edge not found.
  }
  
  
  /** Return the edges connected to a given vertex.
    * @param source The source vertex
    * @return An Iterator<Edge> to the vertices connected to source or null if source doesn't connect to any
    *    vertices 
    */
  public Iterator<Edge> getEdgeIterator(int source){
    //COMPLETE ME **********************************************************************************
    /* return an iterator over set of Edges from "source" or null if "source" doesn't connect to any
    *    vertices */
    return edges.get(source) == null ? null : edges.get(source).iterator();
  }

  
}
