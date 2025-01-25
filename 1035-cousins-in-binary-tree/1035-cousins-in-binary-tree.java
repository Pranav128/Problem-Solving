class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int level = q.size();
            boolean foundX = false, foundY = false;

            for(int i = 0; i < level; i++){
                TreeNode currN = q.poll();

                // Check if x and y are siblings
                if(currN.left != null && currN.right != null){
                    if((currN.left.val == x && currN.right.val == y) ||
                       (currN.left.val == y && currN.right.val == x)){
                        return false;
                    }
                }

                // Check for x and y at the current level
                if(currN.left != null){
                    q.add(currN.left);
                    if(currN.left.val == x) foundX = true;
                    if(currN.left.val == y) foundY = true;
                }

                if(currN.right != null){
                    q.add(currN.right);
                    if(currN.right.val == x) foundX = true;
                    if(currN.right.val == y) foundY = true;
                }
            }
            // If both are found at the same level and not siblings, they are cousins
            if(foundX && foundY) return true;
        }
        return false;
    }        
}