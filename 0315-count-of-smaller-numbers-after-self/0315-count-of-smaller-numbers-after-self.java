class Solution {
  /*  public List<Integer> countSmaller(int[] arr) {
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
    */
    class pair
    {
        int val ;
        int idx ;
       public pair(int val, int idx)
        {
            this.val = val ;
            this.idx = idx ;
        }
    }

    public List<Integer> countSmaller(int[] arr) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
//base case   
        if(arr == null || n== 0)
        {
            return ans ;
        } 
       
        Integer count[] = new Integer[n];
        Arrays.fill(count,0);

        pair p[] = new pair[n];
        for(int i=0;i<n;i++)
        {
            p[i] = new pair(arr[i] ,i) ;
        }

        mergeSort(p,count, 0, n-1);
        ans.addAll(Arrays.asList(count));

        return ans ;
    }

    public static void mergeSort(pair p[],Integer count[],int si, int ei)
    {
        if(si < ei)
        {

        int mid = si + (ei-si)/2 ;
        mergeSort(p,count,si,mid);
        mergeSort(p,count,mid+1,ei);

        merge(p,count,si,mid,ei);
        }
    }
    public static void merge(pair p[],Integer count[], int si, int mid,int ei)
    {
        int si1 = si , si2 = mid+1 , x=0;
        pair temp[] = new pair[ei-si+1];

        while(si1<=mid && si2<=ei)
        {
            if(p[si1].val > p[si2].val)
            {
                count[p[si1].idx] += ei-si2+1 ;
                temp[x++] = p[si1++] ;
            }
            else
            {
               
                temp[x++] = p[si2++];
            }
        }
        while(si1<=mid)
        {
            temp[x++]=p[si1++];
        }
        while(si2<=ei)
        {
            temp[x++]=p[si2++];
        }
        for(int i=0;i<temp.length;i++)
        {
            p[i+si] = temp[i];
        }
    }
    
}