class Solution {
    public int[] replaceElements(int[] arr) {
        int max = arr[arr.length-1];
        int ans[] = new int[arr.length];
        ans[arr.length-1]=-1;
        for(int i=arr.length-2;i>=0;i--){
            ans[i]=max;
            max=Math.max(max,arr[i]);
        }
        return ans;
    }
}