class Solution {
    public int helper(int arr[], int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        int l=0, r=0, ans=0;

        while(r<n && l<=r){
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);

            while(map.size()>k){
                map.put(arr[l], map.get(arr[l])-1);
                if(map.get(arr[l])<=0) map.remove(arr[l]);
                l++;
            }

            ans+=r-l+1;
            r++;
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k) - helper(nums,k-1);
    }
}