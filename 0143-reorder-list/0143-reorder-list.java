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
    public void reorderList(ListNode head) {
        if(head==null){return;}
        ListNode mid=mid(head);
        ListNode rightHalf = reverse(mid);
        ListNode leftHalf = head;
        ListNode nextLeft , nextRight;
        while(leftHalf!=null && rightHalf!=null){
            nextLeft=leftHalf.next;
            leftHalf.next=rightHalf;
            nextRight=rightHalf.next;
            rightHalf.next=nextLeft;

            leftHalf=nextLeft;
            rightHalf=nextRight;
        }
    }
    public static ListNode reverse(ListNode mid){
        ListNode curr=mid.next;
        mid.next=null;
        ListNode prev = null;
        ListNode next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public static ListNode mid(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}