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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        ListNode curr=head;
        int size=1;
        while(curr.next!=null){
            size++;
            curr=curr.next;
        }
        curr.next=head;
        size=size-k%size;
        while(size--!=0){
            curr=curr.next;
        }
        head=curr.next;
        curr.next=null;
        return head;
    }
}