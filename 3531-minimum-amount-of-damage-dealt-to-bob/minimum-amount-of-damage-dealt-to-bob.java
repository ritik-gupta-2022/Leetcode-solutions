class Solution {
    public long minDamage(int power, int[] damage, int[] health) {
        Integer arr[] = new Integer[damage.length];
        int t[] = new int[damage.length];
        for(int i=0; i<damage.length; i++){
            t[i] = (health[i]+power-1)/power;
        }
        Arrays.setAll(arr, i -> i);
        Arrays.sort(arr, (i,j) -> t[i] * damage[j]- t[j] * damage[i]);
        long res = 0, curTime = 0;
        for (int i : arr) {
            curTime += t[i];
            res += curTime * damage[i];
        }
        return res;
    }
}