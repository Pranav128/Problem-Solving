//{ Driver Code Starts
//Initial Template for Java



//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java



class Solution
{
    //sliding window (0(N^2))
    long countTriplets(long arr[], int n,int sum)
    {
        Arrays.sort(arr);
        long ans = 0 ;
        for(int i=0 ;i<n-2;i++)
        {
            int j=i+1 , k=n-1 ;
            long target = sum - arr[i] ;
            while(j<k)
            {
                if(arr[j]+arr[k] < target)
                {
                    ans += (k-j) ; 
                    j++;
                }
                else if(arr[j]+arr[k] >= target)
                {
                    k--;
                }
            }
        }
        return ans ;
    
    }
    
    
    
    //Brute Forece
    long countTriplets2(long arr[], int n,int sum)
    {
        int count = 0;
        for(int i=0 ;i<n;i++)
        {
            for(int j=i+1 ;j<n;j++)
            {
                for(int k=j+1;k<n;k++)
                {
                    if(arr[i]+arr[j]+arr[k] < sum)
                    {
                        count ++ ;
                    }
                }
            }
        }
        return count ;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int k =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
//            String line2 = br.readLine();
//            String[] a2 = line2.trim().split("\\s+");
//            long b[] = new long[m];
//            for (int i = 0; i < m; i++) {
//                b[i] = Long.parseLong(a2[i]);
//            }
            Solution ob = new Solution();
            long ans=ob.countTriplets(a,n,k);
            System.out.println(ans);
        }
    }
}




// } Driver Code Ends