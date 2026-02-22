class Solution {
    public boolean canBeValid(String s, String l) {
        if(s.length()%2!=0) return false;
        Stack<Integer> open = new Stack<>();
        Stack<Integer> openClose = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(l.charAt(i)=='0') openClose.push(i);
            else if(ch==')'){
                if(!open.isEmpty()) open.pop();
                else if(openClose.isEmpty()) return false;
                else openClose.pop();
            }
            else{
                open.push(i);
            }
        }
        while(!open.isEmpty() && !openClose.isEmpty()){
            if(open.peek()<openClose.peek()){
                open.pop();
                openClose.pop();
            }
            else return false;
        }
        if(openClose.size()%2==0 && open.isEmpty()) return true;
        return false;
    }
}