/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>pq = new PriorityQueue<>((a,b)->(a.val-b.val));
        for(ListNode nodes: lists){
            if(nodes!= null) pq.offer(nodes);
        }
        ListNode ans = new ListNode(0);
        ListNode curr = ans;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            curr.next = node;
            curr= curr.next;
            node = node.next;
            if(node!= null) pq.offer(node);

        }
        return ans.next;
        //T.C. O(n*log k) n is number of nodes in each element of the list
        //S.C O(k) k is list.length
    }
}
