class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cand1=0, cand2=0, count1=0,count2=0;
        List<Integer> ans=new ArrayList<>();
        for(int i :nums){
            if(count1==0 && i!=cand2){
                cand1=i;
                count1=1;
            }
            else if(count2==0 && i!=cand1){
                cand2=i;
                count2=1;
            }
            else if(i==cand1){
                count1++;
            }
            else if(i==cand2){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int i:nums){
            if(i==cand1){
                count1++;
            }else if(i==cand2){
                count2++;
            }
        }
        int criteria=nums.length/3;
        if(count1>criteria){
            ans.add(cand1);
        }
        if(count2>criteria){
            ans.add(cand2);
        }
        return ans;
    }
}