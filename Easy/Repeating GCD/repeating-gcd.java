//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            long N = Long.parseLong(s1[0]);
            int x = Integer.parseInt(s1[1]);
            int y = Integer.parseInt(s1[2]);
            Solution ob = new Solution();
            String ans = ob.FindGcd(N, x, y);
            System.out.println(ans);           
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String FindGcd(long N, int x, int y)
    {
       int g = GCD(x,y);
       String ans ="";
       for(int i=0;i<g;i++)
       {
           ans+=N;
       }
       return ans;
    }
    public static int GCD(int a, int b)
    {
        if(b==0)
        {
            return a ;
        }
        return GCD(b,a%b);
    }
}