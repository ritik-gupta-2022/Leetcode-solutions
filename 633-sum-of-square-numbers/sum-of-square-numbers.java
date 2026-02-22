class Solution {
    public boolean judgeSquareSum(int c) {
        if(c==0) return true;
        long a=0 , b=(long)Math.sqrt(c);
        while(b>=a){
            long res=a*a+b*b;
            if(res==c) return true;
            if(res>c) b--;
            else a++;
        }
        return false;
    }
}