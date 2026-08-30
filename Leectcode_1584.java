class Solution {
    public boolean checkCost(int [][]grid,int mid,int Startrow,int Startcol)
    {
        int n=grid.length;
        int m=grid[0].length;
       if(grid[Startrow][Startcol] > mid)
       {
            return false;
       }
       int x[]={-1,1,0,0};
       int y[]={0,0,1,-1};

       boolean visited[][]=new boolean[n][m];

       Queue<int []> q=new LinkedList<>();

       q.offer(new int []{Startrow,Startcol});
       visited[Startrow][Startcol]=true;

       while(!q.isEmpty())
       {
        int[] curr = q.poll();
        int row = curr[0];
        int col = curr[1];
        if(row==n-1 && col==m-1)
        {
            return true;
        }

        for(int k=0;k<4;k++)
        {
            int nr=row+x[k];
            int nc=col+y[k];

            if(nr<0 || nc<0 || nr>=n || nc>=m)
            {
                continue;
            }
            
            if(!visited[nr][nc] && grid[nr][nc] <= mid)
            {
                visited[nr][nc]=true;
                q.offer(new int[]{nr,nc});
            }
         }
       }
       return false;
    }
    public int swimInWater(int[][] grid) {

        int low=grid[0][0];
        int high=-1;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                high=Math.max(high,grid[i][j]);
            }
        }
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(checkCost(grid,mid,0,0))
            {
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}