class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        if(nums.length==1 || nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;

        int l=0, h=n-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) return mid;
            else if(nums[mid-1]>nums[mid]) h=mid;
            else l=mid;
        }
        return -1;
    }
}