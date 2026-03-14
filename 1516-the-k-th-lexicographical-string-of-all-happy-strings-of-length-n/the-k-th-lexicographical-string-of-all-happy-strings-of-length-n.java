class Solution {
    int c=0;
    String res;
    public void helper(String ans, char last, int n, int k){
        if(ans.length()==n){
            c++;
            if(c==k) res=ans;
            return;
        }

        if(last!='a') helper(ans+'a','a',n,k);
        if(last!='b') helper(ans+'b','b',n,k);
        if(last!='c') helper(ans+'c','c',n,k);

        return;
    }
    public String getHappyString(int n, int k) {
        helper("",'.',n,k);
        return c < k ? "" : res;
    }
}