class Solution {
    public int minOperations(String s) {
        int n=s.length();
        int one=0;
        int zero=0;
        for(int i=0; i<n; i++)
        {
            if(i%2==0)
            {
                if(s.charAt(i)=='0')
                    one++;
                else
                    zero++;
            }
            else{
                if(s.charAt(i)=='0')
                    zero++;
                else
                    one++;
            }
        }
        return Math.min(zero,one);
    }
}