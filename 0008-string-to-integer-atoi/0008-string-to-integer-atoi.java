class Solution {
    public int myAtoi(String s) 
    {
        if(s.length()==0 || s == null)
        {
            return 0 ;
        }

        int max =Integer.MAX_VALUE ;
        int min =Integer.MIN_VALUE ;

        s = s.trim();
         if(s.length()==0 || s == null)
        {
            return 0 ;
        }
        int i =0 ,sign = 1 ;
        if(s.charAt(i)=='+' || s.charAt(i)=='-')
        {
            sign = s.charAt(i)=='+'? 1 :-1 ;
            i++;
        }

        double ans = 0;
        while(i<s.length() && s.charAt(i) >='0'&& s.charAt(i) <='9'  )
        {
            ans = ans*10 + (s.charAt(i)-'0') ;
            i++ ;
        }
        ans = sign==1?ans : -ans ;
        if(ans > max)
        {
            return max ;
        }
        else if(ans < min)
        {
            return min ;
        }
        return (int)ans ;   
    }
}