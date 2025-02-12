class Solution {
    List<List<Integer>> list;
    public void helper(int arr[], int idx, int t, List<Integer>ls){
        if(t==0){
            list.add(new ArrayList<>(ls));
            return;
        }
        if(idx>=arr.length || t<0){
            return;
        }
        helper(arr,idx+1,t,ls);

        ls.add(arr[idx]);
        helper(arr,idx,t-arr[idx],ls);
        ls.remove(ls.size()-1);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        list = new ArrayList<>();
        helper(candidates,0,target,new ArrayList<>());
        return list;
    }
}