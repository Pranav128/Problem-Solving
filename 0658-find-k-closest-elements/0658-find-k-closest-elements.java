class Pair{
    int num;
    int diff;
    Pair(int num,int diff){
        this.num=num;
        this.diff=diff;
    }
}
class Solution {
//Approach 1: Two pointer    
    public List<Integer> findClosestElements3(int[] arr, int k, int x) {
        int n=arr.length;
        int left=0;
        int right=n-1;
        List<Integer>ans=new ArrayList<>();
        while(right-left >= k){
            if( Math.abs(arr[left]-x) > Math.abs(arr[right]-x) ){
                left++;
            }
            else{
                right--;
            }
        }
        for(int i=left;i<=right;i++){
            ans.add(arr[i]);
        }
        return ans;
    }
    
//Approach 2: Priority Queue 
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
        List<Integer>ans=new ArrayList<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            if(a.diff!=b.diff){
                return b.diff-a.diff;
            }else{
                return b.num-a.num;
            }
        });
        for(int i:arr){
            pq.offer(new Pair(i,Math.abs(i-x)));
            if(pq.size()>k){
                pq.poll();
            }
        }
        k=k-1;
        while(k>=0){
            ans.add(pq.poll().num);
            k--;
        }
       Collections.sort(ans);
        return ans;
    }

//Approach 3: Binary search
public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        while (left < right) {
            int midpoint = left + (right - left) / 2; // same as (left + right) / 2
            if (x - arr[midpoint] > arr[midpoint + k] - x) {
                left = midpoint + 1;
            }
            else {
                right = midpoint;
            }
        }

        List<Integer> result = new ArrayList<>(k);
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
} 
/*
class Solution {
    
    // Approach:
    // Using two pointers, we are going the 'start' and 'end' pointers towards each other,
    // until only k elements between 'start' and 'end'.
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int start = 0;
        int end = arr.length - 1;
        // Between the 'start' and 'end' pointers, inclusive, contains all the k integers that is closest to x.
        while (end - start >= k) {
            // Move 'start' to the right if 'end' is closer to x, or move 'end' to the left if 'start' is closer to x.
            if (Math.abs(arr[start] - x) > Math.abs(arr[end] - x)) {
                start++;
            } else {
                end--;
            }
        }

        // Input all the k closest integers into the result.
        List<Integer> result = new ArrayList<>(k);
        for (int i = start; i <= end; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
*/