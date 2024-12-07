class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left];
    }
    public static int peekIndex(int[] arr){
        int si = 0 ;
        int ei = arr.length-1 ;
        while(si < ei ){
            int mid = si + (ei -  si)/2 ;
            if(arr[mid] > arr[mid+1]){
                ei = mid ;
            }
            else {
                si = mid +1 ;
            }
        }
        return si ;
    }
}