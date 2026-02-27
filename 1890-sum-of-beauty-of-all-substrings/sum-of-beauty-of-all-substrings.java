class Solution {
    public int beautySum(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            
            for (int j = i; j < n; j++) {
                
                freq[s.charAt(j) - 'a']++;
                int minFreq = Integer.MAX_VALUE;
                int maxFreq = Integer.MIN_VALUE;
                
                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) { 
                        minFreq = Math.min(minFreq, freq[k]);
                        maxFreq = Math.max(maxFreq, freq[k]);
                    }
                }
                
                ans += (maxFreq - minFreq);
            }
        }
        
        return ans;
    }
}