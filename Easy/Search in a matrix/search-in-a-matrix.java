//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            int mat[][] = new int[n][m];
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < m; j++)
                  mat[i][j] = sc.nextInt();
            }
            
            int x = sc.nextInt();
            
            System.out.println (new Sol().matSearch(mat, n, m, x));
        }
        
    }
}
// } Driver Code Ends


class Sol
{
    public static int matSearch(int mat[][], int N, int M, int X)
    {
         for(int i=0;i<N;i++){
            if(Arrays.binarySearch(mat[i],X)>-1){
                return 1;
            }
        }
        return 0;       
    }
}
       
       
    /*   
        HashMap<Integer,Boolean> hm=new HashMap<>();
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                hm.put(mat[i][j],true);
            }
        }
        if(hm.containsKey(X)){
        return 1;

}
        return 0;
}*/
    /*     
        int si = 0 , ei = N*M-1;
        while(si <= ei)
        {
            int mid = si+(ei-si)/2 ;
            int row = mid/M;
            int col = mid % M ;
            if(mat[row][col]==X)
            {
                return 1 ;
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
        return 0 ;
    }
    */

/*
 int row = 0;
        int col = M - 1;

        while (row < N && col >= 0) {
            if (mat[row][col] == X) {
                return 1;
            } else if (mat[row][col] < X) {
                row++;
            } else {
                col--;
            }
        }

        return 0;
*/        