class Solution {
    int k=0;
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], boolean path[], int ans[], int node){
        vis[node] =true;
        path[node] =true;

        for(int i:adj.get(node)){
            if(vis[i] && path[i]) return true;
            if(vis[i]) continue;
            if(dfs(adj,vis,path,ans,i)) return true;
        }
        path[node] = false;
        ans[k++] = node;
        return false;
    }
    public int[] findOrder(int courses, int[][] arr) {
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
        for(int i=0; i<courses; i++){
            ls.add(new ArrayList<>());
        }
        for(int i=0; i<arr.length; i++){
            int course = arr[i][0] , pre = arr[i][1];
            ls.get(course).add(pre);
        }

        boolean vis[] = new boolean[courses];
        boolean path[]= new boolean[courses];

        int ans[] = new int[courses];
        for(int i=0; i<courses; i++){
            if(!vis[i]){
                if(dfs(ls,vis,path,ans,i)) return new int[]{};
            }
        }
        return ans;
    }
}