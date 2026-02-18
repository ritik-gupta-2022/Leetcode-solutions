class Solution {
    public double helper(double x, int n){
        if(n==0) return 1;
        double ans=helper(x,n/2);
        if((n&1)==0) return ans*ans;
        else return x*ans*ans;
    }
    public double myPow(double x, int n) {
        double ans = helper(x,Math.abs(n));
        if(n<0) return 1/ans;
        else return ans;
    }
}