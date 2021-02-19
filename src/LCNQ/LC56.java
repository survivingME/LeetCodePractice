package LCNQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][2];
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            int l = interval[0], r = interval[1];
            if (res.size() == 0 || res.get(res.size() - 1)[1] < l) {
                res.add(new int[]{l, r});
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], r);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
