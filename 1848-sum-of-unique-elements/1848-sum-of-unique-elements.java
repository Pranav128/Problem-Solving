class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(Integer i: nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int sum =0;
        // System.out.println(map);
        for(Integer key : map.keySet()){
            if(map.get(key)==1){
                sum = sum+(key);
            }
        }
        return sum;
    }
}