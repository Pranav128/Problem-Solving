class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
       return fractionalKnapsack(boxTypes,truckSize);
    }
    int fractionalKnapsack(int[][] box,int capacity) {
        Pair[] arr = new Pair[box.length];
        for(int i=0;i<box.length;i++){
            int tempVal=box[i][0];
            int tempWt=box[i][1];
            arr[i]=new Pair(tempVal,tempWt);
        }
        Arrays.sort(arr);

        if(capacity<arr[0].wt){
            return 0;
        }
        int profit=0;
        for(Pair i : arr){
            if(capacity>=i.wt){
                capacity -=i.wt;
                profit += (i.wt*i.val);
            }
            else{
                if(capacity !=0){
                    profit += (capacity*i.val);
                    break;
                }
            }
        }
        return profit;
    }
}
class Pair implements Comparable<Pair>{
    int val,wt;
    public Pair(int wt,int val){
        this.val=val;
        this.wt=wt;
    }
    public int compareTo(Pair o){
        if(this.val!=o.val){
            return (o.val-this.val);
        }
        return this.wt-o.wt;
    }
}