class Solution {
    int dp[][];
    public int helper(int arr[], int[] op, int i, int l){
        if(i==op.length) return 0;

        int r = arr.length-1-(i - l);

        if(dp[i][l]!=-1) return dp[i][l];

        int a = (op[i] * arr[l]) + helper(arr,op,i+1,l+1);
        int b = (op[i] * arr[r]) + helper(arr,op,i+1,l);

        int ans = Math.max(a,b);

        return dp[i][l]=ans;

    }
    public int maximumScore(int[] nums, int[] multipliers) {
        int m = multipliers.length;
        dp = new int[m][m];
        for(int i[]:dp) Arrays.fill(i,-1);
        return helper(nums, multipliers, 0, 0);
    }
}