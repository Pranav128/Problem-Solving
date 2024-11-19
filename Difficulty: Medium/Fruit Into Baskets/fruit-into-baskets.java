//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            // Convert ArrayList to array
            Integer[] arr = new Integer[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call totalFruits method and print result
            Integer ans = ob.totalFruits(arr);
            System.out.println(ans);

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(Integer[] arr){
        int count1=0,count2=0;
        int basket1=0, basket2=0;
        int maxLen = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(basket1==0){
                basket1=arr[i];
                count1++;
            }
            else if(arr[i]==basket1){
                count1++;
            }
            else if(basket2==0){
                basket2=arr[i];
                count2++;
            }
            else if(arr[i]==basket2){
                count2++;
            }
            else{
                basket1=basket2;
                count1=count2;
                basket2=arr[i];
                count2=1;
            }
            maxLen = Math.max(maxLen, count1 + count2);
        }
        return maxLen;
    }
    
    public static int totalFruits2(Integer[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        int i=0,j=0,ans=0;
        while(j<arr.length){
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
            while(map.size()>2){
                int value=map.get(arr[i]);
                map.put(arr[i],value-1);
                if(value==1){
                    map.remove(arr[i]);
                }
                ans=Math.max(ans,j-i+1);
                i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}