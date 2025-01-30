class Solution {
     public int count(int[][] arr) {
        boolean[][] vis = new boolean[arr.length][arr[0].length];
        int islands = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1 && !vis[i][j]) {
                    islands++;
                    dfs(arr, i, j, vis);
                }
            }
        }
        return islands;
    }

    public void dfs(int[][] arr, int r, int c, boolean[][] vis) {
        vis[r][c] = true;
        int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : d) {
            int i = r+dir[0], j = c+dir[1];
            if (i>=0 && i<arr.length && j >= 0 && j<arr[0].length && arr[i][j]==1 && !vis[i][j]) {
                dfs(arr, i, j, vis);
            }
        }
    }

    public int minDays(int[][] arr) {
        if (count(arr)!=1) return 0;

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if (arr[i][j] == 1) {
                    arr[i][j] = 0;
                    if (count(arr) != 1) return 1;
                    arr[i][j] = 1;
                }
            }
        }

        return 2;
    }
}