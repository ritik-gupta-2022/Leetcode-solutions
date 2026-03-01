// 3   1  2  4
// -1 -1  1  2    index of smaller ele left to curr ele
//  1  4  4  4    index of smaller ele right to curr ele
// now if we look at the an element would contibute to the no of substing from the (i - leftind )*(right - i) and to find sum we will just multiply it with the ele 
class Solution {
    class Pair{
        int val;
        int ind;
        Pair(int val, int ind){
            this.val=val;
            this.ind=ind;
        }
    }
    public void left(int arr[], int ans[])
    {
        Stack<Pair> st = new Stack<>();
        for(int i=0; i<arr.length; i++)
        {
            while(!st.isEmpty() && st.peek().val>arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=-1;
            }
            else{
                ans[i]=st.peek().ind;
            }
            st.push(new Pair(arr[i],i));
        }
        // System.out.print(Arrays.toString(ans));
    }
    public void right(int arr[], int ans[])
    {
        Stack<Pair> st = new Stack<>();
        for(int i=arr.length-1; i>=0; i--)
        {
            while(!st.isEmpty() && st.peek().val>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=arr.length;
            }
            else{
                ans[i]=st.peek().ind;
            }
            st.push(new Pair(arr[i],i));
        }

        // System.out.print(Arrays.toString(ans));
    }
    public int sumSubarrayMins(int[] arr) {
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];
        left(arr,left);
        right(arr,right);
        int mod = (int) 1e9 + 7;
        long ans = 0;
        for(int i=0; i<arr.length; i++){
            ans += (long) (i - left[i]) * (right[i] - i) % mod * arr[i] % mod;
            ans %= mod;
        }
        return (int)ans;
    }
}