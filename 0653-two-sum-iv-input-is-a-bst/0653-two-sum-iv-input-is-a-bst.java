class Solution {
    //approach 1: inorder traversal array(Sorted) + two pointer 
    //approach 2: Inorder treaversal + hashing
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> hm=new HashSet<>();
        return helper(root,k,hm);
    }
    public boolean helper(TreeNode root, int sum,HashSet<Integer> map){
        if(root==null){
            return false;
        }
        if(map.contains(sum-root.val)){
            return true;
        }
        else{
            map.add(root.val);
        }
        return  helper(root.left,sum,map) || helper(root.right,sum,map);
    }
}