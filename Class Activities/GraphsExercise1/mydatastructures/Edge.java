package mydatastructures;
/** 
 * An Edge represents a relationship between two vertices
 */
public class Edge implements Comparable<Edge>{
  
  // Data Fields
  /** The source vertix */
  private int source;
  
  /** The destination vertix */
  private int dest;
  
  /** The weight */
  private double weight;
  
  // Constructor
  /** Construct an Edge with a source of from and a destination of to. 
    * Set the weight to 1.0.
    * @param from - The source vertix
    * @param to - The destination vertix
    */
  public Edge(int from, int to) {
    this.source = from;
    this.dest = to;
    this.weight = 1.0;
  }
  
  /** Construct a weighted edge with a source of from and a destination of to. 
    * Set the weight to w.
    * @param from - The source vertix
    * @param to - The destination vertix
    * @param w - The weight
    */
  public Edge(int from, int to, double w) {
    this.source = from;
    this.dest = to;
    this.weight = w;
  }
  
  // Methods
  /** Get the source
    * @return The value of source
    */
  public int getSource() {
    return this.source;
  }
  
  /** Get the destination
    * @return The value of dest
    */
  public int getDest() {
    return this.dest;
  }
  
  /** Get the weight
    * @return the value of weight
    */
  public double getWeight() {
    return this.weight;
  }
  
  /** Return a String representation of the edge
    * @return A String representation of the edge
    */
  public String toString() {
    return "[(" + this.source + ", " + this.dest + "): " + this.weight + "]";
  }
  
  /** Return true if two edges are equal. Edges are equal if the 
    * source and destination are equal. Weight is not conidered.
    * @param obj The object to compare to
    * @return true if the edges have the same source and destination
    */
  public boolean equals(Object obj) {
    if (obj instanceof Edge) {
      Edge edge = (Edge) obj;
      return (this.source == edge.getSource() && this.dest == edge.getDest());
    }
    else {
      return false;
    }
  }
  /** Compares the edges by comparing the weights
    * @param otherEdge The other edge with which we're comparing this edge object 
    * to compare to
    * @return the value 0 if the weights are equal a value less than 0 if this 
    * weight is numerically greater than the weight of otherEdge a value greater than 
    * 0 if this weight is numerically less than the weight of otherEdge
    */
  public int compareTo(Edge otherEdge) {
    return Double.compare(this.getWeight(), otherEdge.getWeight());
  }
  
  /** Return a hash code for an edge. The hash code is the source shifted left 16 
    * bits exclusive OR with the dest
    * @return a hash code for an edge
    */
  public int hashCode() {
    return (this.source << 16) ^ this.dest;
  }
  
}
