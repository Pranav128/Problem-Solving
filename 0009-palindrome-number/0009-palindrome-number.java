class Solution {
   
        public boolean isPalindrome(int x) {
        int num = x;
        int rev = 0;
        while(num>0) {
            int rem = num%10;
            num = num/10;
            rev = rev*10+rem;
        }
        return x==rev;
   
    }
}