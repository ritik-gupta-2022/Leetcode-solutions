class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int row = 0;
        int col = 0;

        while (true) {

            int curr = mat[row][col];

            int up = (row > 0) ? mat[row - 1][col] : Integer.MIN_VALUE;
            int down = (row < m - 1) ? mat[row + 1][col] : Integer.MIN_VALUE;
            int left = (col > 0) ? mat[row][col - 1] : Integer.MIN_VALUE;
            int right = (col < n - 1) ? mat[row][col + 1] : Integer.MIN_VALUE;

            int max = curr;
            int newRow = row;
            int newCol = col;

            if (up > max) {
                max = up;
                newRow = row - 1;
                newCol = col;
            }
            if (down > max) {
                max = down;
                newRow = row + 1;
                newCol = col;
            }
            if (left > max) {
                max = left;
                newRow = row;
                newCol = col - 1;
            }
            if (right > max) {
                max = right;
                newRow = row;
                newCol = col + 1;
            }

            if (newRow == row && newCol == col) {
                return new int[]{row, col};
            }

            row = newRow;
            col = newCol;
        }
    }
}