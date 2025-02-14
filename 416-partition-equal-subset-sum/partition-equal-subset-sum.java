class Solution {
    public boolean helper(int arr[], int i, int s, int total, int dp[][]){
        if(i>=arr.length && s==total/2)
            return true;
        if(s>total/2 || i>=arr.length)
            return false;
        if(dp[i][s]!=-1) return dp[i][s]==1;

        boolean take = false , not = false;

        take=helper(arr,i+1,s+arr[i],total,dp);
        
        not=helper(arr,i+1,s,total,dp);

         dp[i][s]=take||not?1:0;
         return dp[i][s]==1;
    }
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int i:nums)
            total+=i;

        if(total%2!=0) return false;

        int dp[][] = new int[nums.length][total/2+1];
        for(int d[]:dp) Arrays.fill(d,-1);

        return helper(nums,0,0,total,dp);
    }
}