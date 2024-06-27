class Solution {
    public int findCenter(int[][] edges) {
        //the one that is common in sab
        int u=edges[0][0];
        int v=edges[0][1];
        int x=edges[1][0];
        int y=edges[1][1];
        return (u==x || u==y?u:v);
    }
}