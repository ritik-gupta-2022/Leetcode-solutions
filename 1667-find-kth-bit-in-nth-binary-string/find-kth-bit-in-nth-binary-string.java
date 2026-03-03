class Solution {
    public String reverse(String s)
    {
        StringBuilder sb = new StringBuilder("");
        for(char ch:s.toCharArray())
        {
            if(ch=='0')
                sb.append('1');
            else
                sb.append('0');
        }
        return sb.reverse().toString();
    }
    public String f(int n)
    {
        if(n==1) return "0";
        String ans=f(n-1);
        return ans+"1"+reverse(ans);
    }
    public char findKthBit(int n, int k) {
        return f(n).charAt(k-1);
    }
}