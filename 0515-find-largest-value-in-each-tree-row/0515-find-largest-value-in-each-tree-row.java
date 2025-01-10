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
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer>ans =new ArrayList<Integer>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode>que=new LinkedList<>();
        que.add(root);
        // ans.add(root.val);
        while(!que.isEmpty()){
            int size=que.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode polled=que.poll();
                max=Math.max(max,polled.val);
                if(polled.left!=null){
                    que.add(polled.left);
                }
                if(polled.right!=null){
                    que.add(polled.right);
                }
            }
            ans.add(max);
        }
        return ans;
    }
}