class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i =0 ,j=0 , sum=0, ans = Integer.MAX_VALUE ;
        while(j<nums.length)
        {
            sum +=nums[j++];
            while(sum >= target)
            {
                ans = Math.min(ans, j-i); // cant use j-i+1 becuse we already increament j ;
                sum -= nums[i++];

            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans ;
    }
}