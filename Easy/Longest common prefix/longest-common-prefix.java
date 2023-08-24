//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            String s1 = sc.next();
            String s2 = sc.next();
            Solution obj = new Solution();
            int[] ans=obj.longestCommonPrefix(s1,s2);
            if(ans[0] == -1)
                System.out.println(ans[0]);
            else 
                System.out.println(ans[0]+" "+ans[1]);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int[] longestCommonPrefix(String s1, String s2){
       int i =0 ;
       int first =-1 , second =-1 ;
       
       for(int  j=0;j<s2.length();j++)
       {
           if(s1.charAt(i)==s2.charAt(j))
           {
               second = Math.max(second,i);
               i++;
           }
           else
           {
               i =0 ;
               if(s1.charAt(i)==s2.charAt(j))
               {
                   second = Math.max(second, i);
                   i++;
               }
           }
       }
       if(second > -1)
       {
           first = 0 ;
       }
       return new int[]{first,second};
    }
}

   
        
     