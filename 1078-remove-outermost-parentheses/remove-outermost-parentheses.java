class Solution {
    public String removeOuterParentheses(String s) {
        if(s.length()<=2) return "";
        StringBuilder sb = new StringBuilder();

        int open=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                if(open>=1) sb.append('(');
                open++;
            }
            else{
                if(open>1) sb.append(')');
                open--;
            }
        }
        return sb.toString();
    }
}