class Solution {
    List<List<String>> list = new ArrayList<>();
    public void helper(String s, List<String> ls){
        if(s.length()==0){
            list.add(new ArrayList<>(ls));
            return;
        }
        for(int i=1; i<=s.length(); i++){
            String partition = s.substring(0,i);

            if(isPal(partition)){
                ls.add(partition);
                helper(s.substring(i), ls);
                ls.remove(ls.size()-1);
            }
        }
        return;
    }

    public boolean isPal(String s){
        int n=s.length();
        for(int i=0; i<n/2; i++){
            if(s.charAt(i)!=s.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        helper(s,new ArrayList<>());
        return list;
    }
}