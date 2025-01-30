class Solution {
    public int orangesRotting(int[][] arr) {
        int fresh=0;
        Queue<int[]> q= new LinkedList<>();

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j]==1) fresh++;
                else if(arr[i][j]==2){
                    q.offer(new int[]{i,j});
                }
            }
        }
        if(fresh==0) return 0;
        if (q.isEmpty()) return -1;
        int minutes=-1;
        int dir[][] = {{1,0},{0,1},{0,-1},{-1,0}};

        while(!q.isEmpty()){
            
            int l = q.size();

            while(l-->0){
                int r=q.peek()[0];
                int c=q.poll()[1];

                for(int d[]:dir){
                    int i = r + d[0];
                    int j = c + d[1];
                    if (i>=0 && i<arr.length && j >= 0 && j<arr[0].length && arr[i][j] == 1) {
                        arr[i][j] = 2;
                        fresh--;
                        q.offer(new int[] {i, j});
                    }
                }
            }
            minutes++;
        }
        return fresh==0?minutes:-1;
    }
}