class Solution {
    public boolean checkOnesSegment(String s) {
        int c=0;
        int i=0;
        for(; i<s.length(); ){
            while(i<s.length() && s.charAt(i)=='1'){
                c=1;
                i++;
            }
            if(i<s.length() && s.charAt(i)=='0') break;
        }
        for(; i<s.length(); ){
            if(i<s.length() && s.charAt(i)=='1'){
                return false;
            }
            else i++;
        }
        return true;
    }
}