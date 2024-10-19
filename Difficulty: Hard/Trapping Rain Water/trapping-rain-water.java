//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().trappingWater(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    public long trappingWater(int arr[]) {
        int n = arr.length;
        int maxLeft = Integer.MIN_VALUE;
        int maxRight = Integer.MIN_VALUE;
        long ans =0;
        int si=0;
        int ei= n-1;
        while(si<ei){
            maxLeft=Math.max(maxLeft, arr[si]);
            maxRight=Math.max(maxRight, arr[ei]);
            ans += maxLeft < maxRight ? 
                maxLeft - arr[si++] : maxRight - arr[ei--];
        }
        return ans;
    }
    
}
