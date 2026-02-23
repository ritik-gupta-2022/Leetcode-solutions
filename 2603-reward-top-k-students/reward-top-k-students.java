class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] st, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String s: positive_feedback){
            map.put(s,3);
        }
        for(String s: negative_feedback){
            map.put(s,-1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0] );

        for(int i=0; i<st.length; i++){
            int id = st[i];
            String result[] = report[i].split("\\s+");
            int ans=0;
            for(String s: result){
                ans+=map.getOrDefault(s,0);
            }
            pq.add(new int[]{ans,id});
            if(pq.size()>k) pq.poll();
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll()[1]);
        }
        Collections.reverse(res);
        return res;
    }
}