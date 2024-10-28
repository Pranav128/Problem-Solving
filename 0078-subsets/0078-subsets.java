class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> al = new ArrayList<>();
        int len = nums.length;
        int max = (int) Math.pow(2,len);
        for(int i=0;i<max;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0;j<len;j++){
                if( (i&(1<<j)) != 0 ){
                    temp.add(nums[j]);
                }
            }
            al.add(temp);
        }
        return al;
    }
}