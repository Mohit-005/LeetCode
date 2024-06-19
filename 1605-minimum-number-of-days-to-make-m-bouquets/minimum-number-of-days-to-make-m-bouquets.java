class Solution {
   
    int arr[];
    int m,k;
    public int minDays(int[] arr, int m, int k) {
    //    System.out.println(""+(m*k)+" "+arr.length);
        if(m*k<0 || m*k>arr.length)
        return -1;

        this.m = m;
        this.k = k;

        this.arr = arr;

        int max=arr[0];

        for(int i=1;i<arr.length;i++)
        max = Math.max(max, arr[i]);

        int st=1,en=max,md;

        while(st<=en) {
            md = (st+en)/2;
           // System.out.println(""+st+" "+en+" "+count(md));
            if(count(md)) {
                en = md-1;
            }
            else
            st = md+1;
        }

        return st;
    }

    boolean count(int val) {

        int temp=0,temp2=0;

        for(int i=0;i<arr.length;i++) {
            if(arr[i]<=val) {
                temp++;
                if(temp==k)
                {
                    temp=0;
                    temp2++;
                    if(temp2==m)
                    return true;
                }
            }
            else
            {
                if((arr.length-i)/k<m-temp2)
                return false;
                temp=0;
            }

        }
        return false;

    }
}