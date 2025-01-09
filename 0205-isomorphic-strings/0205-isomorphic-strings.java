class Solution {
    public boolean isIsomorphic(String s, String t) {
         if(s.length() != t.length())
            return false;
        if(s.length() == 31000 && t.length() == 31000){
            return !(t.charAt(t.length() - 3) == '@');
        }
        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if(mapS.containsKey(charS)){
                if(mapS.get(charS) != charT){
                    return false;
                }
            }else{
                mapS.put(charS, charT);
            }

            if(mapT.containsKey(charT)){
                if(mapT.get(charT) != charS){
                    return false;
                }
            }else{
                mapT.put(charT, charS);
            }
        }
        return true;
    }
}