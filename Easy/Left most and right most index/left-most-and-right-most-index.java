//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

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
            
            Solution obj = new Solution();
            pair ans = obj.indexes(a, k);
            if (ans.first == -1 && ans.second == -1)
                System.out.println(-1);
            else
                System.out.println(ans.first+" "+ans.second);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

/*
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/

class Solution {
    
    public pair indexes(long nums[], long target)
    {
        // pair p = new pair();
            long first =  search(nums , target , true);
	        long second =  search(nums , target , false);
	        return new pair(first, second) ;
    }
    public static long search(long arr[] ,  long target , boolean smaller)
	    {
	        int ei = arr.length-1 ,si = 0, ans =-1 ;
	        
	        while(si <= ei)
	        {
	            int mid = si + (ei - si)/2; 
	            
	            if(arr[mid] < target)
	            {
	                si = mid + 1 ;
	            }
	            else if(arr[mid] > target)
	            {
	                ei = mid -1 ;
	            }
	            else
	            {
	                ans = mid ;
	                if(smaller)
	                {
	                    ei = mid -1 ;
	                }
	                else
	                {
	                    si = mid + 1;
	                }
	            }
	        }
	        
	        return ans ;
	    }   
}