class Solution {
public int[] productExceptSelf(int[] arr) 
    {
        int n = arr.length;
        int ans[]= new int[n];
        ans[0]=1;
        for(int i=1 ;i<n;i++)
        {
            ans[i] = ans[i-1]*arr[i-1];
        }
        int right = 1 ;
        for(int i=n-1 ;i>=0;i--)
        {
            ans[i] *= right ;
            right *= arr[i];
        } 
        return ans ;
    }



/*    
//her we need extra space for the two array  
    public int[] productExceptSelf(int[] arr) 
    {
        int n = arr.length ;
		int pre[] = new int[n];
	    int post[]  = new int[n] ;
        int[] ans = new int[n];
        pre[0]= 1;
        post[n-1] = 1 ;

        for(int i=1,j=n-2 ;i<n && j>=0;i++,j--)
        {
            pre[i] = pre[i-1] * arr[i-1];
            post[j] = post[j+1] * arr[j+1];
        }
        for(int i=0;i<n;i++)
        {
             ans[i] = pre[i]*post[i];
        }
        return ans ;
    }
 */

}