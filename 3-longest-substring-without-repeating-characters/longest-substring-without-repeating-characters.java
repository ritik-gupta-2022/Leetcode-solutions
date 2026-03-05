class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int l=0, r=0, n=s.length();
        int ans=0;
        while(r<n && l<n && l<=r){
            char ch = s.charAt(r);
            while(map.getOrDefault(ch,0)>0){
                char c = s.charAt(l);
                map.put(c,map.getOrDefault(c,0)-1);
                l++;
            }
            map.put(ch,map.getOrDefault(ch,0)+1);
            ans = Math.max(ans,r-l+1);
            r++;
        }
        return ans;
    }
}