class Solution {
    public List<Integer> countSmaller(int[] arr) {
       int n = arr.length;
        List<Integer> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
       for(int i : arr)
       {
           list.add(i);
       }
       Collections.sort(list);

        for (int i = 0; i < n; i++) 
        {
        int idx = binary(list, arr[i]);
        result.add(idx);
        list.remove(idx);   
        }  
        return result;
    }
    public static int binary(List<Integer> arr , int target)
    {
        int si = 0 , ei=arr.size()-1 , idx =0;
        while(si <= ei)
        {
            int mid = si+(ei-si)/2 ;
            if(arr.get(mid) < target)
            {
                si = mid +1 ;
            }
            else if(arr.get(mid) ==target)
            {
                idx = mid ;
                ei = mid-1 ;
            }
            else
            {
                ei = mid -1 ;
            }
        }
        return idx ;
    }
}