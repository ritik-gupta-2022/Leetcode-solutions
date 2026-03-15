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
        int prev = nums[0];
        int prev2 = 0;
        int curr=0;
        int neg=0;

        
        for(int i=1; i<nums.length; i++){
            int rob = nums[i] + prev2;
            int notrob = prev;

            curr = Math.max(rob,notrob);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}