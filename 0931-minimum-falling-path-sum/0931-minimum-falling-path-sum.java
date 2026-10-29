class Solution {
    // public int minSum(int n,int m,int[][] arr,int i,int j,int [][]dp)
    // {
    //     if(j < 0 || j >= m)
    //     {
    //        return Integer.MAX_VALUE;
    //     }
    //     if(i==n)
    //     {
    //         return 0;
    //     }
    //     if(dp[i][j]!=-1)
    //     {
    //         return dp[i][j];
    //     }
    //     int down=minSum(n,m,arr,i+1,j,dp);
    //     if(down!=Integer.MAX_VALUE)
    //     {
    //         down=arr[i][j]+down;
    //     }
    //     int oneDR=minSum(n,m,arr,i+1,j+1,dp);
    //     if(oneDR!=Integer.MAX_VALUE)
    //     {
    //         oneDR=arr[i][j]+oneDR;
    //     }
    //     int oneDL=minSum(n,m,arr,i+1,j-1,dp);
    //     if(oneDL!=Integer.MAX_VALUE)
    //     {
    //         oneDL=arr[i][j]+oneDL;
    //     }
        
    //     return dp[i][j]=Math.min(down,Math.min(oneDR,oneDL));
    // }
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix[0].length;
        int n=matrix.length;

        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        for(int j = 0; j < m; j++)
        {
            dp[n][j] = 0;
        } 

        for(int i=n-1;i>=0;i--)
        {
          for(int j=0;j<m;j++)
          {
            int down=dp[i+1][j];

            int oneDR = (j+1 < m) ? dp[i+1][j+1] : Integer.MAX_VALUE;
            int oneDL = (j-1 >= 0) ? dp[i+1][j-1] : Integer.MAX_VALUE;

            if(down!=Integer.MAX_VALUE)
            {
                down=matrix[i][j]+down;
            }
            if(oneDR!=Integer.MAX_VALUE)
            {
                oneDR=matrix[i][j]+oneDR;
            }
            if(oneDL!=Integer.MAX_VALUE)
            {
                oneDL=matrix[i][j]+oneDL;
            }
            dp[i][j]=Math.min(down,Math.min(oneDR,oneDL));
          }
        }
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < m; j++)
        {
            ans = Math.min(ans, dp[0][j]);
        }
        return  ans;
    }
}