package LCNQ;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LC1104 {
    public List<Integer> pathInZigZagTree(int label) {
        int row = 1, rowStart = 1;
        while(rowStart * 2 <= label) {
            row++;
            rowStart *= 2;
        }
        if(row % 2 == 0) label = getReverse(label, row);
        List<Integer> res = new LinkedList<>();
        while(row > 0) {
            if(row % 2 == 0) res.add(getReverse(label, row));
            else res.add(label);
            row--;
            label >>= 1;
        }
        Collections.reverse(res);
        return res;
    }

    public int getReverse(int label, int row) {
        return (1 << row - 1) + (1 << row) - 1 - label;
    }
}
