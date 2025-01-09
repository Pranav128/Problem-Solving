//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                String temp[] = br.readLine().trim().split(" ");
                arr[i][0] = Integer.parseInt(temp[0]);
                String x = temp[1];
                arr[i][1] = Integer.parseInt(x);
            }
            Solution obj = new Solution();
            // The mergeOverlap function now returns a List<int[]>
            List<int[]> ans = obj.mergeOverlap(arr);

            // Printing the merged arr
            for (int[] interval : ans) {
                System.out.print(interval[0] + " " + interval[1] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public List<int[]> mergeOverlap2(int[][] arr) {
        ArrayList<Pair>list=new ArrayList<>();
        Arrays.sort(arr,Comparator.comparingInt(a -> a[0]));
        for(int i=0;i<arr.length;i++){
            if(list.isEmpty() || arr[i][0]>list.get(list.size()-1).end){
                list.add(new Pair(arr[i][0],arr[i][1]));
            }else{
                list.get(list.size()-1).end=arr[i][1];
            }
        }
        List<int[]>ans = new ArrayList<>();
        for(Pair p:list){
            ans.add(new int[]{p.start,p.end});
        }
        return ans;
    }
    public List<int[]> mergeOverlap3(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], interval[1]);
            } else {
                merged.add(prev);
                prev = interval;
            }
        }
        merged.add(prev);
        return merged;
    }
    public List<int[]> mergeOverlap(int[][] intervals) {
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
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            result.add(intervals[i]);
        }
        return result;
    }
}

class Pair{
    int start,end;
    Pair(int s,int e){
        start=s;
        end=e;
    }
}
