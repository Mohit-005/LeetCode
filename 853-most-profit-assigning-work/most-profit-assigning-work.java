public class Solution {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        if (difficulty.length != profit.length) {
            return 0;
        }

        int maxDifficulty = 0;
        for (int diff : difficulty) {
            maxDifficulty = Math.max(maxDifficulty, diff);
        }

        int[] bestProfit = new int[maxDifficulty + 1];
        for (int i = 0; i < profit.length; i++) {
            bestProfit[difficulty[i]] = Math.max(bestProfit[difficulty[i]], profit[i]);
        }

        int maxProfit = 0;
        for (int i = 0; i < bestProfit.length; i++) {
            if (bestProfit[i] > maxProfit) {
                maxProfit = bestProfit[i];
            }
            bestProfit[i] = maxProfit;
        }

        int result = 0;
        for (int w : worker) {
            if (w > maxDifficulty) {
                result += bestProfit[maxDifficulty];
            } else {
                result += bestProfit[w];
            }
        }
        return result;
    }
}