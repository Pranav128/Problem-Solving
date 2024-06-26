class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int ans[] = new int[nums.length-k+1];
        int insert = 0 ;
        Deque<Integer> deq = new ArrayDeque<>();
        for(int i=0 ;i<nums.length;i++)
        {
            while(!deq.isEmpty() && deq.peek() <= i-k)
            {
                deq.poll();
            }
            while(!deq.isEmpty() && nums[i] > nums[deq.peekLast()])
            {
                deq.pollLast();
            }
            deq.offer(i);
            if(i>=k-1)
            {
                ans[insert++] =nums[deq.peek()]; 
            }
        }return ans ;
    }
}