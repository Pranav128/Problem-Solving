class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n =-n; // Note: Use a long type to handle edge case when n = Integer.MIN_VALUE
        }
        return powerHelper(x, n);
    }
    private double powerHelper(double x, int n) {
        // Base case
        if (n == 0) {
            return 1.0;
        }

        // Recursive case: Divide the problem
        double half = powerHelper(x, n / 2);

        // If n is even
        if (n % 2 == 0) {
            return half * half;
        }
        // If n is odd
        else {
            return half * half * x;
        }
    }
}