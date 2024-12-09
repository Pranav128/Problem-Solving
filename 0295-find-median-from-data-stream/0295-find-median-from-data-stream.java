class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        minHeap=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
       maxHeap.offer(num);
       minHeap.offer(maxHeap.poll());
       if(minHeap.size()>maxHeap.size()){
            maxHeap.offer(minHeap.poll());
       }
    }
    
    public double findMedian() {
        return (minHeap.size()==maxHeap.size())?(minHeap.peek()+maxHeap.peek())/2.0:maxHeap.peek();
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */