class Pair{
    int start,end;
    Pair(int s,int e){
        start=s;
        end=e;
    }
}
class Solution {
    public int[][] merge2(int[][] arr) {
        ArrayList<Pair>list=new ArrayList<>();
        Arrays.sort(arr,Comparator.comparingInt(a -> a[0]));
        for(int i=0;i<arr.length;i++){
            if(list.isEmpty() || arr[i][0]>list.get(list.size()-1).end){
                list.add(new Pair(arr[i][0],arr[i][1]));
            }else{
                list.get(list.size()-1).end=arr[i][1];
            }
        }
        int ans[][]=new int[list.size()][2];
        int i=0;
        for(Pair p:list){
            ans[i][0]=p.start;
            ans[i][1]=p.end;
            i++;
        }
        return ans;
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int k = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[k][1] >= intervals[i][0]) {
                intervals[k][1] = Math.max(intervals[k][1], intervals[i][1]);
            } else {
                k++;
                intervals[k] = intervals[i];
            }
        }
        return Arrays.copyOfRange(intervals, 0, k + 1);
    }
}