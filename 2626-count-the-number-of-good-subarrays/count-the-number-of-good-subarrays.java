class Solution {
    public long countGood(int[] nums, int k) {
        HashMap<Integer,Long> map = new HashMap<>();
        int n = nums.length;
        long ans=0;
        long pairs = 0;
        int l=0;
        for(int r=0; r<n; r++){
            long freq = map.getOrDefault(nums[r],0L);
            pairs+=freq;
            map.put(nums[r],freq+1);

            while(pairs>=k){
                ans+=(n-r);

                long leftCount = map.get(nums[l]);
                map.put(nums[l], leftCount - 1);

                pairs -= (leftCount - 1);

                l++;
            }
        }
        return ans;
    }
}