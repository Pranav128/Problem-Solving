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
    /* Function to print nodes in a given linked list */
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    // Driver program to test the above functions
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            List<Node> arr = new ArrayList<>();
            List<Integer> nums = new ArrayList<>();
            String input = sc.nextLine();

            Scanner ss = new Scanner(input);
            while (ss.hasNextInt()) {
                nums.add(ss.nextInt());
            }
            int ind = 0;
            int N = nums.size();

            while (ind < N) {
                int n = nums.get(ind++);
                int x = nums.get(ind++);
                Node head = new Node(x);
                Node curr = head;
                n--;

                for (int i = 0; i < n; i++) {
                    x = nums.get(ind++);
                    Node temp = new Node(x);
                    curr.next = temp;
                    curr = temp;
                }
                arr.add(head);
            }

            Solution obj = new Solution();
            Node res = obj.mergeKLists(arr);
            printList(res);
        
System.out.println("~");
}
        sc.close();
    }
}

// } Driver Code Ends

/*class Node{
    int data;
    Node next;
    Node(int key){
        data = key;
        next = null;
    }
}
*/

// arr is an array of Nodes of the heads of linked lists....
class Solution {
    Node mergeKLists(List<Node> arr) {
        Node head=new Node(-1);
        Node tail=head;
        PriorityQueue<Node> pq= new PriorityQueue<>((a,b)->Integer.compare(a.data,b.data));
        for(Node curr:arr ){
            Node h=curr;
            while(h!=null){
                pq.add(h);
                h=h.next;
            }
        }
        while(!pq.isEmpty()){
            Node temp=(pq.poll());
            tail.next=temp;
            tail=tail.next;
        }
        tail.next=null;
        return head.next;
    }
}