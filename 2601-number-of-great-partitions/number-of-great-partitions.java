class Solution {
    int mod = (int)1e9 + 7;
    public int helper(int arr[],int i, int s, int k, int dp[][]){
        if(s>=k) return 0;
        if(i>=arr.length) return 1;

        if (dp[i][s] != -1) return dp[i][s];

        int notTaken = helper(arr, i+1, s,k, dp);

        int taken = helper(arr, i+1, s + arr[i],k, dp);

        return dp[i][s] = (taken + notTaken) % mod;
    }
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;

        int sum = 0;
        for(int i: nums)
            sum = (sum + i) % mod;
        
        if(sum/2 < k)
            return 0;
        
        int dp[][] = new int[n][k+1];
        for(int d[]:dp) Arrays.fill(d,-1);

        int invalid = helper(nums, 0,0, k, dp);
        int total = 1;

        for (int i = 1; i <= n; i++) {
            total = (total * 2) % mod;
        }

        int ans = total - 2*invalid;
        
        if (ans < 0)
            ans += mod;

        return ans % mod;
    }
}