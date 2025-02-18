class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        StringBuilder result = new StringBuilder();
        int[] st = new int[n + 1]; 
        int idx = 0;

        for(int i = 0; i <= n; i++){
            st[idx++] = i + 1;

            if(i == n || pattern.charAt(i) == 'I'){
                while (idx > 0) {
                    result.append(st[--idx]);
                }
            }
        }

        return result.toString();
    }
}