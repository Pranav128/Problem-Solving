//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        
System.out.println("~");
}
        
        
    }
}


// } Driver Code Ends


class Solution{
    static PriorityQueue<Integer>minHeap=new PriorityQueue<>();
    static PriorityQueue<Integer>maxHeap=new PriorityQueue<>(Collections.reverseOrder());
    public static void insertHeap(int num){
       maxHeap.offer(num);
       minHeap.offer(maxHeap.poll());
       if(minHeap.size()>maxHeap.size()){
            maxHeap.offer(minHeap.poll());
       }
    }
    //Function to balance heaps.
    public static void balanceHeaps(){}
    
    //Function to return Median.
    public static double getMedian(){
        return (minHeap.size()==maxHeap.size())?(minHeap.peek()+maxHeap.peek())/2.0:maxHeap.peek();
    }
}