//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxArea(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    public long maxArea(int arr[]) {
    
        int si=0, ei=arr.length-1;
        int area = 0;
        while(si<ei){
            int h = Math.min(arr[si],arr[ei]);
            int w = ei-si;
            area = Math.max(area,h*w);
            
            if(arr[si] > arr[ei]){
                ei--;
            }
            else{
                si++;
            }
        }
        return area;
    }
}