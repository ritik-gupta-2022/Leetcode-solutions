class Solution {
    int ans=-1;
     public void dfs(int node, int[] edges, Map<Integer, Integer> dist, boolean[] visit) {
        visit[node] = true;
        int neigh = edges[node];

        if(neigh != -1 && !visit[neigh]){
            dist.put(neigh, dist.get(node) + 1);
            dfs(neigh, edges, dist, visit);
        } else if(neigh != -1 && dist.containsKey(neigh)){
            ans = Math.max(ans, dist.get(node) - dist.get(neigh) + 1);
        }
    }

    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visit = new boolean[n];

        for(int i = 0; i < n; i++){
            if (!visit[i]) {
                Map<Integer, Integer> dist = new HashMap<>();
                dist.put(i, 1);
                dfs(i, edges, dist, visit);
            }
        }
        return ans;
    }
}