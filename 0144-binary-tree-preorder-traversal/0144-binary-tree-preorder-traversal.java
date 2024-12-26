/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>ans=new ArrayList<Integer>();
        if(root==null){
            return ans;
        }
        Stack<TreeNode>st=new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode popped=st.pop();
            ans.add(popped.val);
            if(popped.right!=null)
                st.push(popped.right);
            if(popped.left!=null)
                st.push(popped.left);
        }
        return ans;
    }
}