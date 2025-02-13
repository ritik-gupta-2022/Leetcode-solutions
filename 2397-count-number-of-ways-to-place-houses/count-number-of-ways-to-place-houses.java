class Solution {
    final static int MOD = (int)1e9+7;
    public int helper(int n, int a, int b, int dp[][][]){
        if(n==0){
            return 1;
        }
        if(dp[n][a][b]!=-1) return dp[n][a][b];
        int ans=0;
        if(a!=1){
            ans=(ans+helper(n-1,1,0,dp))%MOD;
        }
        if(b!=1){
            ans=(ans+helper(n-1,0,1,dp))%MOD;
        }
        if(a!=1 && b!=1){
            ans=(ans+helper(n-1,1,1,dp))%MOD;
        }
        ans=(ans+helper(n-1,0,0,dp))%MOD;

        return dp[n][a][b]=ans;
    }
    public int countHousePlacements(int n) {
        int dp[][][] = new int[n+1][3][3];
        for(int d[][]:dp)
            for(int a[]:d)
                Arrays.fill(a,-1);
        return helper(n,2,2,dp);
    }
}