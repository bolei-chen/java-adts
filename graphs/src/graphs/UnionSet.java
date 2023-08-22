package graphs;

import java.util.Map;

public class UnionSet {
     
    public Map<Node, Node> parentOf;
     
    public UnionSet(Map<Node, Node> parentOf) {
        this.parentOf = parentOf; 
    } 
     
    public Node find(Node son) {
        Node start = son;
        while (parentOf.get(start) != start) {
            start = parentOf.get(start);
        }
        while(parentOf.get(son)!= son) {
            parentOf.put(son, parentOf.get(son));
            son = parentOf.get(son);
        }
        return start;
    }
     
    public void union(Node a, Node b) {
        Node pa = this.find(a);
        Node pb = this.find(b);
        parentOf.put(pa, pb); // father of a is the father of b's father

    }
}