// similar to 2104. Sum of Subarray Ranges but there is an problem of K which enforces a triangle formaula which i get in O(N) but couldn't understand for O(1)

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

    private long count(int L, int R, int k) {

        if (L <= 0 || R <= 0) return 0;

        // If full rectangle valid
        if (L + R - 1 <= k) {
            return (long) L * R;
        }

        int x = Math.min(L, k);
        int y = Math.min(R, k);

        // Number of full rows (flat part)
        int flatRows = Math.max(0, Math.min(x, k - y + 1));

        long flatSum = (long) flatRows * y;

        int remainingRows = x - flatRows;
        if (remainingRows <= 0) return flatSum;

        long first = y - 1;
        long last = y - remainingRows;

        long slopeSum = remainingRows * (first + last) / 2;

        return flatSum + slopeSum;
    }

    public long minMaxSubarraySum(int[] nums, int k) {
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

        for(int i = 0; i < nums.length; i++){

            int Lmax = i - lgreat[i];
            int Rmax = rgreat[i] - i;
            max += count(Lmax, Rmax, k) * nums[i];

            int Lmin = i - lsmall[i];
            int Rmin = rsmall[i] - i;
            min += count(Lmin, Rmin, k) * nums[i];
        }
        return max+min;
    }
}