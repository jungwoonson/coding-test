package leetcode.queueandstack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CloneGraph {

    // Constraints:
    // The number of nodes in the graph is in the range [0, 100].
    // 1 <= Node.val <= 100
    // Node.val is unique for each node.
    // There are no repeated edges and no self-loops in the graph.
    // The Graph is connected and all nodes can be visited starting from the given node.
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> visited = new HashMap<>();
        recursion(node, visited);

        return visited.get(node);
    }

    private Node recursion(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        visited.put(node, new Node(node.val));
        for (int i = 0; i < node.neighbors.size(); i++) {
            Node newNode = visited.get(node);
            newNode.neighbors.add(recursion(node.neighbors.get(i), visited));
        }

        return visited.get(node);
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
