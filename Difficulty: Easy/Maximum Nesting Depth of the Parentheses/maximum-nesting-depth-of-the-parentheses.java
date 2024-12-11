//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            sc.nextLine();
            String s;
            s = sc.next();
            
            Solution obj = new Solution();
            int res = obj.maxDepth(s);
            
            System.out.println(res);
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    public static int maxDepth(String s) {
        int ans=0,count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                ans=Math.max(ans,++count);
            }
            else if(s.charAt(i)==')'){
                count--;
            }
        }
        return ans;
    }
}
        
