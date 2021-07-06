package LCNQ;

import java.util.*;

public class LC815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, HashSet<Integer>> s2r = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> r2s = new HashMap<>();
        for(int i = 0;i < routes.length;i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int s : routes[i]) {
                set.add(s);
                s2r.computeIfAbsent(s, integer -> new HashSet<>()).add(i);
            }
            r2s.put(i, set);
        }
        if(!s2r.containsKey(source) || !s2r.containsKey(target)) return -1;
        if(s2r.get(source) == s2r.get(target)) return 0;
        int count = 0;
        Queue<Integer> queue = new LinkedList<>(s2r.get(source));
        HashSet<Integer> seen = new HashSet<>();
        while(!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for(int i = 0;i < size;i++) {
                Integer cur = queue.poll();
                seen.add(cur);
                HashSet<Integer> stations = r2s.get(cur);
                if(stations.contains(target)) return count;
                for (Integer station : stations) {
                    for (Integer r : s2r.get(station)) {
                        if(!seen.contains(r)) queue.add(r);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] routes = new int[][]{{1,2,7},{3,6,7}};
        new LC815().numBusesToDestination(routes, 1, 6);
    }
}
