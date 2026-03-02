class Solution {
    public int numSub(String s) {
        long ans = 0;
        long mod = 1000000007;
        int n = s.length();
        int i = 0;

        while(i < n){
            if(s.charAt(i) == '0'){
                i++;
                continue;
            }
            long count = 0;
            while(i<n && s.charAt(i) == '1'){
                count++;
                i++;
            }
            ans = (ans+(count*(count+1)/2)%mod)%mod;
        }
        return (int)ans;
    }
}