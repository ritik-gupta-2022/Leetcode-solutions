class Solution {
    // int c=0;
    public int paths(int[][] grid,int cr,int cc,int row,int col,int zero){
        if(cr>=grid.length || cc>=grid[0].length || cr<0 || cc<0 || grid[cr][cc]==-1){
            return 0;
        }
        if(cr==row && cc==col && zero==-1){
            // c++;
            return 1;
        }
        
        grid[cr][cc]=-1;

           int r= paths(grid, cr,   cc+1, row, col, zero-1); // right
           int d= paths(grid, cr+1, cc,   row, col, zero-1); // down
           int l= paths(grid, cr,   cc-1, row, col, zero-1); // left
           int u= paths(grid, cr-1, cc,   row, col, zero-1); // up

        grid[cr][cc]=0;
        return r+d+l+u;
    }
    public int uniquePathsIII(int[][] grid) {
        int zeroes=0;
        int sr=0, sc=0;
        int er=0, ec=0;
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[0].length; j++)
            {
                if(grid[i][j]==0) zeroes++;

                else if(grid[i][j]==1){
                    sr=i; sc=j;
                }
                else if(grid[i][j]==2){
                    er=i; ec=j;
                }
            }
        }
        int count= paths(grid, sr, sc, er, ec, zeroes);
        return count;
    }
}