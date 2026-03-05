class Solution {
    public int replace(int arr[])
    {
        int max=0, count=0;
        for(int i:arr)
        {
            count+=i;
            max=Math.max(max,i);
        }
        return count-max;
    }
    public int characterReplacement(String s, int k) {
        int arr[] = new int[26];
        int l=0, r=0,ans=0;
        while(r<s.length())
        {
            arr[s.charAt(r)-'A']++;
            int val=replace(arr);
            if(val>k)
            {
                arr[s.charAt(l)-'A']--;
                l++;
                // val = replace(arr);
            }
            if(replace(arr)<=k)
            ans=Math.max(r-l+1, ans);
            r++;
        }
        return ans;
    }
}