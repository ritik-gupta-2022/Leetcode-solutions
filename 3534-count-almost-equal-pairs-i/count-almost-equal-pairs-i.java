class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        // Ensure both numbers have the same length by padding with leading zeros
        while (s1.length() < s2.length()) s1 = "0" + s1;
        while (s2.length() < s1.length()) s2 = "0" + s2;

        int i = -1, j = -1, c = 0;
        for (int k = 0; k < s1.length(); k++) {
            if (s1.charAt(k) != s2.charAt(k)) {
                c++;
                if (i == -1) i = k;
                else if (j == -1) j = k;
            }
        }

        if (c == 0) return true;
        if (c == 2 && s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i)) {
            return true;
        }
        return false;
    }

    public int countPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (areAlmostEqual(String.valueOf(nums[i]), String.valueOf(nums[j]))) {
                    count++;
                }
            }
        }
        return count;
    }
}
