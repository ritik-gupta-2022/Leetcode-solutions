// just figured out binsary search. Look at the output max(9, 12, 12, 12) here we have to minimize the max so obviously we can think og binary search on answers.
class Solution {
    public int helper(int height, long sec, int val){
        int l=0, h=height;
        int ans=0;
        while(l<=h){
            int mid = l+(h-l)/2;
            long time = (long)mid * (mid + 1) / 2 * val;
            if(time<=sec){
                ans = mid;
                l = mid+1;
            }
            else h = mid-1;
        }
        return ans;
    } 
    public boolean isPossible(long sec, int arr[], int height){
        long cut = 0;
        for(int i = 0; i < arr.length; i++){
            cut += helper(height, sec, arr[i]);
            if(cut >= height) return true;
        }

        return false;
    }
    public long minNumberOfSeconds(int height, int[] arr) {
        int min = Integer.MAX_VALUE;
        for(int i: arr) min = Math.min(min,i);

        long l=0;
        long h = (long)height * (height + 1) / 2 * min;
        long ans=0;
        while(l<=h){
            long mid = l+(h-l)/2;
            if(isPossible(mid,arr,height)){
                ans = mid;
                h = mid-1;
            }
            else l = mid+1;
        }
        return ans;
    }
}