class Solution {
    public int largestRectangleArea(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];
        
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) st.pop();

            left[i] = st.isEmpty()? -1 : st.peek();
            st.push(i);
        }
        Stack<Integer> st2 = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!st2.isEmpty() && arr[st2.peek()]>=arr[i]) st2.pop();

            right[i] = st2.isEmpty()? n : st2.peek();
            st2.push(i);
        }
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));

        int ans = 0;
        for(int i=0; i<n; i++){
            int v = (right[i]-left[i]-1)*arr[i];
            ans = Math.max(v,ans);
        }
        return ans;
    }
}