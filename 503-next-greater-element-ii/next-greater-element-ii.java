class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int arr[] = new int[n];
        for(int j=2*n-1; j>=0; j--){
            int i = j%n;
            while(!st.isEmpty() &&st.peek()<=nums[i]){
                st.pop();
            }
            arr[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i]);
        }
        return arr;
    }
}