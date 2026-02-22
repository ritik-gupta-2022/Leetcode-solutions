class Solution {
    public int waysToMakeFair(int[] nums) {
        int odd=0, eve=0;
        for(int i=0; i<nums.length; i++){
            odd+=i%2!=0?nums[i]:0;
            eve+=i%2==0?nums[i]:0;
        }
        int backeve=0, backodd=0, ans=0;
        for(int i=0; i<nums.length; i++){
            if(i%2==0) eve-=nums[i];
            else odd-=nums[i];

            if(backeve+odd==backodd+eve) ans++;

            if(i%2==0) backeve+=nums[i];
            else backodd+=nums[i];
        }
        return ans;
    }
}