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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k==1){
            return head;
        }
        ListNode curr=head;
        int count=0;
        while(curr!=null && count<k){
            curr=curr.next;
            count++;
        }
        if(count<k){
            return head;
        }
        curr=head;
        ListNode prev=null;
        count=0;
        while(curr!=null && count<k){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        if(curr!=null){
            head.next=reverseKGroup(curr,k);
        }
        return prev;
    }

}