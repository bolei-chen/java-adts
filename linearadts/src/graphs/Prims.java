package graphs;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Prims {

  private AdjListGraph graph;
  private List<Node> visited;

  public Prims(AdjListGraph graph) {
    this.graph = graph;
    visited = new LinkedList<>();
  }

  public Graph calculate(Node start) {
    visited.add(start);
    List<Pair<Node, Edge>> fringes = graph.getNeighbours(start);
    List<Edge> edges = new LinkedList<>();
    while (visited.size() < graph.size()) {
      Pair<Node, Edge> choice = fringes.stream()
              .min(Comparator.comparing(p -> p.second.length)).get();
      visited.add(choice.first);
      edges.add(choice.second);
      List<Pair<Node, Edge>> newFringes = graph.getNeighbours(choice.first);
      newFringes.forEach(p -> fringes.add(p));
    }
    return new Graph(edges);
  }

}
