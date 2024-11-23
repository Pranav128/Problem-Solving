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
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode head=new ListNode(-1);
        ListNode tail=head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        for(ListNode curr:lists){
            ListNode tempHead=curr;
            while(tempHead!=null){
                pq.offer(tempHead);
                tempHead=tempHead.next;
            }
        }
        while(!pq.isEmpty()){
            tail.next=pq.poll();
            tail=tail.next;
        }
        tail.next=null;
        return head.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head=new ListNode(-1);
        ListNode tail=head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        for(ListNode curr:lists){
            if(curr!=null){
            pq.offer(curr);
            }
        }
        while(!pq.isEmpty()){
            ListNode node=pq.poll();
            tail.next=node;
            tail=tail.next;
            if(node.next!=null){
                pq.offer(node.next);
            }
        }
        return head.next;
    }
}