//{ Driver Code Starts
import java.io.*;
import java.util.*;

class pair
{
    int first;
    boolean second;
    pair(int first, boolean second)
        {
            this.first = first;
            this.second = second;
        }
}
class Node
{
    int data, height;
    Node left, right;
    
    Node(int x)
    {
        data=x;
        left=right=null;
        height=1;
    }
}
public class GfG
{
    
    public static int setHeights(Node n)
    {
    	if(n==null) return 0;
    	n.height = 1 + Math.max( setHeights(n.left) , setHeights(n.right) );
    	return n.height;
    }
    
    static Node buildTree(String str)
    {
        
        if(str.length()==0 || str.charAt(0)=='N'){
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
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        setHeights(root);
        return root;
    }
    
    public static boolean isBST(Node n, int lower, int upper)
    {
    	if(n==null) return true;
    	if( n.data <= lower || n.data >= upper ) return false;
    	return isBST(n.left, lower, n.data) && isBST(n.right, n.data, upper) ;
    }
    
    public static pair isBalanced(Node n)
    {
    	if(n==null)
    	    {
    	        return new pair(0,true);
    	    }
        
    	pair l = isBalanced(n.left);
    	pair r = isBalanced(n.right);
    
    	if( Math.abs(l.first - r.first) > 1 ) return new pair (0,false);
    
    	return new pair( 1 + Math.max(l.first , r.first) , l.second && r.second );
    }
    
    public static boolean isBalancedBST(Node root)
    {
    	if( isBST(root, Integer.MIN_VALUE , Integer.MAX_VALUE) == false )
    		System.out.print("BST voilated, inorder traversal : ");
    
    	else if ( isBalanced(root).second == false)
    		System.out.print("Unbalanced BST, inorder traversal : ");
    
    	else return true;
    	return false;
    }
    
    public static void printInorder(Node n)
    {
    	if(n==null) return;
    	printInorder(n.left);
    	System.out.print(n.data + " ");
    	printInorder(n.right);
    }


    public static void main(String args[]) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int t = Integer.parseInt(br.readLine());
            
            while(t-->0)
                {
                    String s = br.readLine();
    	    	    Node root = buildTree(s);
    	    	    
                    
                    int n = Integer.parseInt(br.readLine());
                    int ip[] = new int[n];
                    
                    String[] in = br.readLine().trim().split("\\s+");
                    
                    for(int i = 0; i < n; i++)
                        ip[i] = Integer.parseInt(in[i]);
                    
                    Sol obj = new Sol();
                    
                    for(int i=0; i<n; i++)
            		{
            			root = obj.deleteNode(root, ip[i]);
            			
            			if(isBalancedBST(root)==false)
            				break;
            		}
        
            		if(root==null)
            			System.out.print("null");
            		else
            			printInorder(root);
            		System.out.println();    
                    
                    
                 
                    
                
System.out.println("~");
}
            
                
        }
}
// } Driver Code Ends


class Sol{
    static int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        // Perform rotation
        x.right = y;
        y.left = T2;
        // Update heights
        y.height = Math.max(height(y.left),height(y.right)) + 1;
        x.height = Math.max(height(x.left),height(x.right)) + 1;
        // Return new root
        return x;
    }
 
    static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        // Perform rotation
        y.left = x;
        x.right = T2;
        // Update heights
        x.height = Math.max(height(x.left),height(x.right)) + 1;
        y.height = Math.max(height(y.left),height(y.right)) + 1;
        // Return new root
        return y;
    }

    static int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }
    
    static Node minValueNode(Node node) {
        Node current = node;
        // loop down to find the leftmost leaf
        while (current.left != null)
            current = current.left;
        return current;
    }

    static Node deleteNode(Node root, int key) {
        if (root == null)
            return root;
        if (key < root.data)
            root.left = deleteNode(root.left, key);
        else if (key > root.data)
            root.right = deleteNode(root.right, key);
        else {
            //Case1: node with only one child or no child
            // if ((root.left == null) || (root.right == null)) {
            //     Node temp = root.left != null ? root.left : root.right;
            //     // No child case
            //     if (temp == null) {
            //         temp = root;
            //         root = null;
            //     } else // One child case
            //         root = temp; // Copy the contents of the non-empty child
            // }
            if(root.left==null){
                root=root.right;
            }else if(root.right == null){
                root=root.left;
            }
            else {
                //Case2: node with two children: Get the inorder successor 
                //(smallest leftmost in the right subtree)
                Node temp = minValueNode(root.right);
                root.data = temp.data;
                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.data);
            }
        }

        // If the tree had only one node then return
        if (root == null)
            return root;

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.height = Math.max(height(root.left),height(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS 
        // NODE (to check whether this node became unbalanced)
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);
        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);
        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }
}

class Sool{
    static int getHeight(Node node){
        if(node==null){
            return 0;
        }
        return node.height;
    }
    
    static int getBF(Node node){
        if(node==null){
            return 0;
        }
        return getHeight(node.left)-getHeight(node.right);
    }
    
    static Node getSuccessor(Node node){
        while(node.left!=null){
            node=node.left;
        }
        return node;
    }
    
    static Node leftRotate(Node root){
        Node x=root.right;
        Node y=x.left;
        
        root.right=y;
        x.left=root;
        
        root.height=1+Math.max(getHeight(root.left),getHeight(root.right));
        x.height=1+Math.max(getHeight(x.left),getHeight(x.right));
        
        return x;
    }
    
    static Node rightRotate(Node root){
        Node x=root.left;
        Node y=x.right;
        
        x.right=root;
        root.left=y;
        
        root.height=1+Math.max(getHeight(root.left),getHeight(root.right));
        x.height=1+Math.max(getHeight(x.left),getHeight(x.right));
        
        return x;
    }
    
    public static Node deleteNode(Node root, int data){
        if(root==null){
            return root;
        }
        if(root.data<data){
            root.right=deleteNode(root.right,data);
        }
        else if(root.data>data){
            root.left=deleteNode(root.left,data);
        }
        else{
            if(root.left==null){
                root=root.right;
            }else if(root.right == null){
                root=root.left;
            }else{
                Node succ=getSuccessor(root.right);
                root.data=succ.data;
                root.right=deleteNode(succ.right,succ.data);
            }
        }
        
        if(root==null){
            return root;
        }
        
        root.height=1+Math.max(getHeight(root.left),getHeight(root.right));
        
        int bf=getBF(root);
        //LL
        if(bf>1 && getBF(root.left)>=0){
            return rightRotate(root);
        }
        //RR
        if(bf<-1 && getBF(root.right)<=0 ){
            return leftRotate(root);
        }
        //LR
        if(bf>1 && getBF(root.left)<0){
            root.left=leftRotate(root.left);
            return rightRotate(root);
        }
        //RL
        if(bf<-1 && getBF(root.right) >0){
            root.right=rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }
    
}