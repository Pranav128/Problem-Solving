class Solution {
    public TreeNode balanceBST(TreeNode root) {
        if(root==null){
            return null;
        }
        ArrayList<Integer>inorder=new ArrayList<>();
        getInorder(root,inorder);
        return makeBalanced(inorder,0,inorder.size()-1);
    }
    
    TreeNode makeBalanced(ArrayList<Integer>inorder,int si, int ei){
        if(si>ei){
            return null;
        }
        int mid=si+(ei-si)/2;
        
        TreeNode root=new TreeNode(inorder.get(mid));
        root.left=makeBalanced(inorder,si,mid-1);
        root.right=makeBalanced(inorder,mid+1,ei);
        
        return root;
    }
    
    void getInorder(TreeNode root,ArrayList<Integer>inorder){
        if(root==null){
            return;
        }
        getInorder(root.left,inorder);
        inorder.add(root.val);
        getInorder(root.right,inorder);
    }
}