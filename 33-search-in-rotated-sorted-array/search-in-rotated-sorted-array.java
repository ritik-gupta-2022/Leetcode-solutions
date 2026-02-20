class Solution {
    public int search(int[] nums, int k) {
        int l=0, h=nums.length-1;
        int ans=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]==k) return mid;
            if(nums[l]<=nums[mid]){
                if(k>=nums[l] && k<nums[mid]) h=mid-1;
                else l=mid+1;
            }
            else{
                if(k>nums[mid] && k<=nums[h]) l=mid+1;
                else h=mid-1;
            }
        }
        return ans;
    }
}