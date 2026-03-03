class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();
        int i=0;
        for (; i < num.length(); i++) {
            int ch = num.charAt(i)-'0';

            while (!st.isEmpty() && k > 0 && st.peek() > ch) {
                st.pop();
                k--;
            }

            st.push(ch);
        }

        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        StringBuilder sb =new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        
        // System.out.print(sb.toString());
        String str= sb.toString();
        int j=0;
        for(; j<str.length(); j++)
        {
            if(str.charAt(j)!='0')
                 break;
        }
        // System.out.print(str+" "+j);
        if(str.substring(j).length()==0) return "0";
        return str.substring(j);
    }
}