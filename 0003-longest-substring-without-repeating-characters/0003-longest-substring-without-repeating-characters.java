class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        HashMap<Character,Integer> map= new HashMap<>();
        int len = 0, si =0 , ei = 0;
        while(ei < s.length())
        {
            if(map.containsKey(s.charAt(ei)))
            {
                si = Math.max(si , map.get(s.charAt(ei))+1);                
            }
            map.put(s.charAt(ei) ,  ei);
           len = Math.max(len, ei-si+1);
           ei++;
        }
        return len;
        
    }
}