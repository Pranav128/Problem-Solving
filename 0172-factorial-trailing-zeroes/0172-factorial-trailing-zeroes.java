class Solution {
    public int trailingZeroes(int n) {
        if(n<0)
          return -1;
        int count = 0;
        while(n>=5){
            n=n/5;
            count+=n;
        }
        return count;
    }
}