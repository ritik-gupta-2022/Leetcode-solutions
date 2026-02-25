class Solution {
    public boolean helper(char[][] arr, int i, int j,String s){
        if(s.length()==0) return true;
        if(i<0 || i>=arr.length || j<0 || j>=arr[0].length){
            return false;
        }
        boolean ans = false;
        char ch = arr[i][j];
        if(s.charAt(0)==ch){
            arr[i][j]= '1';
            boolean up = helper(arr, i-1, j, s.substring(1));
            boolean down = helper(arr, i+1, j,  s.substring(1));
            boolean right = helper(arr, i, j+1,  s.substring(1));
            boolean left = helper(arr, i, j-1,  s.substring(1));
            arr[i][j]= ch;
            ans = up || down || right || left;
        }
        return ans;
    }
    public boolean exist(char[][] board, String word) {
        boolean ans=false;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                ans = ans || helper(board, i, j, word);
            }
        }
        return ans;
    }
}