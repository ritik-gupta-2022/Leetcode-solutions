import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];
        for(char c : tasks)
            freq[c - 'A']++;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int f : freq)
            if(f > 0) pq.add(f);

        int time = 0;

        while(!pq.isEmpty()) {

            int cycle = n + 1;
            List<Integer> temp = new ArrayList<>();

            while(cycle > 0 && !pq.isEmpty()) {
                int curr = pq.poll();
                curr--;

                if(curr > 0)
                    temp.add(curr);

                cycle--;
                time++;
            }

            for(int t : temp)
                pq.add(t);

            if(pq.isEmpty())
                break;

            time += cycle; // idle time
        }

        return time;
    }
}