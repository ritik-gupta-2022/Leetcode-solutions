class Solution {
    int dp[][];
    public int helper(int n1[], int n2[], int i, int last){
        if(i>=n1.length) return 0;
        if(dp[i][last]!=-1) return dp[i][last];
        int ans = 0;
        int a=0,b=0,c=0,val=0;
        if(last == 0){
            a = helper(n1,n2,i+1,0);
            b = 1+helper(n1,n2,i+1,1);
            c = 1+helper(n1,n2,i+1,2);
            ans = Math.max(a,Math.max(b,c));
        }
        else{
            if(last==1) val = n1[i-1];
            else val = n2[i-1];

            if(n1[i]>=val) a = 1+helper(n1,n2,i+1,1);
            if(n2[i]>=val) b = 1+helper(n1,n2,i+1,2);

            ans = Math.max(a,b);
        }
        return dp[i][last]=ans;
    }
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        dp = new int[nums1.length][3];
        for(int i[]:dp) Arrays.fill(i,-1);
        return helper(nums1,nums2,0,0);
    }
}