class Solution {
    long fuel;
    public long helper(List<List<Integer>> adj , int node, int prev, int seats){
        int people=1;
        for(int i:adj.get(node)){
            if(i == prev) continue;
            people+=helper(adj,i,node,seats);
        }
        if(node!=0)
            fuel+=Math.ceil(people/(double)seats);
        return people;
    }
    public long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> adj = new ArrayList<>();
        fuel=0;
        for (int i = 0; i <=roads.length; i++) adj.add(new ArrayList());
        for (int[] r: roads) {
            adj.get(r[0]).add(r[1]);
            adj.get(r[1]).add(r[0]);
        }

        helper(adj,0,0,seats);
        return fuel;
    }
}