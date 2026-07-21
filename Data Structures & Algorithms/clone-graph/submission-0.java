/*
Definition for a Node.
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
    private Node dfs (Node node, HashMap<Node, Node>mp){
        if(node == null) return null;
        if(mp.containsKey(node)) return mp.get(node);
        Node curr_copy = new Node(node.val);
        mp.put(node, curr_copy);
        for(Node nbr: node.neighbors) curr_copy.neighbors.add(dfs(nbr, mp));
        return curr_copy;
        
    }
    public Node cloneGraph(Node node) {
       HashMap<Node, Node>mp = new HashMap<>();
       return dfs(node, mp);
       //T.C O(V+E)
       //S.C O(V)
    }
}