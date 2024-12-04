/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        ListNode curr1=head1;
        ListNode curr2=head2;
        while(curr1!=curr2){
            curr1=curr1==null?head2:curr1.next;
            curr2=curr2==null?head1:curr2.next;
        }
        return curr1;
    }
    public ListNode getIntersectionNode2(ListNode head1, ListNode head2) {
        int len1=0,len2=0;
        ListNode curr1=head1;
        ListNode curr2=head2;
        while(curr1!=null){
            len1++;
            curr1=curr1.next;
        }
        while(curr2!=null){
            len2++;
            curr2=curr2.next;
        }
        int abs=Math.abs(len1-len2);
        curr1=head1;
        curr2=head2;
        if(len1<len2){
           while(curr2!=null&&abs>0){
               curr2=curr2.next;
               abs--;
           }
        }
        else{
            while(curr1!=null && abs>0){
                curr1=curr1.next;
                abs--;
            }
        }
        while(curr1!=null && curr2!=null){
            if(curr1==curr2){
                return curr1;
            }
            curr1=curr1.next;
            curr2=curr2.next;
        }
        return null;
    }
}