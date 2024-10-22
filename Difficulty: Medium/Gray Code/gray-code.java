//{ Driver Code Starts
//Initial Template for Java
//Initial Template for Java

//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList; 


// } Driver Code Ends
//User function Template for Java

class Solution
{
    public ArrayList<String> graycode(int n)
    {
        ArrayList<String> al = new ArrayList<>();
        if(n==1){
            al.add("0");
            al.add("1");
            return al;
        }
        int limit = (int)Math.pow(2,n)-1;
        al.add(parse(0,n));
        for(int i=1;;i++){
            int grey = i^(i/2);
            if(grey>limit){
                break;
            }
            al.add(parse(grey,n));
        }
        return al;
    }
    
    public static String parse(int decimal,int n){
        String binary = Integer.toBinaryString(decimal);
        if (binary.length() < n) {
            binary = "0".repeat(n - binary.length()) + binary;
        }
        return binary;
    }
}

//{ Driver Code Starts.

class BitWise
{
	static int n;
	static int k;
	
	// Driver Code
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); //Inputting the testcases
		
		while(t>0) //While testcases exist
		{
			
			n = Integer.parseInt(br.readLine()); //Input N
			
			Solution obj = new Solution();
			
			ArrayList<String> ans=obj.graycode(n);
			for(int i=0;i<ans.size();i++)
			    System.out.print(ans.get(i)+" ");
			    
			System.out.println();
            
            t--;
		}
	}
	
	
}

// } Driver Code Ends