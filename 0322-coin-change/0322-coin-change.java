class Solution {
    public int solve(int arr[],int amount,int i,int n,int dp[][]){
       if(amount==0)
       {
        return 0;
       }
       if(amount<0 || i==n)
       {
        return Integer.MAX_VALUE;
       }
       if(dp[i][amount]!=-1)
       {
        return dp[i][amount];
       }
       int pick=Integer.MAX_VALUE,NotPick=Integer.MAX_VALUE;
       if(amount >= arr[i])
       {
            int temp=solve(arr,amount-arr[i],i,n,dp);
            if(temp!=Integer.MAX_VALUE)
            {
                pick=1+temp;
            }
       }
       NotPick=solve(arr,amount,i+1,n,dp);
       return dp[i][amount]=Math.min(pick,NotPick);
    }
    public int coinChange(int[] coins, int amount) 
    {
        int n=coins.length;
        int dp[][]=new int[n+1][amount+1];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        if(amount==0)
        {
            return 0;
        }
        int ans=solve(coins,amount,0,n,dp);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}