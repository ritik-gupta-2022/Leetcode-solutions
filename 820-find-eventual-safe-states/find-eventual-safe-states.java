class Solution {
    public boolean dfs(int node, int arr[][], boolean path[], boolean vis[], boolean notsafe[]){
        path[node] = true;
        vis[node] = true;

        for(int i:arr[node]){
            if(vis[i] && path[i]){
                return true;
            }
            if(vis[i] && notsafe[i]) return true;
            if(vis[i]) continue;

            if(dfs(i,arr,path,vis,notsafe)){
                notsafe[i]=true;
                return true;
            }
        }

        path[node] = false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean path[] = new boolean[graph.length];
        boolean notsafe[] = new boolean[graph.length];
        List<Integer> ls = new ArrayList<>();
        for(int i=0; i<graph.length; i++){
            if(vis[i] && notsafe[i]) continue;
            if(vis[i]) ls.add(i);

            else if(dfs(i,graph,path,vis,notsafe)){
                notsafe[i] = true;
            }
            else ls.add(i);
        }
        return ls;

    }
}