class Solution {
    List<Integer>[][] dp;
    public List<Integer> diffWaysToCompute(String ep) {
        dp = new ArrayList[ep.length()][ep.length()];
        return fun(ep, 0, ep.length()-1);
    }
    private List<Integer> fun(String a, int start, int end) {
        List<Integer> ret = new ArrayList<>();
        if (dp[start][end] != null)
        return dp[start][end];
        int x = operand(a, start, end);
        if (x != -1) {
            ret.add(x);
            dp[start][end] = ret;
            return ret;
        }
        for (int i = start; i <= end; i ++ ){ 
            if (!isOp(a.charAt(i)))
            continue;
            List<Integer> left = fun(a, start, i - 1);
            List<Integer> right = fun(a, i + 1, end);
            for (int j = 0 ;j < left.size(); j++) {
                for (int k = 0 ; k < right.size(); k++) {
                    if (a.charAt(i) == '*')
                    ret.add(left.get(j)*right.get(k));
                    if (a.charAt(i) == '+')
                    ret.add(left.get(j)+right.get(k));
                    if (a.charAt(i) == '-')
                    ret.add(left.get(j)-right.get(k));
                }
            }
        }
        dp[start][end] = ret;
        return ret;
    }
    private int operand(String a, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (isOp(a.charAt(i)))
            return -1;
        }
        int value = 0;
        for (int i = start; i <= end; i++)
        value = value * 10 + (a.charAt(i) - '0');
        return value;
    }
    private boolean isOp(char c) {
        return c == '*' || c == '-' || c == '+';
    }
}