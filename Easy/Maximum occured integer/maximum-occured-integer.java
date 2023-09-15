//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class Main {

    	public static void main (String[] args) throws IOException{
    	    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    
		    //taking size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int L[] = new int[n];
		    int R[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to array L
		    for(int i=0; i<n; i++){
		        L[i]=Integer.parseInt(inputLine[i]);
		    }
		    inputLine = br.readLine().trim().split(" ");
		    int maxx = Integer.MIN_VALUE;
		    
		    //adding elements to array R
		    for(int i=0; i<n; i++){
		        R[i]=Integer.parseInt(inputLine[i]);
		        if(R[i] > maxx){
		            maxx=R[i];
		        }
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling maxOccured() function
		    System.out.println(obj.maxOccured(L, R, n, maxx));
		}
	}
	
}



// } Driver Code Ends
// L[] and R[] are input ranges
// n : size of array
// maxx: maximum element in R[]
// arr[]: declared globally with size equal to 1000000

class Solution{

 public static int maxOccured(int L[], int R[], int n, int maxx)
    {
        int arr[] = new int[1000000];
        for(int i=0;i<n;i++)
        {
            arr[L[i]]++;
            arr[R[i]+1]--;
        }
        maxx = arr[0];
        int res = 0 ;
        for(int  i=1 ;i<arr.length;i++)
        {
            arr[i] += arr[i-1] ;
            if(maxx < arr[i])
            {
                maxx = arr[i];
                res = i ;
            }
        }
        return res ;
    }
    
    //Brute force not too much optimized
    public static int maxOccured2(int L[], int R[], int n, int maxx)
    {
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int i=0;i<n;i++)
       {
           for(int j=L[i] ;j<=R[i];j++)
           {
               map.put(j , map.getOrDefault(j,1)+1);
           }
       }
       maxx = Integer.MIN_VALUE ;
       for(Integer i : map.keySet())
       {
           if(map.get(i) > maxx)
           {
               maxx = i ;
           }
       }
       return maxx;
    }
    
}

//{ Driver Code Starts.

// } Driver Code Ends