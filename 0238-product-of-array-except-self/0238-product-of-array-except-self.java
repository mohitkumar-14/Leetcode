class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        
        // int prefix[]=new int[n];
        // prefix[0]=1;
        // prefix[1]=1*nums[0];
        // for(int i=2;i<n;i++)
        // {
        //     prefix[i]=nums[i-1]*prefix[i-1];
        // }

        // int suffix[]=new int[n];
        // suffix[n-1]=1;
        // suffix[n-2]=1*nums[n-1];
        // for(int i=n-3;i>=0;i--)
        // {
        //     suffix[i]=nums[i+1]*suffix[i+1];
        // }

        // for(int i=0;i<n;i++)
        // {
        //     ans[i]=prefix[i]*suffix[i];
        // }
        int prefix=1,suffix=1;
        for(int i=0;i<n;i++)
        {
            ans[i]=prefix;
            prefix*=nums[i];
        }
        for(int i=n-1;i>=0;i--)
        {
            ans[i]=ans[i]*suffix;
            suffix*=nums[i];
        }
        return ans;
    }
}