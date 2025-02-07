class Solution {
    public int[] queryResults(int limit, int[][] arr) {
        HashMap<Integer,Integer> m=new HashMap<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans[] = new int[arr.length];
        int k=0;
        for(int i[]:arr)
        {
            int ind=i[0];
            int col=i[1];
            int pre=m.getOrDefault(ind,0);
            m.put(ind,col);
            if(map.containsKey(pre)){
                map.put(pre,map.get(pre)-1);
                if(map.get(pre)<=0) map.remove(pre);
            }
            map.put(col,map.getOrDefault(col,0)+1);
            ans[k++]=map.size();
        }
        return ans;
    }
}