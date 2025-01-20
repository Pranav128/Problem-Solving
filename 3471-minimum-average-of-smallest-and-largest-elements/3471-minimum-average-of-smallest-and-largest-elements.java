class Solution {
    public double minimumAverage(int[] nums) {
        double ans=Integer.MAX_VALUE;
        int i=0,j=nums.length-1;
        Arrays.sort(nums);
        while(i<j){
            double temp=(nums[i]+nums[j])/2.0;
            ans=Math.min(ans,temp);
            i++;
            j--;
        }
        return ans;
    }
}