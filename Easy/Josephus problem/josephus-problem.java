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
		    
		    
		}
		
	}
}


// } Driver Code Ends


class Solution
{
   public int josephus(int n, int key)
    {
        LinkedList<Integer> ll = new LinkedList<>();
		
		for(Integer i=1 ;i<=n ;i++)
		{
			ll.add(i);
		}
		
		int index =0;
		while(ll.size() > 1)
		{
			index = (index + key -1 ) % ll.size();
			ll.remove(index);
		}
		return ll.peek();
    }

}

