//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Array
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");
            
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(st[i]);
              
            System.out.println(new Solution().minNumber(arr,0,n-1));
        
System.out.println("~");
}
    }
    
}
// } Driver Code Ends


class Solution
{
    //Function to find the minimum element in sorted and rotated array.
    static int minNumber(int arr[], int low, int high)
    {
        if(arr[low]<arr[high]){
            return arr[0];
        }
        if(low==high){
            return arr[low];
        }
        int peek = findPeak(arr,low,high);
        if(peek == -1){
            return -1;
        }
        return arr[peek+1];
    }
    static int findPeak(int arr[],int si,int ei){
        
        while(si<=ei){
            int mid = si + (ei - si )/2 ;
            if( (mid < ei) && (arr[mid] > arr[mid+1]) ){
                return mid ;
            }
            if( (si < mid) && (arr[mid] < arr[mid-1])){
                return mid-1 ;
            }
            if(arr[si] >= arr[mid] ){
                ei = mid -1 ;
            }
            else{
                si = mid + 1;
            }
        }
        return -1;
    }
}