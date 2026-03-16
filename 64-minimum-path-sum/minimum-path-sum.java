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
        for(int i[]: dp) Arrays.fill(i,-1);
        return helper(grid,m-1,n-1);
    }
}