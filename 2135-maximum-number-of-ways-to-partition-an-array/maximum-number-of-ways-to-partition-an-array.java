class Solution {
    public int waysToPartition(int[] nums, int k) {
        long pre[] =new long[nums.length];
        long suf[] =new long[nums.length];
        int n=nums.length;
        pre[0] = nums[0]; 
        suf[n-1]=nums[n-1];

        for(int i=1; i<n; i++){
            pre[i] = pre[i-1]+nums[i];
            suf[n-i-1] = suf[n-i] + nums[n-i-1];
        }
        
        HashMap<Long,Integer> left = new HashMap<>();
        HashMap<Long,Integer> right = new HashMap<>();

        for(int i = 0; i<n-1; i++){
            long diff = pre[i] - suf[i+1];
            right.put(diff, right.getOrDefault(diff,0) + 1);
        }

        int ans = right.getOrDefault((long)0,0);

        for(int i=0; i<n; i++){
            long eleDiff = k-nums[i];
            
            int curr = right.getOrDefault(-eleDiff,0);
            curr+=left.getOrDefault(eleDiff,0);

            ans=Math.max(ans,curr);

            if(i<n-1){
                long diff = pre[i]-suf[i+1];
                left.put(diff, left.getOrDefault(diff,0)+1);

                right.put(diff, right.get(diff)-1);
                if(right.get(diff)<=0) right.remove(diff);
            }
        }
        return ans;
    }
}