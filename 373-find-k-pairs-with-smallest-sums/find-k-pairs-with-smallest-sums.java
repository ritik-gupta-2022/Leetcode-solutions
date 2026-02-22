class Solution {
    class Pair {
        int a=0;
        int b=0;
        Pair(int a, int b){
            this.a=a;
            this.b=b;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        Set<String> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);

        pq.add(new int[]{nums1[0]+nums2[0],0,0});
         visited.add("0,0");

        while(k-->0 && !pq.isEmpty()){
            int temp[] = pq.poll();

            int i = temp[1];
            int j = temp[2];
            ans.add(Arrays.asList(nums1[i],nums2[j]));

            if (j + 1 < nums2.length && !visited.contains(i + "," + (j + 1))) {
                pq.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                visited.add(i + "," + (j + 1));
            }

            if (i + 1 < nums1.length && !visited.contains((i + 1) + "," + j)) {
                pq.add(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
                visited.add((i + 1) + "," + j);
            }
        }
        return ans;
    }
}