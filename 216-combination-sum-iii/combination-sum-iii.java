class Solution {
    public List<List<Integer>> list = new ArrayList<>();
    public void helper(int s, int k, int ind,List<Integer> ls){
        if(s==0 && k==0){
            list.add(new ArrayList<>(ls));
            return;
        }
        if(s<0 || k<0 || ind>9) return;

        helper(s,k,ind+1,ls);

        ls.add(ind);
        helper(s-ind, k-1, ind+1, ls);
        ls.remove(ls.size()-1);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(n,k,1,new ArrayList<>());
        return list;
    }
}