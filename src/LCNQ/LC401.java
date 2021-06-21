package LCNQ;

import java.util.LinkedList;
import java.util.List;

public class LC401 {
    //回溯搜索
    List<String> res = new LinkedList<>();
    int[] h = new int[]{1, 2, 4, 8, 0, 0, 0, 0, 0, 0};
    int[] m = new int[]{0, 0, 0, 0, 1, 2, 4, 8, 16, 32};
    public List<String> readBinaryWatch(int turnedOn) {
        bt(turnedOn, 0, 0, 0);
        return res;
    }

    public void bt(int curOn, int idx, int hour, int min) {
        if(curOn == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(hour).append(':');
            if(min < 10) sb.append('0');
            sb.append(min);
            res.add(sb.toString());
            return;
        }
        for(int i = idx;i < 10;i++) {
            if(hour + h[i] > 11 || min + m[i] > 59) continue;
            bt(curOn - 1, i + 1, hour + h[i], min + m[i]);
        }
    }


    public static void main(String[] args) {
        List<String> list = new LC401().readBinaryWatch(2);
        System.out.println(list);
    }
}
