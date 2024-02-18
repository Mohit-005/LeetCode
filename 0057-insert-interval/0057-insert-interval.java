class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
         ArrayList<int[]> uwu = new ArrayList<>();
        
         for(int[] i : intervals){
             if(newInterval == null || i[1] < newInterval[0]){
                 uwu.add(i);
             }else if(i[0] > newInterval[1]){
                 uwu.add(newInterval);
                 uwu.add(i);
                 newInterval = null;
             }else{
                 newInterval[0] = Math.min(newInterval[0], i[0]);
                 newInterval[1] = Math.max(newInterval[1], i[1]);
             }
         }
        
        if(newInterval != null)
            uwu.add(newInterval);
        
        return uwu.toArray(new int[uwu.size()][]);
    }
}