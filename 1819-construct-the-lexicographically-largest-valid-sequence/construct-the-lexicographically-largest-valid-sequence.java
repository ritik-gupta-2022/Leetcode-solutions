class Solution {
    HashSet<Integer> set;
    public boolean helper(int arr[], int n, int idx){
        if(idx==arr.length){
            return true;
        }
        if(arr[idx]!=0){
            return helper(arr,n,idx+1);
        }
        for(int i=n; i>=1; i--){
            if(set.contains(i)) continue;
            set.add(i);
            arr[idx] = i;
            if(i==1){
                if(helper(arr,n,idx+1)) return true;
            }
            else{
                int j = idx + i;
                if(j<arr.length && arr[j]==0){
                    arr[j] = i;
                    if(helper(arr,n,idx+1)) return true;
                    arr[j] = 0;
                }
            }
            arr[idx] = 0;
            set.remove(i);
        }
        return false;
    }
    public int[] constructDistancedSequence(int n) {
        set = new HashSet<>();
        int ans[] = new int[2*n-1];
        helper(ans,n,0);
        return ans;
    }
}