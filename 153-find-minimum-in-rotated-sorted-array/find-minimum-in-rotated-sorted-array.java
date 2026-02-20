class Solution {
    public int findMin(int[] nums) {
        int l=0, h=nums.length-1;
        int ans = Integer.MAX_VALUE;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]>=nums[l]){
                ans=Math.min(nums[l],ans);
                l=mid+1;
            }
            else{
                ans=Math.min(nums[mid],ans);
                h=mid-1;
            }
        }
        return ans;
    }
}