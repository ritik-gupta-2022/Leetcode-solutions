class Solution {
    public void dfs(int arr[][], int i, int j){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]!=1)
            return;
        
        arr[i][j]=-1;

        dfs(arr,i+1,j+0);
        dfs(arr,i+0,j+1);
        dfs(arr,i-1,j+0);
        dfs(arr,i+0,j-1);

    }
    public int numEnclaves(int[][] arr) {
        int m=arr.length , n=arr[0].length;

        for(int i=0; i<m; i++){
            if(arr[i][0]==1) dfs(arr, i,0);
            if(arr[i][n-1]==1) dfs(arr, i, n-1);
        }
        for(int i=0; i<n; i++){
            if(arr[0][i]==1) dfs(arr, 0,i);
            if(arr[m-1][i]==1) dfs(arr, m-1,i);
        }
        int ans=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]==1) ans++;
            }
        }
        return ans;
    }
}