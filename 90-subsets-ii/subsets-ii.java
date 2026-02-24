class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public void helper(int arr[], int ind, List<Integer> ls){
        list.add(new ArrayList<>(ls));
        if(ind==arr.length){
            return;
        }

        for(int i=ind; i<arr.length; i++){
            if(i!=ind && arr[i]==arr[i-1]) continue;

            ls.add(arr[i]);
            helper(arr,i+1,ls);
            ls.remove(ls.size()-1);
        }
        return;
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums,0, new ArrayList<>());
        return list;
    }
}