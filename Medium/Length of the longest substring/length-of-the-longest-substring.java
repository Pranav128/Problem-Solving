//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String s)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        int si = 0, ei =0 , len =0 , n=s.length();
        while(ei < n)
        {
            if(map.containsKey(s.charAt(ei)))
            {
                si = Math.max(si , map.get(s.charAt(ei))+1);
            }
            map.put(s.charAt(ei) , ei);
            len = Math.max(len, ei-si+1);
            ei++;
        }
        return len ;
        
    }
}