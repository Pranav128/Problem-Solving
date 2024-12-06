//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Com implements Comparator<ItemValue>{
     public int compare(ItemValue item1,ItemValue item2){
        double cpr1=new Double((double)item1.profit/(double)item1.weight);
        double cpr2=new Double((double)item2.profit/(double)item2.weight);
        if (cpr1 < cpr2)
            return 1;
        else
            return -1;
    }
}
class ItemValue  {
    int profit, weight;
    public ItemValue(int val, int wt){
        this.weight = wt;
        this.profit = val;
    }
}

class Solution {
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        ItemValue[] arr=new ItemValue[val.size()];
        for(int i=0;i<arr.length;i++){
            int tempVal=val.get(i);
            int tempWt=wt.get(i);
            arr[i]=new ItemValue(tempVal,tempWt);
        }
        Arrays.sort(arr,new Com());
        double totalValue = 0d;
        for(ItemValue i : arr) {
            int curWt = (int)i.weight;
            int curVal = (int)i.profit;
            if(capacity - curWt >= 0) {
                capacity = capacity - curWt;
                totalValue += curVal;
            }
            else {
                double fraction=((double)capacity/(double)curWt);
                totalValue += (curVal * fraction);
                capacity=(int)(capacity - (curWt * fraction));
                break;
            }
        }
        return totalValue;
    }
}