class Solution {
    public int earliestTime(int[][] tasks) {
        int ans=Integer.MAX_VALUE;
        for(int temp[]: tasks){
            ans=Math.min(temp[0]+temp[1], ans);
        }
        return ans;
    }
}