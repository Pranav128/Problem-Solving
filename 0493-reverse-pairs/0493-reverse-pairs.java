
class Solution {
    public int reversePairs(int[] nums) 
    {
        return mergesort(nums,0,nums.length-1);
    }
    
    public static int mergesort(int arr[],int si, int ei)
    {
        int count = 0;
        if(si>=ei)
        {
            return count ;
        }
        int mid = si+(ei-si)/2 ;
        count += mergesort(arr, si, mid);
        count += mergesort(arr, mid+1, ei);
        count += conquer(arr,si,mid,ei);
        return count ;
    }
        
    public static int conquer(int arr[],int si, int mid,int ei)
    {
        int count =0 ;
        int right = mid+1 ;
        for(int i = si ;i<=mid ;i++)
        {
            while(right<=ei && arr[i] > 2*(long)arr[right])
            {
                right++;
            }
            count += right-(mid+1);
        }
        
        int temp[] = new int[ei-si+1];
        int si1 = si ;
        int si2 = mid+1 ,x=0;
        while(si<=mid && si2<=ei)
        {
            if(arr[si] <= arr[si2])
            {
                temp[x++] = arr[si++]; 
            }
            else
            {
                temp[x++] = arr[si2++];
            }
        }
        while(si<=mid)
        {
            temp[x++] = arr[si++]; 
        }
        while(si2<=ei)
        {
            temp[x++] = arr[si2++]; 
        }
        for(int i=0;i<temp.length;i++)
        {
            arr[i+si1] = temp[i];
        }
        return count ;
    }
    
}

/*
class Solution {
    public int reversePairs(int[] nums) {
        return mergesort(nums,0,nums.length-1); 
    }
    static int mergesort(int[] nums, int low, int high){
        if(low>=high){ 
            return 0;
        }
        int mid = (low+high)/2;   
        int inv = mergesort(nums,low,mid);
        inv += mergesort(nums,mid+1, high); 
        inv += merge(nums,low,mid,high); 
        return inv;  
    }
    static int merge(int[] nums, int low, int mid, int high){
        int cnt = 0;
        int j = mid + 1;
        for(int i= low;i<=mid;i++){  
            while(j<=high && nums[i]> (2 * (long) nums[j])){ 
                j++;
            }
            cnt+= (j-(mid+1));
        }
	
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){ 
                temp.add(nums[left++]);  
            }
            else{
                temp.add(nums[right++]);
            }
        }
        while(left<=mid){ 
            temp.add(nums[left++]);
        }
        while(right<=high){ 
            temp.add(nums[right++]);
        }
        for(int i =low;i<=high;i++){
            nums[i] = temp.get(i-low);
        }
        return cnt;     
    }
    
}*/