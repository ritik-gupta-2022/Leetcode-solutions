class Solution {
    Set<String> map = new HashSet<>();
    Map<String, Boolean> dp = new HashMap<>();

    public boolean helper(String s){
        if(s.length()==0){
            return true;
        }
        if(dp.containsKey(s)) return dp.get(s);

        boolean ans=false;
        for(int i=1; i<=s.length(); i++){
            if(map.contains(s.substring(0,i))){
                ans = ans || helper(s.substring(i));
            }
        }
        dp.put(s,ans);
        return ans;
    }
    public boolean wordBreak(String s, List<String> ls) {
        for(String str: ls){
            map.add(str);
        }
        helper(s);
        return dp.get(s);
    }
}