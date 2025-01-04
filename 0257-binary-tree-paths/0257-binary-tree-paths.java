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
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String>ans=new ArrayList<String>();
        if(root==null){
            return ans;
        }
        helper(root,new StringBuffer(),ans);
        return ans;
    }
    public void helper(TreeNode root,StringBuffer temp,ArrayList<String>ans){
        if(root==null){
            return ;
        }
        int sbLen = temp.length();
        if(root.left==null && root.right==null){
            temp.append(root.val);
            ans.add(temp.toString());
            temp.delete(sbLen,temp.length());
            return;
        }
        temp.append(root.val+"->");
        helper(root.left,temp,ans) ;
        helper(root.right,temp,ans) ;
        temp.delete(sbLen,temp.length());
        return ;
    }
}