class Solution {
    public int hammingWeight(int n) {
        int onesCount = 0;
        while (n!=0) {
            n&= n-1;
            ++onesCount;
        }
        return onesCount;
    }
}