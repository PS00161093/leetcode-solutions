// https://leetcode.com/problems/powx-n
// TIME COMPLEXITY: O(log n) where n is the exponent
// SPACE COMPLEXITY: O(log n) for recursion stack

class PowerOfXToN {
    public double myPow(double x, int n) {
        // Handle negative exponents
        if (n < 0) {
            // Handle overflow case: Integer.MIN_VALUE cannot be negated
            if (n == Integer.MIN_VALUE) {
                return 1.0 / (x * myPow(x, Integer.MAX_VALUE));
            }
            return 1.0 / myPow(x, -n);
        }

        return fastPow(x, n);
    }

    private double fastPow(double x, int n) {
        // Base case
        if (n == 0)
            return 1.0;

        // Recursive case: divide exponent by 2
        double half = fastPow(x, n / 2);

        if (n % 2 == 0) {
            // Even exponent: x^n = (x^(n/2))^2
            return half * half;
        } else {
            // Odd exponent: x^n = x * (x^(n/2))^2
            return x * half * half;
        }
    }
}
