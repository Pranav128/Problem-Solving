class Solution {
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int ans[] = new int[nums.length-k+1];
        int insert = 0;
        Deque<Integer> deq = new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            while(!deq.isEmpty() && deq.peekFirst()<=i-k){
                deq.pollFirst();
            }
            while(!deq.isEmpty() && nums[i]>nums[deq.peekLast()]){
                deq.pollLast();
            }
            deq.offerLast(i);
            if(i >= k-1){
                ans[insert++]=nums[deq.peekFirst()];
            }
        }
        return ans;
    }
    public int[] maxSlidingWindow(int[] arr, int k) {
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->b.num-a.num);
        for(int i = 0; i< k; i++){
            pq.offer(new Pair(arr[i],i));
        }
        int ans[]=new int[arr.length- k +1];
        ans[0]=pq.peek().num;
        int idx=1;
        for(int i = k; i< arr.length; i++){
            while(!pq.isEmpty()&&pq.peek().idx<=i- k){
                pq.poll();
            }
            pq.offer(new Pair(arr[i],i));
            ans[idx++]=pq.peek().num;
        }
        return ans;
    }
}

class Pair{
    int num,idx;
    Pair(int num,int idx){
        this.num=num;
        this.idx=idx;
    }
}