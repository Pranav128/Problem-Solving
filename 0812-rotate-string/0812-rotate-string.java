class Solution {
    public boolean rotateString(String s, String goal) 
    {
        if(s.length() != goal.length())
        {
            return false ;
        }
        String ab = s+s ;
        if(ab.indexOf(goal) != -1)
        {
            return true ;
        }
        return false ;
    }
}