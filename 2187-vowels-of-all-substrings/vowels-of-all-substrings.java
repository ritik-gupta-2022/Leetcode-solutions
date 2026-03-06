// Check to how many strings a vowel can contribute
class Solution {
    public long countVowels(String s) {
        long ans=0;
        int n =s.length();
        for(int i=0; i<n; i++){
            if("aeiou".indexOf(s.charAt(i))!=-1){
                ans+=(i+1l)*(n-i); 
                // (i+1l) : means strings starting from 0 to the index and (n-i): means from i to end
            }
        }
        return ans;
    }
}