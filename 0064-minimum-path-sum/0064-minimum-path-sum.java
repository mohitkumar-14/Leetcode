class Solution {
    public int pathSum(int[][] grid,int n,int m)
    {
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++)
        {
           Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[0][1]=0;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                dp[i][j]=grid[i-1][j-1]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        return pathSum(grid,n,m);
    }
}