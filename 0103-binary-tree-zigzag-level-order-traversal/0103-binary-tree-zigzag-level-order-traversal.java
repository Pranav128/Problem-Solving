class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode>que=new LinkedList<>();
        que.add(root);
        boolean flag=true;
        while(!que.isEmpty()){
            int size=que.size();
            ArrayList<Integer>temp=new ArrayList<>();
            int insert=temp.size();
            for(int i=0;i<size;i++){
                TreeNode polled=que.poll();
                if(flag){
                    temp.add(polled.val);
                }else{
                    temp.add(insert,polled.val);
                }
                // temp.add(polled.val);
                if(polled.left!=null){
                    que.add(polled.left);
                }
                if(polled.right!=null){
                    que.add(polled.right);
                }
            }
            // if(!flag){
            //     Collections.reverse(temp);
            // }
            ans.add(temp);
            flag=!flag;
        }
        return ans;
    }
}