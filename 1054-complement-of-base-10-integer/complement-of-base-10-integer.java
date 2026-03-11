class Solution {
    public int bitwiseComplement(int n) {
        int bits = (int)(Math.log(n) / Math.log(2)) + 1; // find no. of bits
        int set = (1 << bits) - 1; // set all bits
        return set ^ n;
    }
}