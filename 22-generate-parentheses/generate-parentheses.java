class Solution {
    public void helper(int n , int open , int close,String s,List<String>ls){
        if(open+close==2*n){
            ls.add(s);
            return;
        }

        if(open<n){
            helper(n,open+1,close,s+"(",ls);
        }
        if(open>close && close<n){
            helper(n,open,close+1,s+")",ls);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ls = new ArrayList<>();
        helper(n,0,0,"",ls);
        return ls;
    }
}