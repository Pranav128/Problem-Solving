class Solution {
    public int[] searchRange(int[] nums, int target) {
        int floor = findFloor(nums,target);
        if(floor == -1){
            return new int[]{-1,-1};
        }
        int ceil = findCeil(nums,target);
        return new int[]{floor,ceil};
    }
    static int findCeil(int arr[],int k){
        int si=0, ei=arr.length-1, ans=-1;
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(arr[mid] <=k){
                ans=mid;
                si=mid+1;
            }
            else if(arr[mid]<k){
                 si=mid+1;
            }
            else{
                ei=mid-1;
            }
        }
        return ans;
    }
    static int findFloor(int arr[],int k){
        int si=0, ei=arr.length-1, ans=-1;
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(arr[mid] == k){
                ans=mid;
                ei=mid-1;
            }else if(arr[mid]>k){
                ei=mid-1;
            }
            else{
                si=mid+1;
            }
        }
        return ans;
    }
}