class Solution {
    public int largestRectangleArea(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for(int i=0; i<arr.length; i++){
            int nse = arr.length;
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                int ele = st.pop();
                nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                ans = Math.max(ans, (nse-pse-1)*arr[ele]);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int ele = st.pop();
            int nse = arr.length;
            int pse = st.isEmpty() ? -1 : st.peek();
            ans = Math.max(ans, (nse-pse-1)*arr[ele]);
        }
        return ans;
    }
}