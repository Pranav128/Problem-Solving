class Solution {
    public int majorityElement(int[] nums) {
        int count=0, ele=Integer.MIN_VALUE;
        for(int i:nums){
            if(count==0){
                ele=i;
            }
            if(i==ele){
                count++;
            }
            else{
                count--;
            }
        }
        return ele;
    }
}