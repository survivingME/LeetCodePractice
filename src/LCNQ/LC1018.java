package LCNQ;

import java.util.ArrayList;
import java.util.List;

public class LC1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int cur = 0;
        for (int i : A) {
            cur = ((cur << 1) + i) % 5;
            if(cur == 0) res.add(true);
            else res.add(false);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[]{0, 1, 1, 1, 1, 1};
        new LC1018().prefixesDivBy5(A);
    }
}
