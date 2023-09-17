class Solution {
    public int numSubarrayBoundedMax(int[] arr, int l, int r) {
         int count=0, i=0, j=0, window=0, n=arr.length;
         while(j<n)
        {
            if(arr[j] >= l && arr[j] <=r)
            {
                window=j-i+1;
            }
            else if(arr[j] > r)
            {
              window=0;
              i=j+1;
            }
            count +=window;
            j++;
        }
        return count;
    }
}