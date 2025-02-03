class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        
        int m=1;
        for(int i=0; i<nums.length-1; i++)
        {   
            int ans=1;
            for(int j=i+1; j<nums.length; j++)
            {
                if(nums[j]>nums[j-1])
                    ans++;
                else 
                    break;
            }
            m=Math.max(ans,m);
        }
        
        for(int i=0; i<nums.length-1; i++)
        {   
            int ans=1;
            for(int j=i+1; j<nums.length; j++)
            {
                if(nums[j]<nums[j-1])
                    ans++;
                else 
                    break;
            }
            m=Math.max(ans,m);
        }
        return m;
    }
}