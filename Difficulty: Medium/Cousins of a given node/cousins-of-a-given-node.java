//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.*;
import java.io.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
} class GfG {
    public static Node buildTree(String str) {

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
    
    public static Node point(Node root, int n)
    {
        if(root == null)
            return null;
            
        if(root.data == n)
            return root;
            
        Node l = point(root.left, n);
        if(l!=null && l.data==n)
            return l;
            
        Node r= point(root.right, n);
        return r;
        
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            Node root = buildTree(s);
            
            Node p = point(root,n);
            
            Solution ob=new Solution();
            ArrayList<Integer> ans= ob.printCousins(root, p);
            
            for(int i=0;i<ans.size();i++)
            {
                    System.out.print(ans.get(i)+" ");
    
            }
            
            System.out.println();
            
        }
    }
}
// } Driver Code Ends


class Solution
{
    public static ArrayList<Integer> printCousins(Node root, Node node_to_find)
    {
        ArrayList<Integer> list = new ArrayList<>();
        boolean test = false;
        boolean start = false;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        Node sib = null;
        while(!q.isEmpty()) {
            Node pop = q.poll();
            if(pop!=null) {
                if(start&&pop!=node_to_find&&pop!=sib)
                list.add(pop.data);
                if(pop.left!=null) {
                    if(pop.left==node_to_find) {
                        if(pop.right!=null)
                        sib = pop.right;
                        test = true;
                    }
                    q.add(pop.left);
                }
                if(pop.right!=null) {
                    if(pop.right==node_to_find) {
                        if(pop.left!=null)
                        sib = pop.left;
                        test = true;
                    }
                    q.add(pop.right);
                }
            }
            else if(pop==null&&!q.isEmpty()) {
                if(start)
                break;
                if(test)
                start = true;
                q.add(null);
            }
        }
        if(list.size()==0)
        list.add(-1);
        return list;
    }
}