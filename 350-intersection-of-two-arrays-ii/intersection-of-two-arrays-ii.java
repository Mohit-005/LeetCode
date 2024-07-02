class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
          int[] arr = new int[1001];
        int[] result = new int[1001];

        for (int num : nums1) {
            arr[num]++;
        }

        int ctr = 0;
        for (int num : nums2) {
            if (arr[num] > 0) {
                result[ctr++] = num;
                arr[num]--;
            }
        }

        return Arrays.copyOfRange(result, 0, ctr);
    }
}