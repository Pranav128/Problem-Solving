class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0, count = 0;
        for(int i : nums)
        {
            if(i ==1)
            {
                count ++;
            }
            else
            {
                ans = Math.max(ans,count);
                count =0;
            }
        }
        if(count != 0)
        {
            ans = Math.max(ans, count );
        }
        return ans ;
    }
}