class Solution {
    public int minimumSum(int n) {
        int nums[] = new int[4];
        int i=0;
        while(n>0){
            nums[i++]=n%10;
            n/=10;
        }
        Arrays.sort(nums);
        int first = nums[0]*10+nums[2];
        int second = nums[1]*10+nums[3];
        return first+second;
    }
}