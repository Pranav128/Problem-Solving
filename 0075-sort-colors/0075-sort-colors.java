class Solution {
    public void sortColors(int[] nums) {
        int zero=0,one=0,two=nums.length-1;
        while(one<=two){
            if(nums[one]==0){
                swap(nums,one,zero);
                zero++;
                one++;
            }
            else if(nums[one]==1){
                one++;
            }else{
                swap(nums,one,two);
                two--;
            }
        }
    }
    static void swap(int nums[],int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    
    public void sortColors2(int[] nums) {
        int one=0,two=0,zero=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zero++;
            }
            else if(nums[i]==1){
                one++;
            }
            else{
                two++;
            }
        }
        int insert = 0;
        while(insert < nums.length){
            while(zero != 0){
                nums[insert++]=0;
                zero--;
            }
            while(one != 0){
                nums[insert++]=1;
                one--;
            }
            while(two != 0){
                nums[insert++]=2;
                two--;
            }
        }
    }
}