//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
       int ans=-1;
        HashMap<Character, Integer> map = new HashMap<>();
        
        int i=0,j=0;
        while(j<s.length()){
            
            int count =map.getOrDefault(s.charAt(j),0);
            map.put(s.charAt(j), count +1);
            
            if(map.size()==k){
                ans= Math.max(ans, j-i+1);
            }
            else if(map.size()>k){
                while(map.size()>k){
                    
                    
                    int freq = map.get(s.charAt(i));
                    map.put(s.charAt(i), freq-1);
                    if(map.get(s.charAt(i))==0){
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
}