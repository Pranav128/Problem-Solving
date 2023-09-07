//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        
        int index = -1 , count = 0 ;
        for(int i=0;i<n;i++)
        {
            int count_1 = m - binary(arr[i] , m ,1) ;
            if(count_1 > count)
            {
                count = count_1 ;
                index = i ;
            }
        }
        return index ;
    }
    public static int binary(int arr[] , int n , int target)
    {
        int si = 0 , ei = n-1 , ans = n ;
        while(si<=ei)
        {
            int mid = si+(ei-si)/2 ;
            if(arr[mid] >= target)
            {
                ans = mid ;
                ei = mid-1;
            }
            else
            {
                si = mid +1 ;
            }
        }
        return ans ;
    }
}