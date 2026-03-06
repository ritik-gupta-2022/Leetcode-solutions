class Solution {
    public int solve(int[] nums, int k){
       
        int l=0, r=0, ans=0, n=nums.length, c=0;
        while(r<n && l<=r){
            int ele = nums[r];
            if((ele & 1) == 1){
                c++;
            }

            while(c>k){
               if((nums[l++] & 1) == 1) c--;
            }

            if(c<=k) ans+=r-l+1;
            r++;
        }
        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return solve(nums,k) - solve(nums,k-1);
    }
}