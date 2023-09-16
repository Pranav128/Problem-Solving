//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Compute obj = new Compute();
            System.out.println(obj.maxSumWithK(a, n, k));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long maxSumWithK(long arr[], long n, long k)
    {
       long maxSum = Integer.MIN_VALUE , prefixSum = 0  , front = 0 ;
       int i =0 , j = 0;
       while(j<n)
       {
           prefixSum += arr[j] ;
           if(j-i+1 == k)
           {
               maxSum = Math.max(maxSum , prefixSum) ;
           }
           else if(j-i+1 > k)
           {
               maxSum =  Math.max(maxSum , prefixSum) ;
               front += arr[i] ;  //intially was Zero so first increment to front vlaue then chedck it
               i++  ;
               if(front < 0)
               {
                   prefixSum -= front ;
                   front  = 0 ;
                   maxSum =  Math.max(maxSum , prefixSum) ;
               }
           }
           j++ ;
       }
       return maxSum ;
    }
}