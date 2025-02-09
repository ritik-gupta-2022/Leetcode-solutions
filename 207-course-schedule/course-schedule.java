class Solution {
    public boolean dfs(int node, boolean vis[], boolean path[], ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        path[node] = true;

        for(int i:adj.get(node)){
            if(vis[i] && path[i]) return true;
            if(vis[i]) continue;
            if(dfs(i,vis,path,adj)) return true;
        }
        path[node] = false;
        return false;
    }
    public boolean canFinish(int courses, int[][] arr) {
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

        for(int i=0; i<courses; i++){
            if(!vis[i]){
                if(dfs(i,vis,path,ls)) return false;
            }
        }
        // System.out.print(ls.toString());
        return true;
    }
}