class Solution {

    int MOD = 1000000007;
    Integer[][][] dp;

    public int helper(int z, int o, int last, int limit) {

        if (z == 0 && o == 0) return 1;

        if (dp[z][o][last] != null) return dp[z][o][last];

        long ans = 0;

        if (last == 0) {

            for (int i = 1; i <= Math.min(z, limit); i++) {
                ans = (ans + helper(z - i, o, 1, limit)) % MOD;
            }

        } else {

            for (int i = 1; i <= Math.min(o, limit); i++) {
                ans = (ans + helper(z, o - i, 0, limit)) % MOD;
            }

        }

        return dp[z][o][last] = (int) ans;
    }

    public int numberOfStableArrays(int zero, int one, int limit) {

        dp = new Integer[zero + 1][one + 1][2];

        long ans = 0;

        for (int i = 1; i <= Math.min(zero, limit); i++) {
            ans = (ans + helper(zero - i, one, 1, limit)) % MOD;
        }

        for (int i = 1; i <= Math.min(one, limit); i++) {
            ans = (ans + helper(zero, one - i, 0, limit)) % MOD;
        }

        return (int) ans;
    }
}