class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length , n =mat[0].length;
        int vis[][] = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==0) 
                    q.offer(new int[]{i,j});
            }
        }
        
        int dir[][] = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        while(!q.isEmpty()){
            int x = q.peek()[0] , y = q.poll()[1];
            for(int d[]:dir){
                int nx = x+d[0] , ny =y+d[1];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && mat[nx][ny] == 1 && vis[nx][ny]==0){
                    mat[nx][ny] = mat[x][y]+1;
                    vis[nx][ny]=1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return mat;
    }
}