class Solution {
    public int findPairs(int[] arr, int x) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int count=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(x==0){
                if(entry.getValue() >= 2){
                    count++;
                }
            }
            else{
                if(map.containsKey(entry.getKey()+x)){
                    count++;
                }
            }
        }
        return count;
    }
}