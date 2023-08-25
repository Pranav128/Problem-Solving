//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.countRevPairs(N, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countRevPairs(int N, int arr[]) {
        return mergesort(arr,0,N-1);
    }
     public static int mergesort(int arr[],int si, int ei)
    {
        int count = 0;
        if(si>=ei)
        {
            return count ;
        }
        int mid = si+(ei-si)/2 ;
        count += mergesort(arr, si, mid);
        count += mergesort(arr, mid+1, ei);
        count += conquer(arr,si,mid,ei);
        return count ;
    }
        
    public static int conquer(int arr[],int si, int mid,int ei)
    {
        int count =0 ;
        int right = mid+1 ;
        for(int i = si ;i<=mid ;i++)
        {
            while(right<=ei && arr[i] > 2*(long)arr[right])
            {
                right++;
            }
            count += right-(mid+1);
        }
        
        int temp[] = new int[ei-si+1];
        int si1 = si ;
        int si2 = mid+1 ,x=0;
        while(si<=mid && si2<=ei)
        {
            if(arr[si] <= arr[si2])
            {
                temp[x++] = arr[si++]; 
            }
            else
            {
                temp[x++] = arr[si2++];
            }
        }
        while(si<=mid)
        {
            temp[x++] = arr[si++]; 
        }
        while(si2<=ei)
        {
            temp[x++] = arr[si2++]; 
        }
        for(int i=0;i<temp.length;i++)
        {
            arr[i+si1] = temp[i];
        }
        return count ;
    }
}