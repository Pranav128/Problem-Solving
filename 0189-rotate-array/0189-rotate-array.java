class Solution {
   public void rotate(int arr[] , int k) 
   {
       k = k%arr.length;
       reverse(arr,0,arr.length-1);
       reverse(arr,0,k-1);
       reverse(arr,k,arr.length-1);
   }
   public static void reverse(int arr[],int si, int ei)
   {
       while(si<ei)
       {
           int temp = arr[si];
           arr[si] = arr[ei];
           arr[ei] = temp ;
           si++;
           ei--;
       }
   }
}