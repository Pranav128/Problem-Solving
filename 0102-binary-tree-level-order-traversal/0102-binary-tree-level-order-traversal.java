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
    public static List<List<Integer>> levelOrder2(TreeNode root) {
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
    public static List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int size=que.size();
            ArrayList<Integer>temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode polled=que.poll();
                if(polled.left!=null){
                    que.add(polled.left);
                }
                if(polled.right!=null){
                    que.add(polled.right);
                }
                temp.add(polled.val);
            }
            ans.add(temp);
        }
        return ans;
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        recursion(root,ans,0);
        return ans;
    }
    public static void recursion(TreeNode root,List<List<Integer>> ans, int height){
        if(root==null){
            return ;
        }
        if(height==ans.size()){
            ans.add(new ArrayList<>());
            ans.get(height).add(root.val);
        }
        else{
            ans.get(height).add(root.val);
        }
        recursion(root.left,ans,height+1);
        recursion(root.right,ans,height+1);
    }
}