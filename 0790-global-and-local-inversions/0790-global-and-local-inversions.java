class Solution {
  //approach 1 : merge sort O(nLogn)
	/*  public boolean isIdealPermutation(int[] nums) 
    {
        int local = 0;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i] > nums[i+1])
            {
                local ++;
            }
        }
        int global = mergeSort(nums, 0, nums.length-1);
        return local==global ;
        
    }

     static int mergeSort(int arr[], int si, int ei)
	    {
	        if(si >= ei)
	        {
	            return 0  ; 
	        }
	        int count =0 ;
	        int mid = si+(ei-si)/2 ;
	        count += mergeSort(arr, si, mid);
	        count += mergeSort(arr,mid+1, ei);
	        
	        count+= merge(arr,si,mid,ei);
	        return count ;
	    }
	    static int merge(int arr[] , int si ,int mid, int ei)
	    {
	        int temp[] = new int[ei-si+1];
	        int count = 0;
	        int si1=si, si2 = mid+1 , ei1=mid , ei2 = ei , x= 0 ;
	        
	        while(si1 <= ei1 && si2 <= ei2)
	        {
	            if(arr[si1] <= arr[si2])
	            {
	                temp[x++] = arr[si1++];
	            }
	            else
	            {
	                temp[x++] = arr[si2++];
	                count += mid - si1 + 1 ;
	            }
	        }
	        while(si1 <= ei1)
	        {
	            temp[x++] = arr[si1++];
	        }
	         while(si2 <= ei2)
	        {
	            temp[x++] = arr[si2++];
	        }
	        for(int i=0;i<temp.length;i++)
	        {
	            arr[i+si] = temp[i];
	        }
	        return count ;
	    }
			*/

			 public boolean isIdealPermutation(int[] a) 
    {
			for(int i=0;i<a.length;i++)
			{
				if(Math.abs(i-a[i]) > 1 )
				{
					return false ;
				}
			}
				return true ;
		}
}