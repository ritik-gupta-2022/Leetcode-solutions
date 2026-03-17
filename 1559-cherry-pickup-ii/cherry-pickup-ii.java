class Solution {
    int dp[][][];
    public int helper(int arr[][], int i, int c1, int c2){
        if(c1<0 || c2<0 || c1>=arr[0].length || c2>=arr[0].length) return -100000;
        if(i==arr.length) return 0;

        if(dp[i][c1][c2]!=-1) return dp[i][c1][c2];
        
        int ans = -1, val=0;;
        ans = Math.max(ans,helper(arr,i+1,c1+1,c2));
        ans = Math.max(ans,helper(arr,i+1,c1+1,c2+1));
        ans = Math.max(ans,helper(arr,i+1,c1+1,c2-1));
        ans = Math.max(ans,helper(arr,i+1,c1,c2));
        ans = Math.max(ans,helper(arr,i+1,c1,c2+1));
        ans = Math.max(ans,helper(arr,i+1,c1,c2-1));
        ans = Math.max(ans,helper(arr,i+1,c1-1,c2));
        ans = Math.max(ans,helper(arr,i+1,c1-1,c2+1));
        ans = Math.max(ans,helper(arr,i+1,c1-1,c2-1));

        if(c1==c2) val = arr[i][c1];
        else val = arr[i][c1]+arr[i][c2];

        return dp[i][c1][c2] = ans+val;
    }
    public int cherryPickup(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        dp = new int[m][n][n];
        for(int i[][]:dp){
            for(int k[]:i) Arrays.fill(k,-1);
        }
        return helper(arr,0,0,n-1);
    }
}