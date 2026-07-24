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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode curr = head;
        ListNode nxt = head.next;
        ListNode temp = nxt;
        curr.next=null;
        while(temp!=null){
            temp= nxt.next;
            nxt.next = curr;
            curr=nxt;
            nxt = temp;
           
        }
        return curr;
        //T.C O(n)
        //S.C O(1)
    }
}
