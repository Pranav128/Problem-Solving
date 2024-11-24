/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList2(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        Node curr=head;
        while(curr!=null){
            map.put(curr,new Node(curr.val));
            curr=curr.next;
        }
        curr=head;
        while(curr!=null){
            map.get(curr).next=map.get(curr.next);
            map.get(curr).random=map.get(curr.random);
            curr=curr.next;
        }
        return map.get(head);
    }
    public Node copyRandomList(Node head){
        if(head==null){
            return null;
        }
        Node curr=head;
        while(curr!=null){
            Node temp=new Node(curr.val);
            temp.next=curr.next;
            curr.next=temp;
            curr=temp.next;
        }
        curr=head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random=curr.random.next;
            }
            curr=curr.next.next;
        }
        Node tempHead=new Node(-1);
        Node tail=tempHead;
        curr=head;
        while(curr!=null){
            tail.next=curr.next;
            tail=tail.next;
            curr.next=curr.next.next;
            curr=curr.next;
        }
        return tempHead.next;
    }
}