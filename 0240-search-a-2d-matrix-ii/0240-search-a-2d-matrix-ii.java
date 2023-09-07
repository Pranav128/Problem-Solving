class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = matrix.length , col = matrix[0].length ;
        int i = 0 , j = col-1 ;
        while(i<row && j>=0)
        {
            if(matrix[i][j] == target)
            {
                return true ;
            }
            else if(matrix[i][j] < target)
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        return false ;
        
        
        
        /* for(int i=0;i<matrix.length;i++)
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