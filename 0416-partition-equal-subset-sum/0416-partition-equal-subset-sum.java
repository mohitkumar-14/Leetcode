class Solution {
    // public boolean PartitionSubset(int[] nums,int n,int sum ,int i,int dp[][])
    // {
        
    //     if(i==n)
    //     {
    //         return sum==0;
    //     }
    //     if(dp[i][sum]!=-1)
    //     {
    //         return dp[i][sum]==1;
    //     }

    //     boolean NotTake=PartitionSubset(nums,n,sum,i+1,dp);
    //     boolean take=false;

    //     if(nums[i]<=sum)
    //     {
    //         take=PartitionSubset(nums,n,sum-nums[i],i+1,dp);
    //     }
    //     boolean result= take || NotTake;

    //     dp[i][sum] = result ? 1:0;
    //     return result;
    // }
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
        sum=sum/2;
        int dp[][]=new int[n+1][sum+1];

        for(int i=0;i<=n;i++)
        {
           Arrays.fill(dp[i],-1);
        }
        
        for(int i=0;i<=sum;i++)
        {
            dp[n][i]=0;
        }
        dp[n][0]=1;

        for(int i=n-1;i>=0;i--)
        {
            for(int j=0;j<=sum;j++)
            {
                if(nums[i]>j){
                    dp[i][j]=dp[i+1][j];
                }
                else{
                    dp[i][j]= (dp[i+1][j]==1|| dp[i+1][j-nums[i]]==1)?1:0;
                }
            }
        }
        return dp[0][sum]==1;
    }
}