//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.canReach(A,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int canReach(int[] A, int N) {
        return minJumps(A)==-1?0:1;
    }
    static int minJumps(int[] arr){
        int n = arr.length ;
        if(n <= 1)
        {
            return 0;
        }
        if(arr[0] == 0)
        {
            return -1 ;
        }
        int jump =  1 , maxReach=arr[0] , steps = arr[0] ;
        for(int i=1 ;i<n ;i++)
        {
            if(i == n-1)
            {
                return jump ;
            }
            maxReach = Math.max(maxReach , arr[i]+i);
            steps -- ;
            if(steps == 0)
            {
                jump++ ;
                if(i >= maxReach) //imp
                {
                    return -1 ;
                }
                steps = maxReach - i ;
            }
         }
         return -1 ;
    }
};