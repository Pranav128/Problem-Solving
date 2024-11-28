class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        double arrSum=0;
        double heapSum=0;
        int count=0;
        for(int i:nums){
            arrSum+=i;
            maxHeap.offer(Double.valueOf(i));
        }
        while(heapSum < (arrSum/2.0)){
            double toBeAdd = maxHeap.poll()/2.0;
            heapSum +=toBeAdd;
            maxHeap.offer(toBeAdd);
            count++;
        }
        return count;
    }
}