class Solution {
    public int count(int arr[], int k){
        if(k<0) return 0; 
        int n = arr.length;
        int l=0, r=0, ans=0, s=0;

        while(r<n){
            s+=arr[r];
            
            while(s>k){
                s-=arr[l++];
            }

            ans+=r-l+1;
            r++;
        }
        return ans;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
       return count(nums,goal) - count(nums,goal-1); 
    }
}