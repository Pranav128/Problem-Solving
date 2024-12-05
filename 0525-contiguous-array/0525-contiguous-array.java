class Solution {
    public int findMaxLength(int[] nums) {
        int si=0,prefix=0, max_len=0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            nums[i] = (nums[i]==0)?-1:1;
        }

        for(int i=0;i<nums.length;i++){
            prefix += nums[i];
            if(prefix == 0){
                max_len =Math.max(max_len,i+1);             
            }
            if(map.containsKey(prefix)){
                max_len =Math.max(max_len,i-map.get(prefix));
            }
            else{
                map.put(prefix,i);
            }
        }
        return max_len;
    }
}
