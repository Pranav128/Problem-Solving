class Solution {
    //Kadane's Algorithm
    public int maxSubArray(int[] nums) 
    {
        int ans = nums[0] , previous = nums[0];
        for(int i=1 ; i<nums.length;i++)
        {
            previous = Math.max(nums[i] , previous+nums[i]);
            ans = Math.max(ans, previous);
        }
        return ans ;
        
    }
}