class Info{
    int row,col;
    TreeNode node;
    Info(TreeNode node, int row, int col){
        this.row=row;
        this.col=col;
        this.node=node;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Info>que=new LinkedList<>();
        que.add(new Info(root,0,0));

        while(!que.isEmpty()){
            int size=que.size();
            for(int i=0;i<size;i++){
                Info polledInfo=que.poll();
                int row=polledInfo.row;
                int col=polledInfo.col;
                TreeNode polledNode=polledInfo.node;

                if(!map.containsKey(row)){
                    map.put(row,new TreeMap<>());
                }
                if(!map.get(row).containsKey(col)){
                    map.get(row).put(col,new PriorityQueue<>());
                }
                map.get(row).get(col).offer(polledNode.val);

            // if(node.left!=null) q.add(new Tuple(node.left,x-1,y+1));
            // if(node.right!=null) q.add(new Tuple(node.right, x+1,y+1));

                if(polledNode.left!=null){
                    que.add(new Info(polledNode.left,row-1,col+1));
                }
                if(polledNode.right!=null){
                    que.add(new Info(polledNode.right,row+1,col+1));
                }
            }
        }

        for(TreeMap<Integer,PriorityQueue<Integer>> tm : map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq : tm.values()){
                while(!pq.isEmpty()){
                    ans.get(ans.size()-1).add(pq.poll());
                }
            }
        }
        return ans;
    }
}