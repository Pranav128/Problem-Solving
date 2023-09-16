class Solution {
    public int totalFruit(int[] fruits) {
        int n= fruits.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int i =0 , j = 0 ;
        while(j<n)
        {
            map.put(fruits[j] , map.getOrDefault(fruits[j],0)+1);
            while(map.size()>2)
            {
                int currentFreq = map.get(fruits[i])-1;
                map.put(fruits[i] , currentFreq) ;
                if(currentFreq == 0)
                {
                    map.remove(fruits[i]);
                }
                i++;
            }
            ans = Math.max(ans , j-i+1);
            j++ ;
        }
        return ans ;
    }
    
}