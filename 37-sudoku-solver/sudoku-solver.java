class Solution {
    public boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) return false;
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }

    public boolean helper(char arr[][]){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(arr[i][j]!='.') continue;

                for(char val='1'; val<='9'; val++){
                    if(isValid(arr,i,j,val)){
                        arr[i][j] = val;
                        if(helper(arr)) return true;
                        arr[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        helper(board);
    }
}