package LCNQ;

import java.util.PriorityQueue;

public class LC451 {
    public String frequencySort(String s) {
        char[] charArray = s.toCharArray();
        int[][] map = new int[128][2];
        for(int i = 0;i < 128;i++) map[i][0] = i;
        for (char c : charArray) map[c][1]++;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int[] ints : map) if(ints[1] != 0) queue.add(ints);
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            for(int i = 0;i < poll[1];i++) sb.append((char)poll[0]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "Aabb";
        String res = new LC451().frequencySort(str);
        System.out.println(res);
    }
}
