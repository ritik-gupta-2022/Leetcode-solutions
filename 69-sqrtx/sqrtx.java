class Solution {
    public int mySqrt(int x) {
        if(x==1 || x==0) return x;
        int l=1, h=x/2;
        while(l<=h){
            int mid=l+(h-l)/2;
            long probableAns = (long)mid*mid;
            if(probableAns==x) return mid;
            else if(probableAns>x) h=mid-1;
            else l=mid+1;
        }
        return h;
    }
}