class Solution {
    public boolean searchMatrix(int[][] mat, int X) 
    {
       int N =mat[0].length ,M= mat.length;
        int si = 0 , ei = N*M -1;
        while(si <= ei)
        {
            int mid = si+(ei-si)/2 ;
            int row = mid/N;
            int  col = mid % N ;
            if(mat[row][col]==X)
            {
                return true ;
            }
            else if(mat[row][col] < X)
            {
                si = mid+1;
            }
            else
            {
                ei = mid-1 ;
            }
        }
        return false ;
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       /*
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(matrix[i][j] == target)
                {
                    return true ;
                }
            }
        }
        return false;
        */


       




    }
}