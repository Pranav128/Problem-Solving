//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine().trim());
            
            
            int[] A = IntArray.input(br, N);
            
            
            int Key;
            Key = Integer.parseInt(br.readLine().trim());
            
            Solution obj = new Solution();
            boolean res = obj.Search(N, A, Key);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean Search(int N, int[] nums, int target) {
        int idx = search(nums,0,N-1,target);
        return idx != -1 ;
    }
   public static int search(int arr[], int si, int ei, int key)
    {
        while(si <= ei)
        {
            int mid = si+(ei-si)/2 ;
            
            if(arr[mid] == key)
            {
                return mid ;
            }
            else if(arr[si]==arr[mid] && arr[mid] == arr[ei])
            {
                si++;
                ei--;
                continue ;
            }
            else if( arr[si] <= arr[mid])
            {
                if(key >= arr[si] && key <= arr[mid] )
                {
                    ei = mid-1 ;
                }
                else
                {
                    si = mid + 1 ;
                }
            }
            else
            {
               if(key >= arr[mid] && key <= arr[ei] )
                {
                    si = mid+1 ;
                }
                else
                {
                    ei = mid - 1 ;
                }
            }
        }
        return -1 ;
    }
}
        
