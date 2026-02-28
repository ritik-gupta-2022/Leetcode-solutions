class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length<3) return false;
        int n = nums.length;
        int largest = nums[n-1];
        Stack<Integer> st = new Stack<>();
        int n3 = Integer.MIN_VALUE, n2 = Integer.MIN_VALUE;
        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && nums[i]>st.peek()){
                n3 = st.pop();
            }
            if(st.isEmpty()) n2 = nums[i];
            st.push(nums[i]);
            if(nums[i]<n3 && n3<n2) return true;
        }
        return false;
    }
}