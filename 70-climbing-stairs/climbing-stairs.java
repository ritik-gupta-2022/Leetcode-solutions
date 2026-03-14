class Solution {
    int dp[];
    public int helper(int n){
        if(n<=0) return 1;

        if(dp[n]!=-1) return dp[n];

        int ans = helper(n-1);
        if(n>1) ans+=helper(n-2);

        return dp[n] = ans;
    }
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n);
    }
}