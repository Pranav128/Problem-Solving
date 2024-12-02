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
    public ListNode deleteDuplicates(ListNode head) {
       ListNode temp = new ListNode(-1);
       ListNode slow = temp;
       ListNode fast = head;
       slow.next = fast;
       while(fast!=null){
//fast to end of the current duplicates that we are tracking
        while(fast.next!=null && fast.val==fast.next.val){
            fast=fast.next;
        }
        if(slow.next!=fast){
            slow.next=fast.next; //removes the duplicates
            fast=slow.next;
        }
        else{
            slow=slow.next;
            fast=fast.next;
        }
       }
       return temp.next;
    }
}