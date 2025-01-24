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
            String input_line[] = read.readLine().trim().split("\\s+");
            int  N = Integer.parseInt(input_line[0]);
            Solution ob = new Solution();
            int ans = ob.countZeroes(N);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    public int countZeroes(int n) {
        int first = findFirstWithTrailingZeros(n);       // First number with at least N zeros
        int last = findFirstWithTrailingZeros(n + 1);    // First number with more than N zeros
        return last - first;                             // Count of numbers with exactly N zeros
    }

    // Binary search to find the first number with at least N trailing zeros
    private static int findFirstWithTrailingZeros(int n) {
        int si = 1, ei = n * 5; // Upper bound estimate for the search space
        int ans = -1;           // Default to -1 in case no number is found
        while (si <= ei) {
            int mid = si + (ei - si) / 2; // Avoid potential overflow
            int count = countZeros(mid);
            if (count >= n) {
                ans = mid; // Store the potential answer
                ei = mid - 1; // Move left to find the first occurrence
            } else {
                si = mid + 1; // Move right
            }
        }
        return ans;
    }

    // Function to count trailing zeros in factorial of a number
    private static int countZeros(int n) {
        int count = 0;
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
