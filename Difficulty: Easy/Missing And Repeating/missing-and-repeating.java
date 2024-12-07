//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList; // Import ArrayList
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            // Get the result as an ArrayList<Integer>
            ArrayList<Integer> ans = new Solution().findTwoElement(arr);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>(2);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int abs_val = Math.abs(arr[i]);
            if (arr[abs_val - 1] > 0) {
                arr[abs_val - 1] = -arr[abs_val - 1];
            } else {
                ans.add(abs_val); // Store the repeating element
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                ans.add(i + 1); // Store the missing element
            }
        }
        return ans;
    }
    
    int[] findTwoElement2(int a[]){
        int n=a.length;
        int freq[] = new int[n+1];
        for(int i=0;i<n;i++){
            freq[a[i]]++;
        }
        int missing = -1, repeating = -1 ;
        for(int i =1 ;i<=n;i++){
            if(freq[i] == 2){
                repeating = i ;
            }
            else if(freq[i] ==0){
                missing = i ;
            }
            if(repeating !=-1 && missing != -1){
                break ;
            }
        }
        return new int[]{repeating , missing} ;
    }
}