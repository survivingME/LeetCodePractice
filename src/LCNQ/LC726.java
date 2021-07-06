package LCNQ;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class LC726 {
    int i = 0;
    public String countOfAtoms(String formula) {
        char[] charArray = formula.toCharArray();
        StringBuilder sb = new StringBuilder();
        TreeMap<String, Integer> map = new TreeMap<>((o1, o2) -> {
            char[] charArray1 = o1.toCharArray();
            char[] charArray2 = o2.toCharArray();
            int i1 = 0, i2 = 0;
            while(i1 < charArray1.length && i2 < charArray2.length) {
                if(charArray1[i1] == charArray2[i2]) {
                    i1++;
                    i2++;
                } else {
                    return charArray1[i1] - charArray2[i2];
                }
            }
            return i1 < charArray1.length ? 1 : -1;
        });
        while(i < charArray.length) {

        }
        return "";
    }

    class scount {
        String symbol;
        int count;
    }
}
