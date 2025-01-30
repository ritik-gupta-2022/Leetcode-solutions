class Solution {
    public void dfs(int arr[][], int vis[], int node){
        vis[node]=1;

        for(int i=0; i<arr[0].length; i++){
            if(arr[node][i]==1 && vis[i]==0){
                dfs(arr,vis,i);
            }
        }
    }
    public int findCircleNum(int[][] arr) {
        int vis[] = new int[arr.length];
        int ans=0;
        for(int i=0; i<arr.length; i++){
            if(vis[i]!=1){
                ans++;
                dfs(arr,vis,i);
            }
        }
        return ans;
    }
}