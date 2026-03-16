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

        dp[0][0] = 1;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0) continue;

                int a = 0, b =0;
                if(i>0) a = dp[i-1][j];
                if(j>0) b = dp[i][j-1];

                dp[i][j] = a+b;
            }
        }

        return dp[m-1][n-1];
    }
}