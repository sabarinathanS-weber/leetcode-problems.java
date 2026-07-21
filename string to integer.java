class Solution {
    public int myAtoi(String s) {

        int i = 0;
        int sign = 1;
        long result = 0;

        // Skip leading spaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // Check sign
        if (i < s.length() &&
           (s.charAt(i) == '+' || s.charAt(i) == '-')) {

            if (s.charAt(i) == '-') {
                sign = -1;
            }

            i++;
        }

        // Read digits
        while (i < s.length() && Character.isDigit(s.charAt(i))) {

            result = result * 10 + (s.charAt(i) - '0');

            // Overflow check
            if (sign * result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if (sign * result < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            i++;
        }

        return (int)(sign * result);
    }
}
