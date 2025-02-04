class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<int[]> q = new LinkedList<>();
        int vis[] = new int[graph.length];
        Arrays.fill(vis,-1);

        for(int j=0; j<vis.length; j++){
            
            if(vis[j]!=-1) continue;
            q.offer(new int[]{j,0});
            vis[j] = 0;

            while(!q.isEmpty()){
                int node = q.peek()[0] , col = q.poll()[1];

                for(int i:graph[node]){
                    if(vis[i]!=-1){
                        if(vis[i]==col) return false;
                    }
                    else{
                        q.offer(new int[]{i,1-col});
                        vis[i] = 1-col;
                    }
                }
            }
        }
        // for(int i:vis){
        //     if(i==-1) return false;
        // }
        return true;

    }
}