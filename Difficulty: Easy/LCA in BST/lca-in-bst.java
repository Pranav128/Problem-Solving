//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

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

class GfG {

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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            BST g = new BST();

            // Read x and y from two separate lines
            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());

            System.out.println(g.LCA(root, x, y).data);
            t--;

            // System.out.println("~");
        }
    }
}

// } Driver Code Ends

class BST {
    Node LCA(Node root, int n1, int n2) {
        if(root==null){
            return null;
        }
        ArrayList<Node>p1=new ArrayList<>();
        ArrayList<Node>p2=new ArrayList<>();
        
        if(! (findPath(root,n1,p1)&&findPath(root,n2,p2) ) ){
            return null;
        }
        Node ans=null;
        for(int i=0;i<p1.size()&&i<p2.size();i++){
            if(p1.get(i).data == p2.get(i).data){
                ans=p1.get(i);
            }else{
                break;
            }
        }
        return ans;
    }
    boolean findPath(Node root, int n, ArrayList<Node>path){
        if(root==null){
            return false;
        }
        path.add(root);
        if(root.data==n){
            return true;
        }
        return root.data<n?findPath(root.right,n,path):findPath(root.left,n,path);
    }
}
