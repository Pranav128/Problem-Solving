class Solution {
//soting is best approach but nlogn is tc we need nologk and task is to do without sorting
//so we can go with heap
 public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        
        return minHeap.peek();
    }

   /*passed almost all cases except last one (but tc is O(nlogn) we need O(nlogK))
    public int findKthLargest(int[] nums, int k) 
    {
        if(nums ==null || nums.length<0)
        {
            return -1 ;
        }
        quick(nums,0,nums.length-1);
        return nums[nums.length-k];
    }
    public static void quick(int arr[],int si, int ei)
    {
        if(si >= ei)
        {
            return ;
        }
        int pivotIdx = pivot(arr,si,ei);
        quick(arr,si,pivotIdx-1);
        quick(arr,pivotIdx+1,ei);
    }
    public static int pivot(int arr[], int si, int ei)
    {
        int i=si , j= ei , pivot= arr[si];

        while(i<j)
        {
            while(arr[i] <= pivot && i<ei)
            {
                i++;
            }
            while(arr[j] > pivot && j > si)
            {
                j--;
            }
            if(i<j)
            {
                swap(arr,i,j);
            }
        }
        swap(arr,si,j);
        return j ;
    }
    public static void swap(int arr[],int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j] ;
        arr[j] =temp;
    }
    */
}
