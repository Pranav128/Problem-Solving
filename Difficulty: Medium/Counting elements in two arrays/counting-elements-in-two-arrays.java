//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.countEleLessThanOrEqual(a, b);
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// Complete the function given below
class Solution {
    public static ArrayList<Integer> countEleLessThanOrEqual(int a[], int b[]) {
        Arrays.sort(b);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<a.length;i++){
            int si=findFloor(b,a[i]);
            list.add(si);
        }
        return list;
    }
    public static int findFloor(int b[],int x){
        int si=0,ei=b.length-1;
        while(si<=ei){
            int mid = si+(ei-si)/2;
            if(b[mid] <= x){
                si=mid+1;
            }
            else{
                ei=mid-1;
            }
        }
        return si;
    }
}