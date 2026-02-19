class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int row = arr.length, col = arr[0].length;
        int i=0, j=col-1;
        while(i<arr.length && j>=0){
            if(arr[i][j]==target) return true;
            if(arr[i][j]>target) j--;
            else i++;
        }
        return false;
    }
}