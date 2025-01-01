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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode=new TreeNode(val);
        if(root==null){
            return newNode;
        }
        TreeNode curr=root, parent=null;
        while(curr!=null){
            parent=curr;
            if(curr.val<val){
                curr=curr.right;
            }else if(curr.val>val){
                curr=curr.left;
            }else{
                return root;
            }
        }
        if(parent.val<val){
            parent.right=newNode;
        }else{
            parent.left=newNode;
        }
        return root;
    }
}