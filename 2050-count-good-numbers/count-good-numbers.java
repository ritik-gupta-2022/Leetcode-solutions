class Solution {
    int mod=1000000007;
    public long pow(long x,long n){
    if(n==0) return 1;

    if(n%2==0)
        return pow ( (x*x) %mod , n/2) %mod;
    
    return ( x%mod * pow (x,n-1)) %mod;
    }

    public int countGoodNumbers(long n) {
        
        long eve=   (int)(pow(5,(n+1)/2)%mod);

        long prime= (int)(pow(4,n/2)%mod);

        return (int)((eve%mod * prime%mod) %mod);
    }
}