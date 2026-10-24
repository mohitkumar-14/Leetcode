class Solution {
    public boolean PartitionSubset(int[] nums,int n,int sum ,int i,int dp[][])
    {
        // if(sum==0)
        // {
        //     return true;
        // }
        if(i==n)
        {
            return sum==0;
        }
        if(dp[i][sum]!=-1)
        {
            return dp[i][sum]==1;
        }

        boolean NotTake=PartitionSubset(nums,n,sum,i+1,dp);
        boolean take=false;

        if(nums[i]<=sum)
        {
            take=PartitionSubset(nums,n,sum-nums[i],i+1,dp);
        }
        boolean result= take || NotTake;

        dp[i][sum] = result ? 1:0;
        return result;
    }
    public boolean canPartition(int[] nums) {
        
        int sum=0;
        for(int x:nums)
        {
            sum+=x;
        }
        if(sum%2!=0)
        {
            return false;
        }
        int n=nums.length;
        int dp[][]=new int[n+1][sum+1];
        for(int i=0;i<=n;i++)
        {
           Arrays.fill(dp[i],-1);
        }
        return PartitionSubset(nums,n,sum/2,0,dp);
    }
}