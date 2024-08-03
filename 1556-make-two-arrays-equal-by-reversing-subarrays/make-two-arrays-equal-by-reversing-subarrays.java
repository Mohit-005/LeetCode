class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int n = target.length;
        int[] exists = new int[1001];
        for(int num: target){
            exists[num]++;
        }
        for(int num:arr){
            if(exists[num]==0) return false;
            exists[num]--;
        }
        return true;
    }
}