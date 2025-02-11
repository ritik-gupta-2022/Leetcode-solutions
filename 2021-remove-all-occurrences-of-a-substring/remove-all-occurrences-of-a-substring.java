class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> st = new Stack<>();
        int n = part.length();
        char last = part.charAt(n-1);
        for(int i=0; i<s.length(); i++){
            st.push(s.charAt(i));

            if(last==st.peek()){
                Stack<Character> temp = new Stack<>();
                int k=n-1;
                while(k>=0 && !st.isEmpty() && st.peek()==part.charAt(k)){
                    temp.push(st.pop());
                    k--;
                }
                if(k>=0){
                    while(!temp.isEmpty()){
                        st.push(temp.pop());
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0,st.pop());
        }
        return sb.toString();
    }
}