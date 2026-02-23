class Solution {
    public int minAddToMakeValid(String s) {
        int open=0;
        int opencnt=0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='(') open++;
            else open--;
            if(open<0){
                opencnt++;
                open=0;
            }
        }
        int close=0,  closecnt=0;
        for(int i=s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            if(ch==')') close++;
            else close--;
            if(close<0){
                closecnt++;
                close=0;
            }
        }
        return opencnt+closecnt;
    }
}