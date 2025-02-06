class Solution {
    public int per(int n){
        return n*(n-1);
    }
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                int pro = nums[i]*nums[j];
                map.put(pro,map.getOrDefault(pro,0)+1);
            }
        }
        int ans=0;
        for(int i:map.values()){
            if(i==1) continue;
            ans+= per(i)*4;
        }
        return ans;
    }
}