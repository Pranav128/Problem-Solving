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
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    /*  this works till 187 /580 test cases so just change in pos and midLoc statement
       int median(int arr[][], int r, int c) {
       int min = arr[0][0] ;
       int max = arr[0][c-1] ;
       
       for(int i=1 ;i<r ;i++)
       {
           max = Math.max(max, arr[i][c-1]);
           min = Math.min(min , arr[i][0]);
       }
       
       int location = (r*c+1)/2 ;
       
       while(min < max)
       {
           int mid = (min+max)/2 ;
           int midLoc = 0;
           
           for(int i=0 ;i<r ;i++)
           {
            //   int pos = Arrays.binarySearch(arr[i] , mid)+1 ;
            //   midLoc = Math.abs(pos) ;
            
               midLoc += Math.abs(Arrays.binarySearch(arr[i] , mid)+1) ;
           }
           if(location > midLoc)
           {
               min = mid + 1 ;
           }
           else
           {
               max = mid ;
           }
       }
       return min ;
    }
    */
    //gfg
    int median1(int arr[][], int r, int c) {
       int min = arr[0][0] ;
       int max = arr[0][c-1] ;
       
       for(int i=1 ;i<r ;i++)
       {
           max = Math.max(max, arr[i][c-1]);
           min = Math.min(min , arr[i][0]);
       }
       
       int location = (r*c+1)/2 ;
       
       while(min < max)
       {
           int mid = (min+max)/2 ;
           int midLoc = 0;
           
           for(int i=0 ;i<r ;i++)
           {
              int pos = Arrays.binarySearch(arr[i] , mid) ;
               if (pos < 0){
                    pos = Math.abs(pos) - 1;
               }
                // If element is found in the array it
                // returns the index(any index in case of
                // duplicate). So we go to last index of
                // element which will give  the number of
                // elements smaller than the number
                // including the searched element.
                else {
                    while (pos < arr[i].length
                           && arr[i][pos] == mid)
                        pos += 1;
                }
              midLoc += pos ;
            
             //  midLoc += Math.abs(Arrays.binarySearch(arr[i] , mid)+1) ;
           }
           if(location > midLoc)
           {
               min = mid + 1 ;
           }
           else
           {
               max = mid ;
           }
       }
       return min ;
    }
    //striver
    public static int countSmallerThanMid(int[] A, int mid, int n) {
    int l = 0, h = n - 1;
    while (l <= h) {
      int md = (l + h) >> 1;
      if (A[md] <= mid) {
        l = md + 1;
      } else {
        h = md - 1;
      }
    }
    return l;
  }
   int median(int[][] A, int row, int col) {
    int low = A[0][0];
    int high = A[0][col-1];
     for(int i=1 ;i<row ;i++)
       {
           high = Math.max(high, A[i][col-1]);
           low = Math.min(low , A[i][0]);
       }
    int n = row;
    int m = col;
    while (low <= high) {
      int mid = (low + high) >> 1;
      int cnt = 0;
      for (int i = 0; i < n; i++) {
        cnt += countSmallerThanMid(A[i], mid, col);
      }
      if (cnt <= (n * m) / 2)
        low = mid + 1;
      else
        high = mid - 1;
    }
    return low;
  }
}