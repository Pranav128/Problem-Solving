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
    public ListNode sortList(ListNode head) {
        //base case for recursion where we have only one node or empty
        if(head==null||head.next==null){
            return head;
        }
        //left side 
        ListNode left=head;
        //middle of list (mid)
        ListNode mid=findMid(head);
        //right side of list 
        ListNode right=mid.next;
        //make mid.next null to seperate left and right side of list (two seperate halves)
        mid.next=null;
        //do it unitl we have only one Node in both
        //recusively sort both parts
        left=sortList(left);
        right=sortList(right);
        //merger all divided seperate nodes together by comparing 
        return helper(left,right);
    }
    static ListNode helper(ListNode left,ListNode right){
        ListNode tempHead=new ListNode(-1);
        ListNode tail=tempHead;
        while(left!=null && right!=null){
            if(left.val<right.val){
                tail.next=left;
                tail=left;
                left=left.next;
            }
            else{
                tail.next=right;
                tail=right;
                right=right.next;
            }
        }
        //check for odd length if any remaining nodes are there 
        if(left!=null){
            tail.next=left;
        }
        else{
            tail.next=right;
        }
        return tempHead.next;
    }
    static ListNode findMid(ListNode head){
        ListNode slow=head, fast=head.next;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}