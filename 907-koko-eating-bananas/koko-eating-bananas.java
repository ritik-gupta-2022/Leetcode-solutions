class Solution {
    public boolean canKoko(int arr[], int h, int s){
        int taken=0;
        for(int i:arr){
            taken+=Math.ceil((double)i/s);
        }
        return taken<=h;
    }

    public int minEatingSpeed(int[] piles, int hr) {
        int l=0,h=0,ans=Integer.MAX_VALUE;
        for(int i:piles) h=Math.max(h,i);

        while(l<=h){
            int mid=l+(h-l)/2;

            if(canKoko(piles,hr,mid)){
                ans=mid;
                h=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
}