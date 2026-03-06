class Solution {
    public int solve(String s, int k){
        Map<Character,Integer> map = new HashMap<>();

        int l=0, r=0, ans=0, n = s.length();

        while(r<n && l<=r){
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch,0)+1);

            while(map.size()>k){
                char c = s.charAt(l);
                map.put(c, map.getOrDefault(c,0)-1);
                if(map.getOrDefault(c,0) <=0 ) map.remove(c);
                l++;
            }

            ans += r-l+1;
            r++;
        }
        return ans;
    }
    public int numberOfSubstrings(String s) {
        return solve(s,3) - solve(s,2);
    }
}