class Solution {
    public String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public String add(String a, String b){

        int i = 0, carry = 0;
        StringBuilder sb = new StringBuilder();

        while(i < a.length() || i < b.length() || carry > 0){

            int x = (i < a.length()) ? a.charAt(i) - '0' : 0;
            int y = (i < b.length()) ? b.charAt(i) - '0' : 0;

            int sum = x + y + carry;

            sb.append((char)(sum % 10 + '0'));

            carry = sum / 10;

            i++;
        }

        return sb.toString();
    }

    public String single(String s, char c, String ans){
        int carry=0;
        int n = c-'0';
        StringBuilder sb = new StringBuilder(ans);
        for(int i=0; i<s.length(); i++){
            int temp = n * (s.charAt(i) - '0');
            temp+=carry;
            sb.append((char)(temp%10 + '0'));
            carry = temp/10;
        }
        if(carry>0) sb.append((char)(carry+'0'));
        return sb.toString();
    }
    public String multiply(String num1, String num2) {
        List<String> ls = new ArrayList<>();
        // System.out.println(single("452",'4',""));
        String a = num1.length() < num2.length() ? num1 : num2;
        String b = num1.length() < num2.length() ? num2 : num1;

        a = reverse(a);
        b = reverse(b);
        
        for(int i=0; i<a.length(); i++){
            String temp = "";
            int k=i;
            while(k-->0) temp+="0";
            ls.add(single(b, a.charAt(i), temp));
        }
        System.out.println(ls.toString());

        String ans = "0";

        for(String s : ls){
            ans = add(ans, s);
        }

        ans = reverse(ans);

        int i = 0;
        while(i < ans.length()-1 && ans.charAt(i) == '0') i++;

        return ans.substring(i);

    }
}