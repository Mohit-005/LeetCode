class Solution {
    public int climbStairs(int n) {
         if(n == 1 || n == 0) return 1;
        
        int a = 0; int b = 1; int c = 0;
        
        for(int i = 1 ; i <= n ; i ++){
            c = a + b;
            a = b ; 
            b = c;
        }
        return c;
    }
}