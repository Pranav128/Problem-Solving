//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
       return mergeSort(arr, 0, arr.length-1);
    }
    
    static long mergeSort(long arr[], int si, int ei)
    {
        if(si >= ei)
        {
            return 0  ; 
        }
        long count =0 ;
        int mid = si+(ei-si)/2 ;
        count += mergeSort(arr, si, mid);
        count += mergeSort(arr,mid+1, ei);
        
        count+= merge(arr,si,mid,ei);
        return count ;
    }
    static long merge(long arr[] , int si ,int mid, int ei)
    {
        long temp[] = new long[ei-si+1];
        long count = 0;
        int si1=si, si2 = mid+1 , ei1=mid , ei2 = ei , x= 0 ;
        
        while(si1 <= ei1 && si2 <= ei2)
        {
            if(arr[si1] <= arr[si2])
            {
                temp[x++] = arr[si1++];
            }
            else
            {
                temp[x++] = arr[si2++];
                count += mid - si1 + 1 ;
            }
        }
        while(si1 <= ei1)
        {
            temp[x++] = arr[si1++];
        }
         while(si2 <= ei2)
        {
            temp[x++] = arr[si2++];
        }
        for(int i=0;i<temp.length;i++)
        {
            arr[i+si] = temp[i];
        }
        return count ;
    }
    
}