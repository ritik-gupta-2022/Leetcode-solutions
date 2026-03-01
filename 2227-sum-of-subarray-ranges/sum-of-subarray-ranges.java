// https://www.youtube.com/watch?v=v0e8p9JCgRc
class Solution {
    public void leftSmaller(int left[], int arr[]){
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            left[i] = st.isEmpty() ? -1:st.peek();
            st.push(i);
        }
        return;
    }
    public void rightSmaller(int right[], int arr[]){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
    }
    public void leftGreater(int left[], int arr[]){
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return;
    }

    public void rightGreater(int right[], int arr[]){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
    }

    public long subArrayRanges(int[] nums) {
        int lsmall[] = new int[nums.length];
        int rsmall[] = new int[nums.length];
        int lgreat[] = new int[nums.length];
        int rgreat[] = new int[nums.length];

        leftSmaller(lsmall, nums);
        rightSmaller(rsmall, nums);
        leftGreater(lgreat, nums);
        rightGreater(rgreat, nums);

        long min = 0;
        long max = 0;
        long ans = 0;

        for(int i=0; i<nums.length; i++){
            ans+= (long)((long)((i - lgreat[i]) * (rgreat[i] - i)) - (long)((i - lsmall[i]) * (rsmall[i] - i))) * nums[i];
            // max+= (i - lgreat[i]) * (rgreat[i] - i) * nums[i];
        }
        return ans;
    }
}