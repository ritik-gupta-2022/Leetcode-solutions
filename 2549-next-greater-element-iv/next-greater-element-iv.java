class Solution {
    public int[] secondGreaterElement(int[] nums) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        int n=nums.length; 
        int ans[] = new int[n];
        Arrays.fill(ans, -1);

        for(int i=0; i<n; i++){

            while(!st2.isEmpty() && nums[i]>nums[st2.peek()]){
                ans[st2.pop()] = nums[i];

            }
            Stack<Integer> temp = new Stack<>();
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                temp.push(st.pop());
            }

            while(!temp.isEmpty()) st2.push(temp.pop());

            st.push(i);
        }

        return ans;
    }
}