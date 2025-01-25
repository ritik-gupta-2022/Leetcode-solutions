class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int arr[] = nums.clone();
        Arrays.sort(arr);
        Map<Integer,Integer> numToGroup = new HashMap<>();
        Map<Integer,ArrayList<Integer>> grpList = new HashMap<>();
        int currGrp=0;
        numToGroup.put(arr[0],currGrp);
        grpList.put(currGrp,new ArrayList<>(Arrays.asList(arr[0])));
        for(int i=1; i<arr.length; i++){
            if(Math.abs(arr[i]-arr[i-1])>limit)
                currGrp++;
            numToGroup.put(arr[i], currGrp);

            if (!grpList.containsKey(currGrp)) {
                grpList.put(currGrp, new ArrayList<Integer>());
            }
            grpList.get(currGrp).add(arr[i]);
        }
        for(int i = 0; i < nums.length; i++) {
            int num=nums[i];
            int g=numToGroup.get(num);
            nums[i] = grpList.get(g).remove(0);
        }
        return nums;
    }
}