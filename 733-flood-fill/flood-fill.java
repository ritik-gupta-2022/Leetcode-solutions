class Solution {
    public int[][] floodFill(int[][] arr, int sr, int sc, int color) {
        int org = arr[sr][sc];
        if (org == color) return arr;
        
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{sr,sc});
        arr[sr][sc] = color;

        int dir[][] = {{0,1}, {1,0}, {-1,0}, {0,-1}};

        while(!q.isEmpty()){
            int r = q.peek()[0] , c=q.poll()[1];
            for(int d[]:dir){
                int i=d[0]+r , j=d[1]+c;
                if(i>=0 && i<arr.length && j>=0 && j<arr[0].length && arr[i][j]==org){
                    arr[i][j] = color; 
                    q.offer(new int[]{i,j});
                }
            }
        }
        return arr;
    }
}