class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;

        for(int i=n-1; i>=0; i--){
            int val = arr[i];
            if(val<0){
                st.push(val);
                continue;
            }
            while(!st.isEmpty() && st.peek()<0 && val>Math.abs(st.peek())){
                st.pop();
            }
            if(!st.isEmpty() && st.peek()<0 && val<Math.abs(st.peek())) continue;
            else if(!st.isEmpty() && st.peek()<0 && Math.abs(st.peek()) == val){
                st.pop();
                continue;
            }

            st.push(val);
        }
        int ans[] = new int[st.size()];
        for(int i=0; i<ans.length; i++){
            ans[i] = st.pop();
        }
        return ans;
    }
}