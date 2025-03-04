class Solution {
    public boolean helper(int arr[], int i, int sum, int target, int dp[][]){
        if(sum==target/2){
            return true;
        }
        if(i>=arr.length || sum>target/2) return false;

        if(dp[i][sum]!=-1) return dp[i][sum]==1;

        boolean take = helper(arr, i+1, sum+arr[i], target, dp);
        boolean not = helper(arr, i+1, sum, target, dp);

        dp[i][sum]=take||not?1:0;
        return dp[i][sum]==1;

    }
    public boolean canPartition(int[] nums) {
        int s=0;
        for(int i:nums) s+=i;
        if(s%2!=0) return false;

        int dp[][] = new int[nums.length][s/2 + 1];
        for(int d[]:dp) Arrays.fill(d,-1);

        return helper(nums,0,0,s,dp);
    }
}