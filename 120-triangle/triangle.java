class Solution {
    int dp[][];
    public int helper(List<List<Integer>> ls, int i, int j){
        if(i>=ls.size()){
            return 0;
        }

        if(dp[i][j]!=-1) return dp[i][j];
        
        int down = helper(ls, i+1,j);
        int rdown = helper(ls, i+1,j+1);

        dp[i][j] = ls.get(i).get(j) + Math.min(down,rdown);
        return dp[i][j];
    }
    public int minimumTotal(List<List<Integer>> ls) {
        int m = ls.size();
        int n = ls.get(m-1).size();
        dp = new int[m][m];
        
        dp[0][0] = ls.get(0).get(0);

        for(int i=1; i<m; i++){
            int size = ls.get(i).size();
            for(int j=0; j<size; j++){
                int b = 100000, a=10000;
                if(j<i)
                    a = dp[i-1][j];
                if(j>0)
                    b = dp[i-1][j-1];

                dp[i][j] = ls.get(i).get(j) + Math.min(a,b);
            }
        }
        int ans=Integer.MAX_VALUE;

        for(int i=0; i<n; i++)
            ans=Math.min(dp[n-1][i],ans);
            
        return ans;
    }
}