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
    public ListNode oddEvenList(ListNode head) {
        if(head==null|| head.next==null){
            return head;
        }
        ListNode even = new ListNode(-1);
        ListNode odd= new ListNode(-1);
        ListNode evenHead=even;
        ListNode oddHead=odd;
        int i=0;
        while(head!=null){
            if(i%2==0){
                even.next=head;
                even=even.next;
            }
            else{
                odd.next=head;
                odd=odd.next;
            }
            i++;
            head=head.next;
        }
        even.next=oddHead.next;
        odd.next=null;
        return evenHead.next;
    }
}