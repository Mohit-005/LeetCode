class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int j=-1,i;
        for(i=0;i<n;i++)
        {
            if(nums[i]==0)
            {
                j=i;
                break;
            }
        }
        while(i<n)
        {
            if(nums[i]!=0)
            {
                nums[j++]=nums[i];
                nums[i]=0;
            }
            i++;
        }
    }
}