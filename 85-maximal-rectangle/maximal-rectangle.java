class Solution {
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        for(int j=0; j<c; j++){
            int prev = 0;
            for(int i=0; i<r; i++){
                int ele = matrix[i][j] -'0';
                if(ele==0){
                    prev=0;
                    continue;
                }
                matrix[i][j] = (char)(prev + ele + '0');
                prev +=ele;
            }
        }
        int ans = 0;

        for(char arr[]:matrix){
            Stack<Integer> st = new Stack<>();
            for(int i=0; i<arr.length; i++){
                int nse = arr.length;
                while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                    int ele = st.pop();
                    nse = i;
                    int pse = st.isEmpty() ? -1 : st.peek();
                    ans = Math.max(ans, (nse-pse-1)*(arr[ele]-'0'));
                }
                st.push(i);
            }
            while(!st.isEmpty()){
                int ele = st.pop();
                int nse = arr.length;
                int pse = st.isEmpty() ? -1 : st.peek();
                ans = Math.max(ans, (nse-pse-1)*(arr[ele]-'0'));
            }
        }
        return ans;
    }
}