class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i:nums){
            pq.offer((long)i);
        }
        int ans=0;
        while(pq.size()>=2 && pq.peek()<k){
            long x = pq.poll();
            long y = pq.poll();
            long in = Math.min(x,y)*2 + Math.max(x,y);
            pq.offer(in);
            ans++;
        }
        return ans;
    }
}