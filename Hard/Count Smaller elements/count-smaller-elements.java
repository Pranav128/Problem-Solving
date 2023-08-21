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
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int[] ans = new Solution().constructLowerArray(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution 
{
    class pair
    {
        int val ;
        int idx ;
       public pair(int val, int idx)
        {
            this.val = val ;
            this.idx = idx ;
        }
    }
    
    int[] constructLowerArray(int[] arr, int n) 
    {
        int count[] = new int[n];
        Arrays.fill(count,0);
        
//base case   
        if(arr == null || n== 0)
        {
            return count ;
        } 
       
        pair p[] = new pair[n];
        for(int i=0;i<n;i++)
        {
            p[i] = new pair(arr[i] ,i) ;
        }

        mergeSort(p,count, 0, n-1);
        return count ;
    }
    
    public static void mergeSort(pair p[],int count[],int si, int ei)
    {
        if(si < ei)
        {

        int mid = si + (ei-si)/2 ;
        mergeSort(p,count,si,mid);
        mergeSort(p,count,mid+1,ei);

        merge(p,count,si,mid,ei);
        }
    }
    public static void merge(pair p[],int count[], int si, int mid,int ei)
    {
        int si1 = si , si2 = mid+1 , x=0;
        pair temp[] = new pair[ei-si+1];

        while(si1<=mid && si2<=ei)
        {
            if(p[si1].val > p[si2].val)
            {
                count[p[si1].idx] += ei-si2+1 ;
                temp[x++] = p[si1++] ;
            }
            else
            {
               temp[x++] = p[si2++];
            }
        }
        while(si1<=mid)
        {
            temp[x++]=p[si1++];
        }
        while(si2<=ei)
        {
            temp[x++]=p[si2++];
        }
        for(int i=0;i<temp.length;i++)
        {
            p[i+si] = temp[i];
        }
    }
      
}