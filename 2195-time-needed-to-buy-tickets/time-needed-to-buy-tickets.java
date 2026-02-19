class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans=0;
        for(int i=0; i<tickets.length; i++){
            if(i<=k){
                ans+=tickets[i]>=tickets[k]?tickets[k]:tickets[i];
            }
            else{
                ans+=tickets[i]>=tickets[k]?tickets[k]-1:tickets[i];
            }
        }
        return ans;
    }
}