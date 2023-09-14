class Solution {
    public int maxProduct(int[] nums){
        int front = 0 , back = 0, ans = Integer.MIN_VALUE;
        for(int i=0 ;i<nums.length;i++)
        {
            if(front == 0)front =1 ;
            if(back == 0 )back = 1;
            front *= nums[i];
            back *= nums[nums.length-1-i];
            ans = Math.max(ans, Math.max(front,back));
        }return ans ;
}}