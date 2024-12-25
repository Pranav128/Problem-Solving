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
public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
    if(root==null){
return ans;
    }
        Queue<TreeNode> que=new LinkedList<>();
        List<Integer> tempList=new ArrayList<>();
        que.add(root);
        que.add(null);
        while(!que.isEmpty()){
            TreeNode node=que.poll();
            if(node==null){
                ans.add(tempList);
                tempList=new ArrayList<>();
                if(!que.isEmpty()){
                    que.add(null);
                }
                else{
                    break;//return
                }
            }
            else{
                tempList.add(node.val);
                if(node.left!=null){
                    que.add(node.left);
                }
                if(node.right!=null){
                    que.add(node.right);
                }
            }
        }
        return ans;
    }

}