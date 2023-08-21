class Solution {
    public boolean search(int[] nums, int target) 
    {
        int idx = search(nums,0,nums.length-1,target);
        return idx != -1 ;        
    }
    public static int search(int arr[], int si, int ei, int key)
    {
        while(si <= ei)
        {
            int mid = si+(ei-si)/2 ;
            
            if(arr[mid] == key)
            {
                return mid ;
            }
            else if(arr[si]==arr[mid] && arr[mid] == arr[ei])
            {
                si++;
                ei--;
                continue ;
            }
            else if( arr[si] <= arr[mid])
            {
                if(key >= arr[si] && key <= arr[mid] )
                {
                    ei = mid-1 ;
                }
                else
                {
                    si = mid + 1 ;
                }
            }
            else
            {
               if(key >= arr[mid] && key <= arr[ei] )
                {
                    si = mid+1 ;
                }
                else
                {
                    ei = mid - 1 ;
                }
            }
        }
        return -1 ;
    }
}