//{ Driver Code Starts
import java.io.*;
import java.util.*;


// } Driver Code Ends
class Solution {
    public int countIncreasing(int[] arr) {
        int j = 0 ;
        int count = 0;
        for(int i=0;i<arr.length-1;i++){
           if(arr[i+1]>arr[i]){
               count += (i+1-j);
           } 
           else{
               j=i+1;
           }
        }
    return count;    
        
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        for (int i = 0; i < t; i++) {
            String input = scanner.nextLine();
            String[] inputArray = input.split(" ");
            int[] arr = new int[inputArray.length];
            for (int j = 0; j < inputArray.length; j++) {
                arr[j] = Integer.parseInt(inputArray[j]);
            }

            Solution solution = new Solution();
            System.out.println(solution.countIncreasing(arr));
        }
        scanner.close();
    }
}

// } Driver Code Ends