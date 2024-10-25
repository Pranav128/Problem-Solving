class Solution {
    public int[] countBits2(int n) {
        int ans[] = new int[n+1];
        for(int i=0;i<=n;i++ ){
            ans[i]=Integer.bitCount(i);
        }
        return ans;
    }

      public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0; // Base case: 0 has zero 1s in its binary representation

        for (int i = 1; i <= n; i++) {
            // Use the relationship: ans[i] = ans[i >> 1] + (i & 1)
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }
}