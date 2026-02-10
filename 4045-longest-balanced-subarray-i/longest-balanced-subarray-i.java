class Solution {
    public int longestBalanced(int[] nums) {
        int ans=0;
        for(int i=0; i<nums.length; i++){
            HashMap<Integer,Integer> even = new HashMap<>();
            HashMap<Integer,Integer> odd = new HashMap<>();

            for(int j=i; j<nums.length; j++){
                HashMap<Integer, Integer> map = (nums[j]&1)==0 ? odd:even; 
                map.put(nums[j], map.getOrDefault(nums[j],0)+1);

                if(odd.size() == even.size()){
                    ans = Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
}