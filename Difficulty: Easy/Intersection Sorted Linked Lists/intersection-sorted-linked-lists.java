//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T-- > 0) {
            Node head1 = null, tail1 = null;
            Node head2 = null, tail2 = null;

            String input1 = sc.nextLine();
            String[] elems1 = input1.split(" ");
            for (String elem : elems1) {
                Node newNode = new Node(Integer.parseInt(elem));
                if (head1 == null) {
                    head1 = newNode;
                    tail1 = newNode;
                } else {
                    tail1.next = newNode;
                    tail1 = newNode;
                }
            }

            String input2 = sc.nextLine();
            String[] elems2 = input2.split(" ");
            for (String elem : elems2) {
                Node newNode = new Node(Integer.parseInt(elem));
                if (head2 == null) {
                    head2 = newNode;
                    tail2 = newNode;
                } else {
                    tail2.next = newNode;
                    tail2 = newNode;
                }
            }

            Solution obj = new Solution();

            Node result = obj.findIntersection(head1, head2);
            printList(result);
        }
        sc.close();
    }
}

// } Driver Code Ends

/*Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {
    public static Node findIntersection(Node head1, Node head2) {
        Node newNode = new Node(0);
        Node head,tail;
        head=tail=newNode;
        
        Node curr1=head1;
        Node curr2=head2;
        while(curr1!=null && curr2!=null){
            if(curr1.data == curr2.data){
                tail.next=new Node(curr1.data);
                tail=tail.next;
                curr1=curr1.next;
                curr2=curr2.next;
            }
            else if(curr1.data > curr2.data){
                curr2=curr2.next;
            }
            else{
                curr1=curr1.next;
            }
        }
        return head.next;
        
    }
}