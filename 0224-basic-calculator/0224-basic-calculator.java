class Solution {
    public int calculate(String s) {
        int i=0;
        int ans=0;
        int sign=1;
        Stack<Integer>st=new Stack<>();

        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                i= i*10+ (c-'0');
            }
            else if(c=='+' || c=='-'){
                ans+=i*sign;
                sign=(c=='-')?-1:1;
                i=0;
            }
            else if(c=='('){
                st.push(ans);
                st.push(sign);
                ans=0;
                i=0;
                sign=1;
            }else if(c==')'){
                ans+=sign*i;
                i=0;
                int prevSign=st.pop();
                int prevAns=st.pop();
                ans=prevAns + prevSign*ans;
            }
        }
        return ans+sign*i;
   }
}