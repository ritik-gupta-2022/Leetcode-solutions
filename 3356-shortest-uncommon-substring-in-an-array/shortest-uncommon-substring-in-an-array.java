import java.util.*;

class Solution {
    public String[] shortestSubstrings(String[] arr) {
        Map<String, Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            String s=arr[i];
            HashSet<String> hs=new HashSet<>();
            for(int j=0;j<arr[i].length();j++){
                for(int k=j+1;k<=arr[i].length();k++)
                    hs.add(s.substring(j,k));
            }
            for (String e : hs) {
                map.put(e,map.getOrDefault(e,0)+1);
            }
        }

        String[] ans = new String[arr.length];
        int k = 0;

        // Find unique substrings for each string
        for (String s : arr) {
            List<String> al = new ArrayList<>();
            int n = s.length();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = i; j < n; j++) {
                    sb.append(s.charAt(j));
                    String sub = sb.toString();
                    if (map.get(sub) == 1) {
                        al.add(sub);
                    }
                }
            }

            if (al.isEmpty()) {
                ans[k] = "";
            } else {
                // Sort by length first, then lexicographically
                Collections.sort(al, (a, b) -> {
                    if (a.length() != b.length()) return a.length() - b.length();
                    return a.compareTo(b);
                });
                ans[k] = al.get(0);
            }
            k++;
        }

        return ans;
    }
}
