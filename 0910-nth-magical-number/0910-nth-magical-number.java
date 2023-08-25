class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        long A = a , B= b ;
        long lcm = (A*B)/(GCD(A,B));
        long mod = (long)Math.pow(10,9)+7;

        long si = Math.min(A,B) ;
        long ei = n * si ;  // N*Math.min(A,B);

        while(si<ei)
        {
            long mid = si +(ei-si)/2 ;
            long temp = (mid/A) + (mid/B) - (mid/lcm) ;
            if(temp < n)
            {
                si = mid + 1;
            }
            else
            {
                ei = mid ;
            }
        }
        return (int)(si%mod) ;
    }
    public static long GCD(long a, long b)
    {
        if(b==0)
        {
            return a ;
        }
        return GCD(b,a%b);
    }
}