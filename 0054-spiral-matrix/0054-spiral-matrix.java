class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> arr=new ArrayList<>();
        int topLeft=0;
        int topRight=matrix[0].length-1;
        int bottomRight=matrix.length-1;
        int bottomLeft=matrix.length-1;
        while(topLeft<=topRight && topLeft<=bottomRight)
        {
            for(int i=topLeft;i<=topRight;i++)
            {
               arr.add(matrix[topLeft][i]);
            }

            for(int i=topLeft+1;i<=bottomRight;i++)
            {
                arr.add(matrix[i][topRight]);
            }
            if(topLeft < bottomRight)
            {
            for(int i=topRight-1;i>=topLeft;i--)
            {
                arr.add(matrix[bottomRight][i]);
            }
            }
            if(topLeft < topRight)
            {
             for(int i=bottomRight-1;i>topLeft;i--)
             {
                arr.add(matrix[i][topLeft]);
             }
            }
            
            topLeft++;
            topRight--;
            bottomRight--;
            bottomLeft--;
        }
        return arr;
    }
}