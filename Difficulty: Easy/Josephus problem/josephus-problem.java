//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Recursion {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();//testcases
		while(T-->0)
		{
		    Solution obj=new Solution();
		    
		    int n,k;
		    //taking input n and k
		    n=sc.nextInt();
		    k=sc.nextInt();
		    
		    //calling josephus() function
		    System.out.println(obj.josephus(n,k));
		    
		    
		
System.out.println("~");
}
		
	}
}


// } Driver Code Ends


class Solution
{
   public int josephus(int n, int k)
    {
      return jos(n,k)+1;
    }
    public static int jos(int n, int k){
         if(n==1){
           return 0;
       }
       return (jos(n-1,k)+k)%n;
    }

}

