class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> list = new ArrayList<>();
        if(nums.length ==0 || nums == null)
        {
            return list ;
        }
        int ei = nums[0] , si = nums[0] ;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i] == (1+nums[i-1]))
            {
                ei = nums[i];
            }
            else
            {
                push(list, si, ei);
                si = nums[i] ;
                ei = nums[i] ;
            }
        }
        push(list,si,ei);
        return list ;
    }
    public static void push(ArrayList<String> list , int si , int ei)
    {
        if(si == ei)
        {
            list.add(si+"");
        }
        else{
            list.add(si+"->"+ei);
        }
    }
}