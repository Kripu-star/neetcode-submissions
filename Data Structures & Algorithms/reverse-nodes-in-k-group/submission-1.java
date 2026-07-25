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
       if(head == null || head.next == null)return head;
       ListNode prev = null;
       ListNode curr = head;
       
       
       while(curr!=null){
        ListNode temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
        
       }
       return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
      
      if(head.next == null) return head;
      boolean started = false;
      ListNode new_head = new ListNode(0);
      new_head.next = head;
      ListNode tail = head;
      ListNode prev = null;
      while(head!=null){
      tail = head;
      int cnt =1;
      ListNode curr = head;
      while(cnt!=k && curr!=null ){
        curr = curr.next;
        cnt++;
      }
      if(curr == null){
        //System.out.println(prev.val);
        if(started) {
            prev.next = head;
            //System.out.println(prev.val);
        }
        return new_head.next;
      } 
      if (cnt == k){
        
            ListNode nxt = curr.next;
            curr.next = null;
        
        if (!started) {
            new_head.next =reverseList(head);
            started = true;
        }
        else{
            prev.next = reverseList(head);
            
        }
        head = nxt;
        prev = tail;

        
      }
    }
    
    return new_head.next;
    //T.C O(n)
    //S.C O(1)
    }
}
