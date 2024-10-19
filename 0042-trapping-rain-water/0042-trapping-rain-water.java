class Solution {
    public int trap(int[] height) {
        int n = height.length ;
        int left[] = new int[n] ;
        int right[] = new int[n] ;
        left[0] = height[0];
        right[n-1] = height[n-1];
        int si=1 , ei = n-2;
        while(si<n && ei>=0){
            left[si] = Math.max(left[si-1],height[si]);
            right[ei] = Math.max(right[ei+1],height[ei]);
            si++;
            ei--;
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int ans =0 ;
        for(int i=0;i<n;i++){
            ans += (Math.min(left[i],right[i]) - height[i] );
        }
        return ans;



        
    }
}