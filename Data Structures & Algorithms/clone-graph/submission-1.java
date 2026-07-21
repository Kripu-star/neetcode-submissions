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
    private Node bfs (Node node, HashMap<Node, Node>mp, Queue<Node>q){
       if(node == null) return null;
       q.add(node);
       mp.put(node, new Node(node.val));
       while(!q.isEmpty()){
       Node curr = q.poll();
       
       
       for(Node nbr: curr.neighbors){
            if(!mp.containsKey(nbr)){
                q.add(nbr);
                mp.put(nbr, new Node(nbr.val));

            }
            mp.get(curr).neighbors.add(mp.get(nbr));
        }
       }
        return mp.get(node);
    }
    public Node cloneGraph(Node node) {
       HashMap<Node, Node>mp = new HashMap<>();
       Queue<Node>q = new ArrayDeque<>();
       return bfs(node, mp, q);

       //T.C O(V+E)
       //S.C O(V)
    }
}