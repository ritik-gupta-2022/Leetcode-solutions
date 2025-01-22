class Solution {
    public int[][] updateMatrix(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        Queue<int[]> q= new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 0){
                    q.offer(new int[]{i, j});
                }
                else arr[i][j]=-1;
            }
        }
        int d[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while(!q.isEmpty()){
            int temp[] = q.poll();
            int x = temp[0] , y= temp[1];
            for(int a[]:d){
                int nx = x + a[0], ny = y + a[1];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && arr[nx][ny] == -1){
                    arr[nx][ny] = arr[x][y]+1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        
        return arr;
    }
}