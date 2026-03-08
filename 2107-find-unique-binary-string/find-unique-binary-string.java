// https://www.youtube.com/shorts/wEFtpW9Czy8 
// Cantor's diagonal argument
 

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<nums.length; i++){
            char ch =nums[i].charAt(i);
            sb.append((char)(ch ^ 1));
        }   
        return sb.toString();
    }
}