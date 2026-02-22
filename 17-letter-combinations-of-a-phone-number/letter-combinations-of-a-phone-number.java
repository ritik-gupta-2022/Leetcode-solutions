class Solution {
    public static String[]arr = {"", "","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public void helper(int i, String s, String sb, List<String> ls){
        if(i==s.length()){
            ls.add(sb);
            return;
        }

        char ch = s.charAt(i);
        String st= arr[ch-'0'];
        for(int j=0; j<st.length(); j++){
            helper(i+1, s, sb+st.charAt(j), ls);
        }
        return;
    }
    public List<String> letterCombinations(String digits) {
        List<String> ls = new ArrayList<>();
        helper(0,digits,"", ls);
        return ls;
    }
}