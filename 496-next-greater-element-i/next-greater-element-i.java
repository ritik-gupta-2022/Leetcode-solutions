class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int arr[] = new int[nums2.length];
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int n=nums2.length;
        for(int i=0; i<n; i++){
            map.put(nums2[i],i);
        }
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() &&st.peek()<=nums2[i]){
                st.pop();
            }
            arr[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums2[i]);
        }
        for(int i=0; i<nums1.length; i++)
        {
            int ind=map.get(nums1[i]);
            nums1[i]=arr[ind];
        }
        return nums1;
    }
}