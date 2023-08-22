package graphs;
public class Edge {
    public Node start, end;
    public Double length;
    public Edge(Node start, Node end, Double length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }
    
}