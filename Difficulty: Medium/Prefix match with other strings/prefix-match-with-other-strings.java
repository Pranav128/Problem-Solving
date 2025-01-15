//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            String[] arr = new String[n];
            for(int i=0;i<n;i++)
            {
                arr[i] = sc.next();
            }
            
            int k = Integer.parseInt(sc.next());
            
            String str = sc.next();
            
            Solution obj = new Solution();
            int ans = obj.klengthpref(arr,n,k,str);
            System.out.println(ans);
            
            t--;
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


//User function Template for Java

class Node{
    Node children[]=new Node[26];
    int count;
}
class Trie{
    private Node root=new Node();
    
    public void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(curr.children[index]==null)
                curr.children[index]=new Node();
            curr=curr.children[index];
            curr.count++;
        }
    }
    public int search(String word,int k){
        Node curr=root;
        for(int i=0;i<k;i++){
            int index=word.charAt(i)-'a';
            if(curr.children[index]==null){
                return 0;
            }
            curr=curr.children[index];
        }
        return curr.count;
    }
}
class Solution
{
    public int klengthpref(String[] arr, int n, int k, String str)
    {
        Trie t=new Trie();
        for(String a:arr){
            t.insert(a);
        }
        if(k>str.length()){
            return 0;
        }
        return t.search(str,k);
        
    }
}