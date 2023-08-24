class Solution {
    public String longestCommonPrefix(String[] strs) 
    {
/* 
        String prefix = strs[0] ; 
        for(int i =1 ;i<strs.length ;i++)
        {
            while(strs[i].indexOf(prefix) != 0)
            {
                
                prefix = prefix.substring(0 , prefix.length()-1);
            }
        }
        return prefix ;
 */       
        if (strs == null || strs.length == 0)
            return "";
        
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int c = 0;
        while(c < first.length())
        {
            if (first.charAt(c) == last.charAt(c))
                c++;
            else
                break;
        }
        return c == 0 ? "" : first.substring(0, c);
    }
}