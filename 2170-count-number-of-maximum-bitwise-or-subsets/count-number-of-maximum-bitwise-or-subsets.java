class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int[] tail = new int[16];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) max |= nums[i];
        int v = 0;
        for (int i = nums.length-1; i > -1; i--) {
            v |= nums[i];
            tail[i] = v;
        }
        return recursion(nums,0,0,tail,max);
    }
    private int recursion(int[] nums, int i, int partial, int[] tail, int max) {
        if (partial == max) {
            return 1 << (nums.length-i);
        }
        if (i == nums.length || (partial | tail[i]) != max) {
            return 0;
        }
        return recursion(nums,i+1,partial|nums[i],tail,max) + 
               recursion(nums,i+1,partial,tail,max);
    }
}