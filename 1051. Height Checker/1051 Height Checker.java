class Solution {
    public int heightChecker(int[] heights) {
     int heightsFreq[] = new int[101];
      int expected[] = new int[heights.length];
      for (int index =0; index < heights.length; index++) {
        heightsFreq[heights[index]]++;
      }
      int count =0, diffCount =0;
      for (int index =0; index < heightsFreq.length && count < heights.length;index++) {
        while (heightsFreq[index] > 0) {
          expected[count++] = index;
          heightsFreq[index]--;
        }
      }
      for (int index =0; index < heights.length; index++) {
        if(heights[index] != expected[index]) {
          diffCount++;
        }
      }
      return diffCount;   
    }
}