//{ Driver Code Starts

// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Gfg {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            int k = Integer.parseInt(br.readLine());
            Node[] pre = new Node[1];
            Node[] suc = new Node[1];
            Solution.findPreSuc(root, pre, suc, k);
            if (pre[0] != null) {
                System.out.print(pre[0].data + " ");
            } else {
                System.out.print("-1 ");
            }
            if (suc[0] != null) {
                System.out.println(suc[0].data);
            } else {
                System.out.println("-1 ");
            }
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


class Solution {
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        if(root==null){
            return;
        }
        if(root.data<key){
            pre[0]=root;
            findPreSuc(root.right,pre,suc,key);
            return;
        }
        if(root.data>key){
            suc[0]=root;
            findPreSuc(root.left,pre,suc,key);
            return;
        }
        findPreSuc(root.left,pre,suc,key);
        findPreSuc(root.right,pre,suc,key);
        
    }
}
/*

    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // code here.
        // update pre[0] with the predecessor of the key
        // update suc[0] with the successor of the key
        pre[0] = inorderPredecessor(root, new Node(key));
        suc[0] = inorderSuccessor(root, new Node(key));
    }
    
    public static Node inorderSuccessor(Node root, Node x) {
        //add code here.
        if (root == null) {
            return null;
        }
        Node successor = null;
        while (root != null) {
            if (x.data >= root.data) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }

    public static Node inorderPredecessor(Node root, Node x) {
        //add code here.
        if (root == null) {
            return null;
        }
        Node predecessor = null;
        while (root != null) {
            if (root.data >= x.data) {
                root = root.left;
            } else {
                predecessor = root;
                root = root.right;
            }
        }
        return predecessor;
    }
*/