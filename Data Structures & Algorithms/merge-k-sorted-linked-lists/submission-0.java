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
        List<Integer>list = new ArrayList<>();
        for(ListNode nodes: lists){
            while(nodes!=null){
                list.add(nodes.val);
                nodes=nodes.next;
            }
        }
        if(list.size()==0) return null;
        Collections.sort(list);
        ListNode node= new ListNode(list.get(0));
        ListNode curr = node;
        for(int i=1;i<list.size();i++){
            curr.next = new ListNode(list.get(i));
            curr=curr.next;
        }
        return node;
        //T.C O(nlogn)
        //S.C O(n) n is the number of total nodes
    }
}
