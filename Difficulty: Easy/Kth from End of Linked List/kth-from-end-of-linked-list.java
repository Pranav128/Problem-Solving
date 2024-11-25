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
/* Structure of node
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
} */

class Solution {

    int getKthFromLast(Node head, int k) {
        Node first=head;
        for(int i=0;i<k;i++){
            if(first==null){
                return -1;
            }
            first=first.next;
        }
        Node second=head;
        while(first!=null){
            first=first.next;
            second=second.next;
        }
        return second.data;
    }
    int getKthFromLast2(Node head, int k) {
        if(head ==null){
            return -1;
        }
        int size = getSize(head);
        for(int i=0;i<size;i++){
            if(i==size-k){
                return head.data;
            }
            head=head.next;
        }
        return -1;
    }
    static int getSize(Node head){
        int i =0;
        Node temp = head;
        while(temp != null){
            i++;
            temp = temp.next;
        }
        return i;
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

            int x = Integer.parseInt(br.readLine().trim());

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); ++i) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }

            Solution g = new Solution();
            // System.out.println(k);
            System.out.println(g.getKthFromLast(head, x));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends