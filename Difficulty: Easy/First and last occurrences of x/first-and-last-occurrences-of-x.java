//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine().trim()); // Inputting the testcases

            String inputLine1[] = br.readLine().trim().split(" ");
            int n = inputLine1.length;
            int arr[] = new int[(int)(n)];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine1[i]);
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.firstAndLast(x, arr);

            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public ArrayList<Integer> firstAndLast(int x, int arr[]) {
        int first = binary(arr,0,arr.length-1,x,true);
        ArrayList<Integer> list = new ArrayList<>();
        if(first == -1){
            list.add(-1);
            return list;
        }
        int last=binary(arr,0,arr.length-1,x,false);
        list.add(first);
        list.add(last);
        return list;
        
    }
    public static int binary(int arr[],int si, int ei,int x,boolean first){
        int ans =-1;
        while(si<=ei){
            int mid = si+(ei-si)/2;
            if(arr[mid] < x){
                si=mid+1;
            }
            else if(arr[mid]>x){
                ei=mid-1;
            }
            else{
                ans=mid;
                if(first){
                    ei=mid-1;
                }
                else{
                    si=mid+1;
                }
            }
        }
        return ans;
    }
}
