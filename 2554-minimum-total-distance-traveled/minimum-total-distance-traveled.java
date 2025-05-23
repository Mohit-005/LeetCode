class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (f1, f2) -> f1[0] - f2[0]);
        long[][] dp = new long[factory.length][robot.size()];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1L);
        }

        long dis = 0;
        for (int r = 0; r < Math.min(factory[0][1], robot.size()); r++) {
            dis += Math.abs(factory[0][0] - robot.get(r));
            dp[0][r] = dis;
        }

        //System.out.println(Arrays.toString(dp[0]));

        for (int f = 1; f < factory.length; f++) {
            int limit = factory[f][1];
            for (int r = 0; r < robot.size(); r++) {
                dis = 0;
                dp[f][r] = dp[f - 1][r];
                for (int fix = 0; fix < limit; fix++) {
                    int rr = r - fix;
                    if (rr < 0) {
                        break;
                    }
                    dis += Math.abs(factory[f][0] - robot.get(rr));
                    long total = dis;
                    if (rr > 0) {
                        if (dp[f - 1][rr - 1] < 0) {
                            continue;
                        }
                        total += dp[f - 1][rr - 1];
                        /*
                        if (r == 2) {
                            System.out.println(rr + ": " + total);
                        }
                        */
                    }
                    if (total < dp[f][r] || dp[f][r] < 0) {
                        dp[f][r] = total;
                    }
                    /*
                    if (r == 2) {
                        System.out.println(rr + ", " + dis + ", t: " + total + ": " + Arrays.toString(dp[f]));
                    }
                    */
                }
            }
            // System.out.println(Arrays.toString(dp[f]));
        }
        return dp[factory.length - 1][robot.size() - 1];
    }
}