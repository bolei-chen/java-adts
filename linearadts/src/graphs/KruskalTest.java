package graphs;

import java.util.List;

public class KruskalTest {
    /*
1 2 2
1 3 2
1 4 3
2 3 4
3 4 3
A B weight

total length is 7

*/
    public static void main(String[] args){
        Node n1 = new Node(), n2 = new Node(), n3 = new Node(), n4 = new Node();
        Edge e1 = new Edge(n1, n2, 2.0);
        Edge e12 = new Edge(n2, n1, 2.0);
        
        Edge e2 = new Edge(n1, n3, 2.0);
        Edge e22 = new Edge(n3, n1, 2.0);

        Edge e3 = new Edge(n1, n4, 3.0);
        Edge e32 = new Edge(n4, n1, 3.0);

        Edge e4 = new Edge(n2, n3, 4.0);
        Edge e42 = new Edge(n3, n2, 4.0);

        Edge e5 = new Edge(n3, n4, 3.0);
        Edge e52 = new Edge(n4, n3, 3.0);

        List<Edge> els = List.of(e1, e12, e2, e22, e3, e32, e4, e42, e5, e52);
        Graph g1 = new Graph(els);
        Kruskal k = new Kruskal(g1);
        Graph out = k.calculate();
        System.out.println(out.totalLengths());
    }
}