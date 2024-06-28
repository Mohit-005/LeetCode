class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int imp[]=new int[n];
        for(int[] a:roads){
            imp[a[0]]++;
            imp[a[1]]++;
        }
        int[] arr=new int[roads.length+1];
        for(int i:imp) arr[i]++;
        int x=n;
        long ans=0;
        for(int i=arr.length-1;i>=0;i--){
            while(arr[i]!=0){
                ans+=((long)x*(long)i);
                x--;
                arr[i]--;
            }
        }
        return ans;
    }
}