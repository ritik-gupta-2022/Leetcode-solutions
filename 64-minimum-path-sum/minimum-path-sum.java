class Solution {
    public int dp[][];
    public int helper(int arr[][], int i, int j){
        if(i==0 && j==0) return arr[0][0];
        if(i<0 || j<0) return 1000000;

        if(dp[i][j]!=-1) return dp[i][j];

        int top = helper(arr,i-1,j);
        int left = helper(arr,i,j-1);

        return dp[i][j] = arr[i][j] + Math.min(top,left);

    }
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        dp = new int[m][n];

        dp[0][0] = grid[0][0];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0) continue;

                int a = 10000000, b=10000000;
                if(i>0) a = dp[i-1][j];
                if(j>0) b = dp[i][j-1];

                dp[i][j] = grid[i][j] + Math.min(a,b);
            }
        }
        return dp[m-1][n-1];
    }
}