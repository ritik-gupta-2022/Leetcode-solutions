class Solution {
    public boolean path(int arr[][], int i, int j){
        if (i == arr.length-1 && j==arr[0].length-1) {
            return true;
        }
        if (i >= arr.length || j>=arr[0].length || arr[i][j] == 0) {
            return false;   
        }

         arr[i][j] = 0;
        return path(arr, i + 1, j) || path(arr, i, j + 1);
    }
    public boolean isPossibleToCutPath(int[][] grid) {
        int r=grid.length , c=grid[0].length;

        if((r<=2 && c==1) || (r==1 && c<= 2)) return false;
       
        if(!path(grid,0,0)) return true;

        grid[0][0] = 1;

        if(!path(grid, 0, 0))  return true; 

        return false;
    }
}