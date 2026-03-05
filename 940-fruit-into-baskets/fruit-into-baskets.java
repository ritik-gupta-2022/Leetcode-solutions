class Solution {
    public int totalFruit(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        int l=0, r=0;
        int ans=0;

        while(r<n && l<=r){
            int curr = arr[r];

            map.put(curr,map.getOrDefault(curr,0)+1);

            while(map.size()>2){
                int temp = arr[l];
                map.put(temp, map.getOrDefault(temp,0)-1);
                if(map.get(temp)<=0) map.remove(temp);
                l++;
            }

            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}