class Solution {
/*  //not applicable for all test cases  
    public int[] rearrangeArray(int[] arr) 
    {
        int negative =1,positive=0 , N=arr.length;
        for(int i=0;i<N && negative<N && positive<N;i++)
        {
            if(i%2==0 && arr[i]>0)
            {
                positive +=2;
            }
            else if(i%2==1 && arr[i] < 0)
            {
                negative += 2;
            }
            else
            {
                swap(arr,negative,positive);
                positive +=2;
                negative += 2;
            }
        }  
        return arr;
    }
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j] ;
        arr[j] = temp ;
    }
*/
  public int[] rearrangeArray(int[] arr) 
    {
        int temp[]= new int[arr.length];
        int positive =0 , negative =1 ;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] > 0)
            {
                temp[positive] = arr[i];
                positive +=2;
            }
            else
            {
                temp[negative] = arr[i];
                negative +=2;
            }
        }
        return temp ;
    }
}