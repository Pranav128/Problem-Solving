class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) 
    {
        int count = 0, index =0 ;
        for(int i=0;i<mat.length ;i++)
        {
            int temp = mat[i].length - binary(mat[i], mat[0].length , 1 );
            if(count < temp)
            {
                count = temp ;
                index = i ;
            }
        }
        return new int[]{index , count};
        
    }
    public static int binary(int arr[],int n, int target)
    {
        Arrays.sort(arr);
        int si =0 , ei =n-1 , ans = n;
        while(si <= ei)
        {
            int mid  = si+(ei-si)/2 ;
            if(arr[mid] >= target)
            {
                 ans = mid ;
                 ei = mid-1 ;
            }
            else
            {
                si = mid +1 ;
            }
        }
        return ans ;
    }
}