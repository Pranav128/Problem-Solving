//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		
System.out.println("~");
}
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int k) 
    {
        ArrayList<Integer> ans =new  ArrayList<Integer>();
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        // for(int i=0;i<k;i++){
        //     pq.offer(arr[i][0]);
        // }
        for(int i=0;i<k;i++){
            for(int j=0;j<k;j++){
                pq.offer(arr[i][j]);
            }
        }
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        return ans;
    }
}