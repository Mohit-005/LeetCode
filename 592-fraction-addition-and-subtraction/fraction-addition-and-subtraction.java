class Solution {
    public String fractionAddition(String expression) {
        char[] arr = expression.toCharArray();
        int[] idx = new int[] {0};
        int numerator = getNum(arr, idx);
        idx[0]++;
        int denominator = getNum(arr, idx);
        
        while (idx[0] < expression.length()) {
            int numerator2 = getNum(arr, idx);
            idx[0]++;
            int denominator2 = getNum(arr, idx);
            int newDenominator = lcm(denominator, denominator2);
            numerator *= newDenominator / denominator;
            numerator2 *= newDenominator / denominator2;
            numerator += numerator2;
            denominator = newDenominator;
        }
        
        int gcd = gcd(Math.abs(numerator), denominator);

        numerator /= gcd;
        denominator /= gcd;

        StringBuilder sb = new StringBuilder();
        sb.append(numerator);
        sb.append('/');
        sb.append(denominator);
        return sb.toString();
    }

    private static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    private static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    private int getNum(char[] expression, int idx[]) {
        boolean negative = false;
        int res = 0;
        if (expression[idx[0]] == '-') {
            negative = true;
            idx[0]++;
        } else if (expression[idx[0]] == '+') {
            idx[0]++;
        }
        while (idx[0] < expression.length && expression[idx[0]] >= '0' && expression[idx[0]] <= '9') {
            res *= 10;
            res += expression[idx[0]] - '0';
            idx[0]++;
        }
        return negative? -res : res;
    }
}