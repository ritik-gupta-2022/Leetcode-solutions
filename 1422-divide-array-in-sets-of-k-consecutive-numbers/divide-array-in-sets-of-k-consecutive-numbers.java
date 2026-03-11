class Solution {
    public boolean isPossibleDivide(int[] arr, int k) {
        if(arr.length%k != 0) return false;
        int t = arr.length/k;

        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i:arr) map.put(i,map.getOrDefault(i,0)+1);

        while(t-->0){
            int start = map.firstKey();

            for(int i=0;i<k;i++){
                int card = start + i;

                if(!map.containsKey(card)) return false;

                map.put(card, map.get(card) - 1);

                if(map.get(card) == 0)
                    map.remove(card);
            }
        }
        return true;
    }
}