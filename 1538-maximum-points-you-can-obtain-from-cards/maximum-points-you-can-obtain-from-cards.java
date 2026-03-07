class Solution {
    public int maxScore(int[] arr, int k) {
        int l=0, r=arr.length-1;
        int n=arr.length;
        int s = 0;
        for(; l<k; l++) s+= arr[l];
        l--;

        int ans = s;
        for(int i=0; i<k; i++){
            s=s-arr[l]+arr[r];
            ans = Math.max(s,ans);
            l--; r--;
            l = (l+n)%n;
            r = (r+n)%n;
        }
        return ans;
    }
}