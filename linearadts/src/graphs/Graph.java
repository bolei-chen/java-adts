package graphs; 
import java.util.*;
 
public class Graph {
    List<Edge> edges;
     
    public Graph(List<Edge> edges) {
        this.edges = edges;
    } 
     
    public Double totalLengths() {
        System.out.println(edges.stream().map(e -> e.length).toList());
        return edges.stream()
        .map(e -> e.length)
        .reduce(Double::sum).get();
    } 
     
}