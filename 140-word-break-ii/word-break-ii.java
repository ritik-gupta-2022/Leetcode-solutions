class Solution {
    List<String> ls = new ArrayList<>();
    Set<String> set = new HashSet<>();
    Map<String,List<String>> dp = new HashMap<>();

    public List<String> helper(String s){
        List<String> result = new ArrayList<>();

        if(s.length() == 0){
            result.add("");
            return result;
        }

        if(dp.containsKey(s))  return dp.get(s);

        for(int i=1; i<=s.length(); i++){
            String curr = s.substring(0,i);
            if(set.contains(curr)){
               List<String> rem =  helper(s.substring(i));
                for(String str: rem){
                    result.add((curr +" "+str).trim());
                }
            }
        }
        dp.put(s,result);
        return result;
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        for(String str:wordDict) set.add(str);
        return helper(s);
    }
}