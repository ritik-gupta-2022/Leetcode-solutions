class Solution {
    public boolean search(int[] nums, int k) {
        int l=0, h=nums.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]==k) return true;
            if(nums[l]==nums[mid] && nums[mid]==nums[h]){
                l=l+1; 
                h=h-1;
            }
            else if(nums[l]<=nums[mid]){
                if(k>=nums[l] && k<nums[mid]) h=mid-1;
                else l=mid+1;
            }
            else{
                if(k>nums[mid] && k<=nums[h]) l=mid+1;
                else h=mid-1;
            }
        }
        return false;
    }
}