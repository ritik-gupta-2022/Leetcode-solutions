class Solution {
    int dp[][][];
    public int helper(int arr[][], int i, int c1, int c2){
        if(c1<0 || c2<0 || c1>=arr[0].length || c2>=arr[0].length) return -100000;
        if(i==arr.length) return 0;

        if(dp[i][c1][c2]!=-1) return dp[i][c1][c2];
        
        int ans = -1, val=0;;
        ans = Math.max(ans,helper(arr,i+1,c1+1,c2));
        ans = Math.max(ans,helper(arr,i+1,c1+1,c2+1));
        ans = Math.max(ans,helper(arr,i+1,c1+1,c2-1));
        ans = Math.max(ans,helper(arr,i+1,c1,c2));
        ans = Math.max(ans,helper(arr,i+1,c1,c2+1));
        ans = Math.max(ans,helper(arr,i+1,c1,c2-1));
        ans = Math.max(ans,helper(arr,i+1,c1-1,c2));
        ans = Math.max(ans,helper(arr,i+1,c1-1,c2+1));
        ans = Math.max(ans,helper(arr,i+1,c1-1,c2-1));

        if(c1==c2) val = arr[i][c1];
        else val = arr[i][c1]+arr[i][c2];

        return dp[i][c1][c2] = ans+val;
    }
    public int cherryPickup(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        dp = new int[m][n][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    dp[i][j][k] = -1000000;
                }
            }
        }

        dp[0][0][n-1] = arr[0][0] + (n-1 == 0 ? 0 : arr[0][n-1]);


        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    int ans = -1000000, val=0;
                    if(j>0)
                    {
                            ans = Math.max(ans, dp[i-1][j-1][k]);
                        if(k<n-1)
                            ans = Math.max(ans, dp[i-1][j-1][k+1]);
                        if(k>0)
                            ans = Math.max(ans, dp[i-1][j-1][k-1]);
                    }
                    if(j<n-1)
                    {
                            ans = Math.max(ans,dp[i-1][j+1][k]);
                        if(k<n-1)
                            ans = Math.max(ans,dp[i-1][j+1][k+1]);
                        if(k>0)
                            ans = Math.max(ans,dp[i-1][j+1][k-1]);
                    }
                        ans = Math.max(ans,dp[i-1][j][k]);
                    if(k<n-1)
                        ans = Math.max(ans,dp[i-1][j][k+1]);
                    if(k>0)
                        ans = Math.max(ans,dp[i-1][j][k-1]);

                    if(ans == -1000000) continue;
                    
                    if(j==k)
                        ans+=arr[i][j];
                    else 
                        ans+=arr[i][j] + arr[i][k];

                    dp[i][j][k] = ans;
                }
            }
        }
        int ans = -1;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                ans = Math.max(ans,dp[m-1][i][j]);
        }
        return ans;
    }
}