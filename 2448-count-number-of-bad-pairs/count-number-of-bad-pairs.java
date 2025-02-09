class Solution {
    public long countBadPairs(int[] nums) { 
        long ans=0, n=nums.length-1;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<=n;i++)
            nums[i]=nums[i]-i;

        for(int i=0;i<=n;i++){
           if(mp.containsKey(nums[i]))
             ans=ans+(mp.get(nums[i]));
           
           mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        // System.out.print(mp.toString());
        n=(n*(n+1))/2;
        n=n-ans;
        return n;
    }
}