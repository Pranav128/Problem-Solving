//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] fruits = new int[N];
            for (int i = 0; i < N; i++) fruits[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.totalFruits(N, fruits);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(int N, int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int i=0 ,j =0 , ans =0 ;
        while(j<N)
        {
            map.put(fruits[j] , map.getOrDefault(fruits[j],0)+1);
            while(map.size()>2)
            {
                int currentFreq = map.get(fruits[i])-1;
                map.put(fruits[i] , currentFreq);
                if(currentFreq == 0)
                {
                    map.remove(fruits[i]);
                }
                i++;
            }
            ans = Math.max(ans , j-i+1);
            j++;
        }
        return ans;
    }
}