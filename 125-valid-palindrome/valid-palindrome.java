class Solution {
    public boolean helper(String s, int i, int j){

        while(i<s.length() && ((s.charAt(i)<97 || s.charAt(i)>122) && (s.charAt(i)<48 || s.charAt(i)>57) )) i++;
        while(j>=0 && ((s.charAt(j)<97 || s.charAt(j)>122) && (s.charAt(j)<48 || s.charAt(j)>57) )) j--;

        if(j<=i) return true;

        if(s.charAt(i)==s.charAt(j)) return helper(s,i+1,j-1);
        return false;
    }
    public boolean isPalindrome(String s) {
        return helper(s.toLowerCase(),0,s.length()-1);
    }
}