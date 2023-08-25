class Solution {
 /*   public int nthUglyNumber(int n, int a, int b, int c) {
        int si = 1;
        int ei = (int)2e9 ;
        while(si<ei)
        {
            int mid = si+(ei-si)/2 ;
            if(valid(a,b,c,mid) < n)
            {
                si = mid+1;
            }
            else
            {
                ei= mid;
            }
        }
        return si ;
        
    }
    public static long valid(int a,int b,int c,int mid)
    {
      return (  (mid/a)+(mid/b)+(mid/c) - 
                (mid/lcm(a,b)) - (mid/lcm(a,c)) - 
                (mid/lcm(b,c)) + (mid/lcm(a,lcm(b,c)))  );
    }
    public static long lcm(long a,long b)
    {
        return (a*b)/GCD(a,b);
    }
    public static long GCD(long a, long b)
    {
        if(b==0)
        {
            return a;
        }
        return GCD(b,a%b);
    }*/

    public int nthUglyNumber(int n, int a, int b, int c) {
        int lo = 1, hi = (int)2e9;
        long ab = lcm(a, b), ac = lcm(a, c), bc = lcm(b, c), abc = lcm(ab, c);
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            long count = 0L + mid / a + mid / b + mid / c - mid / ab - mid / ac - mid / bc + mid / abc;
            if (count >= n)
                hi = mid;
            else
                lo = mid + 1;
        }
        return lo;
    }

    private long gcd(long a, long b){
        return b == 0? a : gcd(b, a % b);
    }

    private long lcm(long a, long b){
        return a * b / gcd(a, b);
    }
}
