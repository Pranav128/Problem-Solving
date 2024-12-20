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

class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        while (t > 0) {

            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node copy = head;
            Map<Node, Integer> mp = new HashMap<>();
            mp.put(head, head.data);
            for (int i = 1; i < s.length; i++) {
                Node temp = new Node(Integer.parseInt(s[i]));
                copy.next = temp;
                copy = copy.next;
                mp.put(temp, temp.data);
            }

            Node failure = new Node(-1);

            Solution g = new Solution();
            head = g.pairwiseSwap(head);

            Node temp = head;
            int f = 0;
            while (temp != null) {
                if (mp.get(temp) != temp.data) {
                    f = 1;
                }
                temp = temp.next;
            }

            if (f == 1) {
                printList(failure);
            } else {
                printList(head);
            }
            t--;
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


/* node class of the linked list

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
    // Function to pairwise swap elements of a linked list.
    // It should returns head of the modified list
    public Node pairwiseSwap(Node head) {
        if(head==null||head.next==null){
            return head;
        }
        Node prev=head;
        Node curr=head.next.next;
        head=head.next;
        head.next=prev;
        while(curr!=null && curr.next!=null){
            prev.next=curr.next;
            prev=curr;
            Node next=curr.next.next;
            curr.next.next=curr;
            curr=next;
        }
        prev.next=curr;
        return head;
    }
}