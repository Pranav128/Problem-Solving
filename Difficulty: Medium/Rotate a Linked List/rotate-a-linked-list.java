//{ Driver Code Starts
// Initial Template for Java

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
/* node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

*/
/*
class Solution {
    // Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        int size=1;
        Node curr = head;
        while(curr.next!=null){
            size++;
            curr=curr.next;
        }
        if(size==k){
            return head;
        }
        curr.next=head;
        size=size-k%size;
        while(size--!=0){
            curr=curr.next;
        }
        head=curr.next;
        curr.next=null;
        return head;
        
    }
}
*/class Solution{
    public Node rotate(Node head, int k) {
        Node temp = head;
        
        int len = 1;
        while(temp.next != null)
        {
            temp = temp.next;
            len++;
        }
        
        if(len == k) return head;
        
        temp.next = head;

        // Traverse to the node just before the new head
        for (int i = 0; i < k; i++) {
            temp = temp.next;
        }
    
        // The new head is the next node
        head = temp.next;
        temp.next =null;  // Break the circular link
    
        return head;
    }
    }

//{ Driver Code Starts.

public class GFG {
    static void printList(Node node) {
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
            if (!input.isEmpty()) {
                String[] numbers = input.split("\\s+");
                for (String num : numbers) {
                    if (!num.isEmpty()) {
                        arr.add(Integer.parseInt(num));
                    }
                }
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); ++i) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            head = ob.rotate(head, k);
            printList(head);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends