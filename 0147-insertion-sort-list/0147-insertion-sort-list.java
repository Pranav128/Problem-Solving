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
    public ListNode insertionSortList(ListNode head) {
        return divide(head);
    }
    static ListNode divide(ListNode head){
      //base case for recursion where we have only one ListNode or empty
        if(head==null||head.next==null){
            return head;
        }
        //middle of list (mid)
        ListNode mid=findMid(head);
        //left side 
        ListNode left=head;
        //right side of list 
        ListNode right=mid.next;
        //make mid.next null to seperate left and right side of list (two seperate halves)
        mid.next=null;
        //do it unitl we have only one ListNode in both
        //recusively sort both parts
        left=divide(left);
        right=divide(right);
        //merger all divided seperate ListNodes together by comparing 
        return merger(left,right);
    }
    static ListNode merger(ListNode left,ListNode right){
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while(left!=null && right!=null){
            if(left.val<right.val){
                curr.next=left;
                curr=left; //curr.next;
                left=left.next;
            }
            else{
                curr.next=right;
                curr=right;
                right=right.next;
            }
        }
        if(left!=null){
            curr.next=left;
        }
        else{
            curr.next=right;
        }
        return dummy.next;
    }
    static ListNode findMid(ListNode head){
        ListNode slow=head, fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
	    }
}