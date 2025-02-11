class Solution {
    public int dfs(int arr[][], int i, int j, int dp[][]){
        if(i>=arr.length || i<0 || j>=arr[0].length || j<0){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];

        int ans=0;
        int dir[][] = {{1,0} , {0,1} ,{-1,0}, {0,-1}};

        for(int d[]:dir){
            int r=i+d[0] , c=j+d[1];

            if(r>=arr.length || r<0 || c>=arr[0].length || c<0 || arr[r][c]<=arr[i][j]) 
                continue;

            ans = Math.max(ans, dfs(arr,r,c,dp));
        }

        return dp[i][j]=ans+1;
    }
    public int longestIncreasingPath(int[][] arr) {
        int ans=1;
        int dp[][] = new int[arr.length][arr[0].length];
        for(int a[]:dp) Arrays.fill(a,-1);
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                ans=Math.max(ans,dfs(arr,i,j,dp));
            }
        }
        return ans;
    }
}