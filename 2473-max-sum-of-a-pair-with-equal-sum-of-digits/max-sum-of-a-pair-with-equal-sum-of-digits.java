class Solution {
    public int maximumSum(int[] nums) {
        int ans=-1;
        Map<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        for(int i=0 ; i<nums.length; i++){
            int n=nums[i], sum=0;
            while(n>0){
                sum+=n%10;
                n=n/10;
            }
            // System.out.println(sum);
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            if(map.containsKey(sum)){
                pq = map.get(sum);
                // System.out.println(pq.toString()+sum+" "+" "+nums[i]);
                ans= Math.max(ans,pq.peek()+nums[i]);
            }
            pq.offer(nums[i]);
            map.put(sum,pq);
        }
        return ans;
    }
}