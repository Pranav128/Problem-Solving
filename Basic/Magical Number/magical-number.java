//{ Driver Code Starts
import java.util.*;

class Magic
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
                  arr[i] = sc.nextInt();
            
            GfG gfg = new GfG();  
            System.out.println(gfg.binarySearch(arr, 0, n-1));
        }
    }
}

// } Driver Code Ends


class GfG
{
    public static int binarySearch(int arr[], int si, int ei)
    {
        while(si<=ei)
        {
            int mid = si+(ei-si)/2 ;
            if(mid == arr[mid])
            {
                return mid ;
            }
            else if(arr[mid] > mid)
            {
                ei= mid-1 ;
            }
            else
            {
                si = mid+1 ;
            }
        }
        return -1 ;
    }
}
