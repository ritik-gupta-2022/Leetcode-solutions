class Solution {
    public int dp[][];
    public int helper(int arr[][], int i, int j){
        if(i==0 && j==0) return 1;

        if(dp[i][j]!=-1) return dp[i][j];
        
        int top = 0, left = 0;

        if(i>0 && arr[i-1][j]!=1) top =  helper(arr,i-1,j);
        if(j>0 && arr[i][j-1]!=1) left = helper(arr,i,j-1);

        return dp[i][j] =  top+left;
    }
    public int uniquePathsWithObstacles(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        dp = new int[m][n];
        if(arr[m-1][n-1]==1) return 0;

        dp[0][0] = 1;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0) continue;

                int a=0, b=0;
                if(i>0 && arr[i-1][j]!=1) a =  dp[i-1][j];
                if(j>0 && arr[i][j-1]!=1) b = dp[i][j-1];

                dp[i][j]=a+b;
            }
        }
        return dp[m-1][n-1];
    }
}