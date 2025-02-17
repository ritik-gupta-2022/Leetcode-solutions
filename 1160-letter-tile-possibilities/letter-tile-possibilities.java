class Solution {
    HashSet<String> set;
    public void helper(String s, String ans, boolean used[]){
        
        set.add(ans);
            
        for(int i=0; i<s.length(); i++){
            if(used[i]) continue;

            used[i]=true;
            helper(s,ans+s.charAt(i),used);
            used[i]=false;
        }
    }
    public int numTilePossibilities(String tiles) {
        set = new HashSet<>();
        boolean used[] = new boolean[tiles.length()];
        helper(tiles,"",used);
        return set.size()-1;
    }
}