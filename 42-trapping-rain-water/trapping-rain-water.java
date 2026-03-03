class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int lm[]= new int [n];
        int lr[]= new int [n];

        int i=0;
        int k=n-1;
        int l=0; 
        int r=0;
        while(i<n)
        {   
            l=Math.max(l,arr[i]);
            r=Math.max(r,arr[k]);
            lm[i]=l;
            lr[k]=r;
            i++;
            k--;
        }

        int area=0;
        for( i=0; i<n; i++)
        {
            int w=Math.min(lm[i],lr[i]);
            area=area+(w-arr[i]);
        }
        return area;

    }
}