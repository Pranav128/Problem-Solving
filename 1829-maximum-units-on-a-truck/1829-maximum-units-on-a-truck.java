class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
    //    return fractionalKnapsack(boxTypes,truckSize);
        Arrays.sort(boxTypes,(a,b)->Integer.compare(b[1],a[1]));
        int profit =0;
        for(int i=0;i<boxTypes.length;i++){
            if(boxTypes[i][0] <=  truckSize){
                profit += (boxTypes[i][0]*boxTypes[i][1]);
                truckSize -=boxTypes[i][0];
            }
            else{
                if(truckSize !=0){
                    profit  += (truckSize*boxTypes[i][1]);
                    break;
                }
            }
        }
        return profit;
    }
}