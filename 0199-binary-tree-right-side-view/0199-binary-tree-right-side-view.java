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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>ans=new ArrayList<Integer>();
        if(root==null){
            return ans;
        }
        helper(root,ans,0);
        return ans;
    }
    public void helper(TreeNode root, List<Integer>ans,int level){
        if(root==null){
            return ;
        }
        if(level == ans.size()){
            ans.add(root.val);
        }
        helper(root.right,ans,level+1);
        helper(root.left,ans,level+1);
    }
    public List<Integer> rightSideView2(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode>que=new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int size=que.size();
            for(int i=0;i<size;i++){
                TreeNode polled=que.poll();
                if(i==(size-1)){
                    ans.add(polled.val);
                }
                if(polled.left!=null){
                    que.add(polled.left);
                }
                if(polled.right!=null){
                    que.add(polled.right);
                }
            }
        }
        return ans;
    }
}