class Solution {
    int dp[][];
    public int helper(int arr[][], int i, int j){
        if( j<0 || j>=arr.length) return 1000000;
        if(i==0) return arr[0][j];

        if(dp[i][j]!=-1) return dp[i][j];

        int a = helper(arr,i-1,j);
        int b = helper(arr,i-1,j-1);
        int c = helper(arr,i-1,j+1);

        return dp[i][j] = arr[i][j] + Math.min(a,Math.min(b,c)); 
    }
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length;
        dp = new int[n][n];
        for(int i=0; i<n; i++) dp[0][i] = arr[0][i];

        int ans = Integer.MAX_VALUE;
        for(int i=1; i<n; i++){
            for(int j=0; j<n; j++){
                int a = 1000000, b=1000000, c=1000000;
                a = dp[i-1][j];
                if(j>0) b = dp[i-1][j-1];
                if(j<n-1) c = dp[i-1][j+1];

                dp[i][j] = arr[i][j] + Math.min(a,Math.min(b,c));
            }
        }
        for(int i=0; i<n; i++)
            ans = Math.min(ans, dp[n-1][i]);
        return ans;
    }
}