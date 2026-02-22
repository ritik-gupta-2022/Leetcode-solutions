class Solution {
    public void helper(int n, String s, int open, int close ,List<String> ls){
        if(open==close && open+close==2*n){
            ls.add(s);
            return;
        }

        if(open<n){
            helper(n,s+'(', open+1,close,ls);
        } 
        if(close<open && close<n){
            helper(n,s+')', open,close+1,ls);
        }
        return;
    }
    public List<String> generateParenthesis(int n) {
        List<String> ls = new ArrayList<>();
        helper(n,"",0,0,ls);
        return ls;
    }
}