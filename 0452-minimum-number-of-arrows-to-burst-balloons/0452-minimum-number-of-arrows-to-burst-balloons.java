class Solution {
    public int findMinArrowShots(int[][] points) {
        return activitySelection(points);
    }
    public static int activitySelection(int[][] arr){
        Arrays.sort(arr,Comparator.comparingInt(o->o[1]));
        int ans=1;
        int last=arr[0][1];
        for(int i=1;i<arr.length;i++){
            if(last < arr[i][0]){
                ans++;
                last=arr[i][1];
            }
        }
        return ans;
    }
}