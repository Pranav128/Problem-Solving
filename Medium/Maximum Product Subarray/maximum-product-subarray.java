//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] nums, int n) {
      long front = 0, back =0 , ans = Integer.MIN_VALUE;
      for(int i=0 ;i<nums.length;i++)
        {
            if(front == 0)front =1 ;
            if(back == 0 )back = 1;
            front *= nums[i];
            back *= nums[nums.length-1-i];
            ans = Math.max(ans, Math.max(front,back));
        }
      return ans ;
    }
}