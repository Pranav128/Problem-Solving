class Solution {
    public TreeNode deleteNode(TreeNode root, int toBeDelete) {
        if(root==null){
            return root;
        }
        if(root.val<toBeDelete){
            root.right=deleteNode(root.right,toBeDelete);
        }else if(root.val>toBeDelete){
            root.left=deleteNode(root.left,toBeDelete);
        }else{
            //case 1: toBeDelete node is leaf node, so no child
            if(root.left==null && root.right==null){
                return null;
            }

            //case 2: toBeDelete node has only one child, either left or right
            //for left child is null and has right child
            if(root.left==null){
                return root.right;
            }
            //for right child is null and has left child
            else if(root.right==null){
                return root.left;
            }
            //case 3: toBeDelete node has both left and right children
            else{
                TreeNode successor = findSuccessor(root.right);
                root.val=successor.val;;
                root.right= deleteNode(root.right,successor.val); //imp
            }
        }
        return root;
    }
    public TreeNode findSuccessor(TreeNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
}