class Solution {
    //Kadane's Algorithm
    public int maxSubArray(int[] nums) 
    {
        int ans =Integer.MIN_VALUE  , previous = 0;
        for(int i=0 ; i<nums.length;i++)
        {
            previous +=  nums[i];
            previous = Math.max(nums[i] , previous);
            ans = Math.max(ans, previous);
        }
        return ans ;
        
    }
}