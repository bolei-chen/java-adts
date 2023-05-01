package graphs;

import java.util.*;

public class AdjListGraph {
    private Map<Node, List<Pair<Node, Edge>>> adjList;
    
    public AdjListGraph() {
        adjList = new HashMap<>();
    }

    public List<Pair<Node, Edge>> getNeighbours(Node node) {
        return adjList.get(node);
    }

    public int size() {
        return adjList.keySet().size();
    }


}
class Pair<K, V> {
    public K first;
    public V second;
}
