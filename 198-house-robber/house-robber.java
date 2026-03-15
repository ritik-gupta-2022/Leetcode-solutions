class Solution {
    public int dp[];
    public int helper(int arr[], int i){
        if(i==0) return arr[i];
        if(i<0) return 0;

        if(dp[i]!=-1) return dp[i];

        int rob = arr[i] + helper(arr,i-2);
        int notRob = helper(arr,i-1);

        return dp[i] = Math.max(rob,notRob);

    }
    public int rob(int[] nums) {
        int dp[] = new int[nums.length+1];
        dp[0] = nums[0];
        int neg=0;
        
        for(int i=1; i<nums.length; i++){
            int rob = -1;
                rob = nums[i] + (i-2<0 ? neg : dp[i-2]);
            int notrob = dp[i-1];

            dp[i] = Math.max(rob,notrob);
        }
        return dp[nums.length-1];
    }
}