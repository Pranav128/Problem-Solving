class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0||nums==null){
            return 0;
        }
        int ans =1;
        // Set<Integer> set =  Arrays.stream(nums).boxed().collect(Collectors.toSet());
        HashSet<Integer> set = new HashSet<>();
        for(Integer i : nums){
            set.add(i);
        }

        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int temp = 1;
                while(set.contains(nums[i]+temp)){
                    temp++;
                }
                ans = Math.max(ans,temp);
            }
        }
        return ans;
    }
}