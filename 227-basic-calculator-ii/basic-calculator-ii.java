class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int num=0;
        char op='+';

        for(char ch: s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                num=num*10+(ch-'0');
            }
            else if(ch!=' '){
                if(op=='+'){
                    st.push(num);
                }
                else if(op=='-'){
                    st.push(-num);
                }
                else if(op=='*'){
                    st.push(num*st.pop());
                }
                else if(op=='/'){
                    st.push(st.pop()/num);
                }
                op=ch;
                num=0;
            }
        }
        if(op=='+'){
            st.push(num);
        }
        else if(op=='-'){
            st.push(-num);
        }
        else if(op=='*'){
            st.push(num*st.pop());
        }
        else if(op=='/'){
            st.push(st.pop()/num);
        }
        int ans=0;
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        return ans;
    }
}