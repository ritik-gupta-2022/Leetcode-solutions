class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> al = new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        int left=0,top=0;
        int right=n-1,bottom=m-1;
        while(left<=right && top<=bottom)
        {
            for(int i=left; i<=right; i++)
                al.add(matrix[top][i]);
            top++;

            for(int i=top; i<=bottom; i++)
                al.add(matrix[i][right]);
            right--;

            if(bottom>=top)
            {
            for(int i=right; i>=left; i--)            
                al.add(matrix[bottom][i]);
            bottom--;
            }
            if(right>=left)
            {
            for(int i=bottom; i>=top; i--)
               al.add(matrix[i][left]);
            left++;
            }
        }
        return al;
    }
}