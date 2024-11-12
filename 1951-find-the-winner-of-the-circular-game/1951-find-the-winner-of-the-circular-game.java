class Solution {
    public int findTheWinner(int n, int k) {
        return joseph(n,k)+1;
    }
    public static int joseph(int n,int k){
        if(n==1){
            return 0;
        }
        return (joseph(n-1,k)+k)%n;
    }
}