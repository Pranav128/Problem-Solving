class Solution {
    public boolean canJump(int[] nums) {
        return minJumps(nums)==-1?false:true ;
    }
    static int minJumps(int[] arr){
        int n = arr.length ;
        if(n <= 1)
        {
            return 0;
        }
        if(arr[0] == 0)
        {
            return -1 ;
        }
        int jump =  1 , maxReach=arr[0] , steps = arr[0] ;
        for(int i=1 ;i<n ;i++)
        {
            if(i == n-1)
            {
                return jump ;
            }
            maxReach = Math.max(maxReach , arr[i]+i);
            steps -- ;
            if(steps == 0)
            {
                jump++ ;
                if(i >= maxReach) //imp
                {
                    return -1 ;
                }
                steps = maxReach - i ;
            }
         }
         return -1 ;
    }
}