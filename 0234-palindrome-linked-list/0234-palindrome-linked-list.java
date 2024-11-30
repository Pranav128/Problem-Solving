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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        ListNode mid=findMid(head);
        ListNode curr2=reverse(mid);
        ListNode curr1=head;
        while(curr2!=null){
            if(curr1.val  != curr2.val){
                return false;
            }
            curr1=curr1.next;
            curr2=curr2.next;
        }
        return true;
    }
    public static ListNode reverse(ListNode head){
        ListNode prev=null, next, curr=head;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }  
        return prev;
    }
    public static ListNode findMid(ListNode head){
        ListNode slow=head, fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}