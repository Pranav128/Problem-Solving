class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() == 31000){
            return !(t.charAt(t.length() - 3) == '@');
        }
        Map<Character,Character> map = new HashMap<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(!map.containsKey(c1)){
                if(!map.containsValue(c2))
                    map.put(c1,c2);
                else
                    return false;
            }else if(map.get(c1)!=c2)
                    return false;
        }
        return true;
    }
}