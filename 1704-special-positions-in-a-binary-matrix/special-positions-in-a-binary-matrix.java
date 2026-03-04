class Solution {
    public int numSpecial(int[][] mat) {
        final int m = mat.length;
        final int n = mat[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 1) {
                    rowCount[row]++;
                    colCount[col]++;
                }
            }
        }
        
        int ans = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 1 && rowCount[row] == 1 && colCount[col] == 1) {
                        ans++;
                }
            }
        }
        
        return ans;
    }
}