class Solution {
    public int bestClosingTime(String s) {
        int c=0;
        for(int i=1; i<s.length(); i++)
        {
            if(s.charAt(i)=='Y')  
                c++;
        }
        int min=c, ind=0;;
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)=='Y') c--;
            else c++;

            if(c<min){
                min=c;
                ind=i+1;
            }
        }
        return ind;
    }
}