class Solution {
    public int maxProduct(String[] words) {
        int bitmask[] = new int[words.length];
        for(int i=0; i<words.length; i++){
            for(Character ch: words[i].toCharArray()){
                bitmask[i] = bitmask[i] | (1 << (ch-'a')); //this part will set the corresponding bit=1
            }
        }

        int ans=0;
        for(int i=0; i<words.length; i++){
            int val = bitmask[i];
            for(int j=i+1; j<words.length; j++){
                if((val & bitmask[j]) == 0){
                    ans = Math.max(ans,words[i].length() *  words[j].length());
                }
            }
        }
        return ans;
    }
}