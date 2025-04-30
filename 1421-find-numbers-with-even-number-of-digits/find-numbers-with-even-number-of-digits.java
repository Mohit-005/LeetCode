class Solution {
    public int findNumbers(int[] nums) {
      int num=0;
      for(int ele :nums){
        if(((int)Math.log10(ele)+1)%2==0) num++;
      }
      return num;
    }
}