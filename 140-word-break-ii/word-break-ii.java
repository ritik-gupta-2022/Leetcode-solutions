class Solution {
    List<String> ls = new ArrayList<>();
    Set<String> set = new HashSet<>();

    public void helper(String s, String ans){
        if(s.length()==0){
            ls.add(ans.trim());
            return;
        }
        for(int i=1; i<=s.length(); i++){
            if(set.contains(s.substring(0,i))){
                helper(s.substring(i), ans+s.substring(0,i)+" ");
            }
        }

    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        for(String str:wordDict) set.add(str);
        helper(s,"");
        return ls;
    }
}