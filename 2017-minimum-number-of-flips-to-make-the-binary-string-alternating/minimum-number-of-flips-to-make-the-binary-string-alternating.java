class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int stzero = 0, stone = 0;

        for(int i=0; i<n; i++){
            if((i&1)==0){
                if(s.charAt(i)=='0') stone++;
                else stzero++;
            }
            else{
                if(s.charAt(i)=='0') stzero++;
                else stone++;
            }
        }
        int ans = Math.min(stzero,stone);
        int l=0, r=n;
        s = s+s;

        for(int i=1; i<n; i++){
            if((l&1)==0){
                if(s.charAt(l)=='0') stone--;
                else stzero--;
            }
            else{
                if(s.charAt(l)=='0') stzero--;
                else stone--;
            }

            if((r&1)==0){
                if(s.charAt(r)=='0') stone++;
                else stzero++;
            }
            else{
                if(s.charAt(r)=='0') stzero++;
                else stone++;
            }

            ans = Math.min(ans, Math.min(stone, stzero));

            l++; r++;
        }
        return ans;
    }
}