class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public void helper(int arr[], int s, int i, List<Integer> ls){
        if(s==0){
            list.add(new ArrayList<>(ls));
            return;
        }
        if(i>=arr.length || s<0) return;

        for(int ind=i; ind<arr.length; ind++){
            if(ind!=i && arr[ind]==arr[ind-1]) continue;

            ls.add(arr[ind]);
            helper(arr,s-arr[ind],ind+1,ls);
            ls.remove(ls.size()-1);
        }
        return;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates,target,0,new ArrayList<>());
        return list;
    }
}