class Solution {
    private boolean backtrack(int[] nums, int index, int k, int currentSum, int target, boolean[] used) {
        if (k == 0) return true;
        if (currentSum == target) return backtrack(nums, nums.length - 1, k - 1, 0, target, used);

        for (int i = index; i >= 0; i--) {
            if (used[i] || currentSum + nums[i] > target) continue;

            used[i] = true;
            if (backtrack(nums, i - 1, k, currentSum + nums[i], target, used)) return true;
            used[i] = false;
        }

        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        int target = sum / k;
        
        Arrays.sort(nums);
        int n = nums.length;
        boolean[] used = new boolean[n];

        return backtrack(nums, n - 1, k, 0, target, used);
    }
}