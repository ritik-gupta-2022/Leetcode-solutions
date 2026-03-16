class Solution {
    public int dp[][];
    public int helper(int i, int j){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int top = helper(i-1,j);
        int left = helper(i,j-1);

        return dp[i][j]  = top+left;

    }
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int i[]: dp) Arrays.fill(i,-1);

        return helper(m-1,n-1);
    }
}