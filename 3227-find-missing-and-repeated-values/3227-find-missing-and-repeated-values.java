class Solution {
    public int[] findMissingAndRepeatedValues(int[][] arr) {
        int n = arr.length*arr.length;
        // Calculate expected sum and sum of squares
        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSumOfSquares = (long) n * (n + 1) * (2 * n + 1) / 6;
        
        long actualSum = 0;
        long actualSumOfSquares = 0;
    
        // Calculate the actual sum and sum of squares
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                actualSum+=arr[i][j];
                actualSumOfSquares+=arr[i][j]*arr[i][j];
            }
        }
        
        // The difference between expected and actual sums
        long sumDifference = expectedSum - actualSum; // x - y
        long sumOfSquaresDifference = expectedSumOfSquares - actualSumOfSquares; // x^2 - y^2
        
        // Use the formula: x^2 - y^2 = (x - y) * (x + y)
        long sumXY = sumOfSquaresDifference / sumDifference; // x + y
        
        // Now, we have two equations:
        // x - y = sumDifference
        // x + y = sumXY
        
        // Solving for x and y
        long x = (sumDifference + sumXY) / 2;
        long y = x - sumDifference;
        
        return new int[]{(int)(y),(int)(x)};
    }
}