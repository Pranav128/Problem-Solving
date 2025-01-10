//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            
            Solution obj = new Solution();
            boolean ans = obj.isPossible(a,b);
            if(ans==true)
                System.out.println(1);
            else{
                System.out.println(0);
            }
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    public static boolean isPossible(int a, int b){
        // if(a==2&&b==3 || a==3&&b==2 || a==1&&b==2 || a==2&&b==1){
        //     return true;
        // }
        if(a+b==5 || a+b==3){
            return true;
        }
        return false;
    }
}