//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int x;
            x = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            boolean res = obj.findPair(arr, x);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public boolean findPair2(int[] arr, int x) {
        Arrays.sort(arr);
        int si=0,ei=1;
        while(si<arr.length && ei<arr.length){
            if(si!=ei && arr[ei]-arr[si] == x){
                return true;
            }
            else if(arr[ei]-arr[si] < x){
                ei++;
            }
            else{
                si++;
            }
        }
        return false;
    }
     public boolean findPair(int[] arr, int x) {
         HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
         for(int i:arr){
             map.put(i,map.getOrDefault(i,0)+1);
         }
         for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(x==0){
                if(entry.getValue()>=2){
                    return true;
                }
            }
            else{
                if(map.containsKey(entry.getKey()+x)){
                    return true;
                }
            }
         }
         return false;
     }
    //   public boolean findPair(int[] arr, int x) {
    //       Arrays.sort(arr);
    //       int n=arr.length;
    //       for(int i=0;i<n;i++){
    //         int a = arr[i] - x ;
    //         int b = arr[i] + x;
            
    //         if(Arrays.binarySearch(arr,i+1,n-1,a) != -1)
    //           return true;
    //         if(Arrays.binarySearch(arr,i+1,n-1,a) != -1)
    //           return true;
    //       }
    //       return false;
    //   }
}






