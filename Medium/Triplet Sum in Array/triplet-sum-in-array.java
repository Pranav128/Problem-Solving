//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int X = Integer.parseInt(inputLine[1]);
		    int A[] = new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        A[i] = Integer.parseInt(inputLine[i]);
		    }
		    Solution ob=new Solution();
		    boolean ans = ob.find3Numbers(A, n, X);
		    System.out.println(ans?1:0);
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static boolean find3Numbers(int arr[], int n, int x) {
        if(n<3)
        {
            return false;
        }
        if(n==3)
        {
            return (arr[0]+arr[1]+arr[2])==x ;
        }
        
        Arrays.sort(arr);
        for(int i=0;i<n-3;i++)
        {
            int j=i+1, k=n-1 ;
            while(j<k)
            {
                if(arr[i]+arr[j]+arr[k] == x)
                {
                    return true;
                }
                else if( (arr[j]+arr[k]) < (x-arr[i]) )
                {
                    j++;
                }
                else
                {
                    k--;
                }
            }
        }
        return false ;
    
    }
}
