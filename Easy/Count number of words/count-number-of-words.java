//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.countWords(S));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int countWords(String s) 
    { 

     int n = s.length();
     int count = 0; 
     String str = "";
     
      for(int i =0; i<n; i++){
          if(s.charAt(i)!=' ' && s.charAt(i)!='\\' ){
              str+=s.charAt(i);
          }
          else
          {
              
              if(str.length()!=0 )
              {
                  count++;
                  str="";
              }

              if(i < s.length()-1 && s.charAt(i)=='\\' && s.charAt(i+1)!='\\'){

                  i++;

              }

          }

          if(str.length()!=0 && i==n-1){

              count++;

          }

      }

      return count;  

      }
} 