//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			int num = obj.atoi(str);
			
			System.out.println(num);
		t--;
		}
	}
}
// } Driver Code Ends




//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) 
    {
        int max = Integer.MAX_VALUE ;
        int min = Integer.MIN_VALUE ;
        
        if(str == null || str.length()==0)
        {
            return -1 ;
        }
         
        boolean positive = str.startsWith("+");
        boolean negative = str.startsWith("-");
        
        int i = 0;
        
        if(positive || negative)
        {
            i++ ;
        }
        int ans = 0 ;
        // System.out.println(i);
        for( ; i<str.length() ; i++)
        {
            
        if(str.charAt(i) >='0' && str.charAt(i) <='9')
        {
            ans = ans * 10 + (str.charAt(i) - '0');
        }
        else{
            return -1 ;
        }
        
        }
        // System.out.println(ans);
        
        if(negative)
        {
            ans = -ans ;
        }
            return ans ;
    }    
}
