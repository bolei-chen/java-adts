package graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Kruskal {
     
    private Graph graph;
    UnionSet set = new UnionSet(new HashMap<>());
    public Kruskal(Graph graph) {
        this.graph = graph;
        for (Edge e : graph.edges) {
            set.parentOf.put(e.start, e.start);
            set.parentOf.put(e.end, e.end);
        }
    }
    public Graph calculate() {
        List<Edge> result = new ArrayList();
        List<Edge> sr = graph.edges.stream()
           .sorted(Comparator.comparing(a -> a.length)).toList();
        for (Edge e: sr){
            Node start, end;
            start = e.start;
            end = e.end;
            if (set.find(start) != set.find(end)) {
                result.add(e);
                set.union(start, end);
            }
        }
        return new Graph(result);
    }
}
