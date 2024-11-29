//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        while (t-- > 0) {
            // Read the start times
            String[] startInput = reader.readLine().trim().split("\\s+");
            List<Integer> start = new ArrayList<>();
            for (String s : startInput) {
                start.add(Integer.parseInt(s));
            }

            // Read the end times
            String[] endInput = reader.readLine().trim().split("\\s+");
            List<Integer> end = new ArrayList<>();
            for (String s : endInput) {
                end.add(Integer.parseInt(s));
            }

            // Create solution object and call activitySelection
            Solution obj = new Solution();
            System.out.println(obj.activitySelection(start, end));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Activity implements Comparable<Activity>{
        int start,end,i;
        public Activity(int start, int end,int i) {
            this.start = start;
            this.i=i;
            this.end = end;
        }
        @Override
        public int compareTo(Activity o) {
            if(this.end != o.end){
                return this.end-o.end;
            }
            return this.i-o.i;
        }
        
    }
class Solution {
    public int activitySelection(List<Integer> start, List<Integer> end) {
        ArrayList<Activity> activities = new ArrayList<>();
        for(int i=0;i<start.size();i++){
            activities.add(new Activity(start.get(i),end.get(i),i+1));
        }
        Collections.sort(activities);
        int last=0,ans=0;
        for(int i=0;i<activities.size();i++){
            if(last < activities.get(i).start){
                ans++;
                last=activities.get(i).end;
            }
        }
        return (ans);
    }
}
