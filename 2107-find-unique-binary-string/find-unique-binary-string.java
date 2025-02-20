class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Arrays.sort(nums);
        int i=0;
        int t=nums[i].length();
        for(i=0; i<nums.length; i++)
        {    
            if(!(Integer.parseInt(nums[i],2)==i))
            break;
        }
        return str(i,t);
    }
    
    public String str(int num,int n)
    {   
        String s = Integer.toBinaryString(num);
        int l=n-s.length();
        String str="";
        while(l-->0)        
            str+="0";
            
        return str+s;
    }
}