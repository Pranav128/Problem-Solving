//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends
/*
The structure of linked list is the following

class Node
{
int data;
Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    static Node mergeSort(Node head) {
        return divide(head);
    }
    static Node divide(Node head){
        if(head==null||head.next==null){
            return head;
        }
        Node mid=findMid(head);
        Node left=head;
        Node right=mid.next;
        mid.next=null;
        left=divide(left);
        right=divide(right);
        return merger(left,right);
    }
    static Node merger(Node left,Node right){
        Node dummy=new Node(-1);
        Node curr=dummy;
        while(left!=null && right!=null){
            if(left.data<right.data){
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
    static Node findMid(Node head){
        Node slow=head, fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}









































//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().mergeSort(head);
            printList(head);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends