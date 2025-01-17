class Solution {
     public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        // Traverse the array twice to simulate circular behavior
        for (int i = 2 * n - 1; i >= 0; i--) {
            // Ensure stack contains only elements greater than the current element
            while (!st.isEmpty() && st.peek() <= nums[i % n]) {
                st.pop();
            }
            // If the stack is empty, no greater element exists; otherwise, the top is the next greater element
            if (i < n) {
                ans[i] = st.isEmpty() ? -1 : st.peek();
            }
            // Push the current element to the stack
            st.push(nums[i % n]);
        }
        return ans;
    }
}