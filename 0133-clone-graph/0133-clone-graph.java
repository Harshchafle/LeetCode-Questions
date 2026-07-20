/*
// Definition for a Node.
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
*/

class Solution {
    public Node cloneGraph(Node node) {
        // Map<Node, ArrayList<Node>> edgeList = new HashMap<>();

        // makeList(node, edgeList);

        // return makeGraph(edgeList);
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        return clone(node, map);
    }

    public Node clone(Node node, Map<Node, Node> map) { 
        if(map.containsKey(node)) return map.get(node);
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for(Node neigh : node.neighbors) {
            newNode.neighbors.add(clone(neigh, map));
        }
        return newNode;
    }

    public Node makeGraph(Map<Node, ArrayList<Node>> map) {
        Node head = null;
        if(map.size() == 0) return head;
        int i = 1;
        
        for(Node n : map.keySet()) {
            if(i--==1) head = new Node(n.val, map.get(n));
            else {
                Node node = new Node(n.val, map.get(n));
            }
        }
        System.out.println(head);
        return head;
    }

    public void makeList(Node node, Map<Node, ArrayList<Node>> map) {
        if(node != null && !map.containsKey(node)) {
            map.put(node, new ArrayList<>());
        }
        else return;
        if(node != null) {
            for(Node neigh : node.neighbors) {
                map.get(node).add(neigh);
                makeList(neigh, map);
            }
        }
    }

}