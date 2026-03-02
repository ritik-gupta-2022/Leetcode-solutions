class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Long> freq = new HashMap<>();

        long pairs = 0;
        long ans = 0;

        int l = 0;

        for(int r = 0; r < n; r++){

            long count = freq.getOrDefault(nums[r], 0L);

            // When adding nums[r]
            pairs += count;
            freq.put(nums[r], count + 1);

            // While we have enough pairs
            while(pairs >= k){

                // All subarrays from r to end are valid
                ans += (n - r);

                // Remove nums[l]
                long leftCount = freq.get(nums[l]);
                freq.put(nums[l], leftCount - 1);

                pairs -= (leftCount - 1);

                l++;
            }
        }

        return ans;
    }
}