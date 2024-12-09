//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
class KthSmallestElement{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=Integer.parseInt(sc.next());
		while(t>0)
		{
			int n=Integer.parseInt(sc.next());
			int[][] a=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
    				a[i][j]=Integer.parseInt(sc.next());
    		
			int k=Integer.parseInt(sc.next());
		    Solution ob = new Solution();
		    System.out.println(ob.kthSmallest(a,n,k));
		    
		    t--;
		
System.out.println("~");
}
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
	public static int kthSmallest2(int[][]arr,int n,int k)
	{
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(pq.size()<k){
                    pq.offer(arr[i][j]);
                }
                else{
                    if(pq.peek()>arr[i][j]){
                        pq.poll();
                        pq.add(arr[i][j]);
                    }
                }
            }
        }
        return pq.peek();
    }
    public static int kthSmallest(int[][] arr,int n, int k) {
        int min=arr[0][0], max=arr[n-1][n-1];
        while(min!=max){
            int mid = min+(max-min)/2;
            int count = findMin(arr,mid);
            if(count<k){
                min=mid+1;
            }
            else{
                max=mid;
            }
        }
        return min;
    }
    public static int findMin(int arr[][],int key){
        int si=0, ei=arr.length-1;
        int count=0;
        while(si<arr.length && ei>=0){
            if(arr[si][ei] <= key){
                count += ei+1;
                si++;
            }
            else{
                ei--;
            }
        }
        return count;
    }
}