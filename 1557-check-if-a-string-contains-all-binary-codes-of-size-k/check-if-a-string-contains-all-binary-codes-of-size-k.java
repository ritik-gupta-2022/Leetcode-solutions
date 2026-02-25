class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();

        for(int i = 0; i <= s.length() - k; i++){
            set.add(s.substring(i, i + k));
        }

        // this worls beacuse set contains unique string only then if it has equal size then it means it contains all possible binary code of k length()
        return set.size() == (1 << k);
    }
}