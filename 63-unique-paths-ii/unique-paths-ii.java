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
        if(arr[m-1][n-1]==1) return 0;
        dp = new int[m][n];
        for(int i[]: dp) Arrays.fill(i,-1);
        return helper(arr,m-1,n-1);
    }
}