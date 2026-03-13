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
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
    public ListNode getKth(ListNode node, int k){
        while(node != null && k > 0){
            node = node.next;
            k--;
        }
        return node;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while(true){
            ListNode kth = getKth(prev,k);

            if(kth == null) break;

            ListNode next = kth.next;

            kth.next = null;

            ListNode start = prev.next;

            ListNode newHead = reverse(start);

            // connect back
            prev.next = newHead;
            start.next = next;

            prev=start; 
        }
        return dummy.next;
    }
}