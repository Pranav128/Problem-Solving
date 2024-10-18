class Solution {
    public int mostFrequent(int[] nums, int key) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==key){
                map.put(nums[i+1] , map.getOrDefault(nums[i+1],0)+1 );
            }
        }
        int ans = 0 ;
        int finalAns = 0;
        for(Integer key2 : map.keySet()){
            if(map.get(key2) > ans ){
                ans=map.get(key2);
                finalAns = key2;
            }
        }
        return finalAns;
    }
}