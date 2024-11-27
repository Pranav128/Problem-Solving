class Solution {
//approach 2: PriorityQueue O(nlogk) & O(k)  n=n*n
    public int kthSmallest2(int[][] arr, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                pq.offer(arr[i][j]);
                if(pq.size()>k){
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
//approach 3:Sorting O(nlogn) & O(n) where n=n*n (matrix array in the simple 1D array of n*n size)

//approach 1: Binary serach O(n) & O(1) where n=n*n
    public int kthSmallest(int[][] arr, int k) {
        int n=arr.length;
        int min=arr[0][0], max=arr[n-1][n-1];
        while(min!=max){
            int mid = min+(max-min)/2;
            int count = findMin(arr,mid);
            if(count<k){
                min=mid+1;
            }
            else{
                max=mid;
            }
        }
        return min;
    }
    public int findMin(int arr[][],int key){
        int si=0, ei=arr.length-1;
        int count=0;
        while(si<arr.length && ei>=0){
            if(arr[si][ei] <= key){
                count += ei+1;
                si++;
            }
            else{
                ei--;
            }
        }
        return count;
    }
}