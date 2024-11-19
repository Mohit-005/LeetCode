class Solution {
    public int dpApproach(int m,int n,Integer[][] dp,int startRow,int startColumn){
        if(startRow==m-1 && startColumn==n-1){
           return 1;
        }
        if(startRow<0 ||startColumn<0||startColumn>=n || startRow>=m)
            return 0;
        if(dp[startRow][startColumn]!=null)
            return dp[startRow][startColumn];
        int[][]distanceMatrix={{1,0},{0,1}};
        int uniquePath=0;
        for(int[] dist : distanceMatrix){
            uniquePath+=dpApproach(m,n,dp,startRow+dist[0],startColumn+dist[1]);
        }
         dp[startRow][startColumn]=uniquePath;
        return uniquePath;
    }
    
    public int uniquePaths(int m, int n) {
        Integer[][] dp=new Integer[m][n];
        return dpApproach(m,n,dp,0,0);
    }
}