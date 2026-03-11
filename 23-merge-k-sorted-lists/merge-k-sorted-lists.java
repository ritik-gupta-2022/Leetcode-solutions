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
    public ListNode helper(ListNode h1, ListNode h2){
        if(h1==null && h2==null) return null;
        else if(h1==null) return h2;
        else if(h2==null) return h1;
        if(h1.val <= h2.val){
            h1.next = helper(h1.next,h2);
            return h1;
        }
        h2.next = helper(h1,h2.next);
        return h2;
    }
    public ListNode merge(int st, int end, ListNode[] list){
        if(st==end) return list[st];

        int mid = st+(end-st)/2;

        ListNode l1 = merge(st,mid,list);
        ListNode l2 = merge(mid+1,end,list);

        return helper(l1,l2);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        // if(lists.length==1) return lists[0];

        // ListNode head = helper(lists[0],lists[1]);

        // for(int i=2; i<lists.length; i++){
        //     head = helper(head,lists[i]);
        // }
        // return head;

        return merge(0,lists.length-1,lists);
    }
        
}