class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int ans[]=new int[k];
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            if(a.count==b.count){
                return a.index-b.index;
            }
            return a.count-b.count;
        });
        for(int i=0;i<mat.length;i++){
            int count=findCount(mat[i]);
            pq.offer(new Pair(count,i));
        }
        int i=0;
        while(i<k){
            ans[i++]=pq.poll().index;
        }
        return ans;
    }
    static int findCount(int arr[]){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                break;
            }
            count++;
        }
        return count;
    }
}
class Pair{
    int count;
    int index;
    Pair(int count,int index){
        this.count=count;
        this.index=index;
    }
}