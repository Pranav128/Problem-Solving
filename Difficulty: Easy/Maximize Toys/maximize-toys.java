//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String st[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(st[0]);
            int K = Integer.parseInt(st[1]);
            String st1[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(st1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.toyCount(N, K, arr));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    //Approach 1:Using priority queue
    static int toyCount(int N, int K, int arr[])
    {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i:arr){
            pq.offer(i);
        }
        int ans=0;
        while(!pq.isEmpty()){
            int polled=pq.poll();
            if(polled<=K){
                ans++;
                K-=polled;
            }
        }
        return ans;
    }
    //Approach 2: Using sorting
    static int toyCount2(int N, int K, int arr[])
    {
        Arrays.sort(arr);
        int ans=0;
        for(int i:arr){
            if(i<=K){
                ans++;
                K-=i;
            }
        }
        return ans;
    }
}