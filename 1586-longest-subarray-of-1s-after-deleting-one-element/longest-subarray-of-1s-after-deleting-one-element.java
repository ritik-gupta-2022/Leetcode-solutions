class Solution {
    public int longestSubarray(int[] nums) {
        int zeroes = 0;
        int l=0, r=0, n=nums.length;
        int ans=0;
        while(r<n && l<=r){
            int curr = nums[r];
            zeroes = curr == 0 ? zeroes+1 : zeroes;

            while(zeroes>1){
                zeroes = nums[l] == 0 ? zeroes-1 : zeroes;
                l++;
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans-1;
    }
}