class Solution {
    public double pow(double a, long n){
        if(n==0) return 1;

        double res = pow(a,n/2);

        if(n%2==0) return res*res;
        return  res*res*a;
    }
    public double myPow(double x, int n) {
        if(n < 0) return 1 / pow(x, -1*n);
        return pow(x,n);
    }
}