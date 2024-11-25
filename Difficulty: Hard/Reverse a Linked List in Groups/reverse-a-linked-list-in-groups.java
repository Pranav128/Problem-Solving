//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class ReverseInSize {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());

        while (t-- > 0) {

            String s[] = in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < s.length; i++) {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res, out);
            out.println();

            out.println("~");
        }
        out.close();
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
    }
}

// } Driver Code Ends


/*node class of the linked list

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
    public static Node reverse2(Node head, int k) {
        Node curr=head, next=null, prev=null; 
        int count=0;
        while(curr!=null && count<k){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        if(next!=null){
            Node tempHead=reverse(next,k);
            head.next=tempHead;
        }
        return prev;
    }
    public static Node reverse(Node head, int k) {
        if(head==null || head.next==null || k==1){
            return head;
        }
        boolean isFirst=true;
        Node curr=head;
        Node prevFirst=null;
        while(curr!=null){
            int count=0;
            Node prev=null;
            Node firstNode=curr;
            while(curr!=null && count<k){
                Node next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
                count++;
            }
            if(isFirst){
                head=prev;
                isFirst=false;
            }
            else{
                prevFirst.next=prev;
            }
            prevFirst=firstNode;
        }
        return head;
    }
}











