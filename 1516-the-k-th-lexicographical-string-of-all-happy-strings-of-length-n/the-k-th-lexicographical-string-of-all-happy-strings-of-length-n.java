class Solution {
    List<String> ls;
    public void helper(String ans, char last, int n){
        if(ans.length()==n){
            ls.add(ans);
            return;
        }
        if(last!='a') helper(ans+'a','a',n);
        if(last!='b') helper(ans+'b','b',n);
        if(last!='c') helper(ans+'c','c',n);

        return;
    }
    public String getHappyString(int n, int k) {
        ls = new ArrayList<>();
        helper("",'.',n);
        return ls.size() < k ? "" : ls.get(k-1);
    }
}