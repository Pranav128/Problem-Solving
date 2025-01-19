class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer>st=new Stack<>();
        int ans=0;

        for(int i=0;i<=heights.length;i++){
            int h=(i==heights.length)?0:heights[i];
            while(!st.isEmpty() && heights[st.peek()] >= h){
                int index=st.pop();
                int curr=heights[index] * (st.isEmpty()?i:(i-st.peek()-1));
                ans=Math.max(ans,curr);
            }
            st.push(i);
        }
        return ans;
    }
}