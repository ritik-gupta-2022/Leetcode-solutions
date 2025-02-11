class Solution {
    final static int MOD = 1000000007;

    public int dfs(int[][] grid, int i, int j, int dp[][]) {
        if (dp[i][j] != -1) return dp[i][j]; 
        
        int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        int ans = 1; 
        
        for (int[] d:dir) {
            int r = i + d[0], c = j + d[1];
            if (r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c] > grid[i][j]) {
                ans =(ans + dfs(grid,r,c,dp))%MOD;
            }
        }
        
        return dp[i][j] = ans; 
    }

    public int countPaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int dp[][] = new int[m][n]; 
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = 0;
        for (int i=0;i<m;i++) {
            for (int j=0; j<n; j++) {
                ans=(ans + dfs(grid,i,j,dp)) % MOD;
            }
        }
        return ans;
    }
}