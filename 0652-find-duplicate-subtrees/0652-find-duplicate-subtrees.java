class Solution{
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ArrayList<TreeNode>result=new ArrayList<>();
        String tree=serialize(root,new HashMap<String,Integer>(),result);
        return result;
    }
    String serialize(TreeNode root,HashMap<String,Integer>ans,ArrayList<TreeNode>result){
        if(root==null){
            return "*";
        }
        String temp=root.val+","+serialize(root.left,ans,result)+","+serialize(root.right,ans,result);
        ans.put(temp,ans.getOrDefault(temp,0)+1);
        if (ans.get(temp) == 2) 
            result.add(root);
        return temp;
    }
}