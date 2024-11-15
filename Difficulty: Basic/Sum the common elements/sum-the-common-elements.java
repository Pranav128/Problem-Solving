//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class GFG {
public
  static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n1 = sc.nextInt();
      int n2 = sc.nextInt();
      int arr1[] = new int[n1];
      int arr2[] = new int[n2];
      for (int i = 0; i < n1; i++)
        arr1[i] = sc.nextInt();

      for (int i = 0; i < n2; i++)
        arr2[i] = sc.nextInt();

      Geeks obj = new Geeks();
      System.out.println(obj.commonSum(n1, n2, arr1, arr2));
    
System.out.println("~");
}
  }
}

// Position this line where user code will be pasted.

// } Driver Code Ends


// User function Template for Java

class Geeks {
public static int commonSum(int n1, int n2, int arr1[], int arr2[]) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < arr2.length; i++){
      set.add(arr2[i]);
    }
    int sum = 0;
    int mod = 1000000007;
    for(int i=0;i<arr1.length;i++){
        if(set.contains(arr1[i])){
            sum = (sum+(arr1[i]))%mod;
            set.remove(arr1[i]);
        }
    }
    return sum;
  }
}