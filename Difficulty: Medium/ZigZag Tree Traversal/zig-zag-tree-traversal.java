//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.util.HashMap;
import java.io.*;

    class Node
    {
        int data;
        Node left,right;
        Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
    }
		
public class GFG2
{
    static Node buildTree(String str){
        
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
        
        return root;
    }
    
	public static void inorder(Node root)
	{
	    if(root==null)
	    return;
	    inorder(root.left);
	    System.out.print(root.data);
	    inorder(root.right);
	}
     /* Drier program to test above functions */
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    GFG g = new GFG();
			
			    ArrayList<Integer> res = g.zigZagTraversal(root) ;
			    for (int i = 0; i < res.size (); i++)
			        System.out.print (res.get (i) + " ");
			    System. out. println();  
    			
                t--;
            
        
System.out.println("~");
}
	}
}
// } Driver Code Ends


//User function Template for Java

class GFG
{
	ArrayList<Integer> zigZagTraversal2(Node root){
        ArrayList<Integer>ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<Node>que=new LinkedList<>();
        que.add(root);
        boolean flag=true;
        while(!que.isEmpty()){
            int size=que.size();
            ArrayList<Integer>temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                Node polled=que.poll();
                temp.add(polled.data);
                if(polled.left!=null){
                    que.add(polled.left);
                }
                if(polled.right!=null){
                    que.add(polled.right);
                }
            }
            if(!flag){
                Collections.reverse(temp);
            }
            ans.addAll(temp);
            flag=!flag;
        }
        return ans;
	}
	
	ArrayList<Integer> zigZagTraversal(Node root){
        ArrayList<Integer>ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<Node>que=new LinkedList<>();
        que.add(root);
        boolean flag=true;
        while(!que.isEmpty()){
            int size=que.size();
            int insert=ans.size();
            for(int i=0;i<size;i++){
                Node polled=que.poll();
                if(flag){
                    ans.add(polled.data);
                }else{
                    ans.add(insert,polled.data);
                }
                if(polled.left!=null){
                    que.add(polled.left);
                }
                if(polled.right!=null){
                    que.add(polled.right);
                }
            }
            flag=!flag;
        }
        return ans;
	}
}