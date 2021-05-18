package LCNQ;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LC1442 {
    public int countTriplets(int[] arr) {
//        int len = arr.length;
//        int[] sum = new int[len + 1];
//        for (int i = 1; i <= len; i++) sum[i] = sum[i - 1] ^ arr[i - 1];
//        int ans = 0;
//        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
//        for(int i = 0;i <= len;i++) {
//            LinkedList<Integer> list = map.getOrDefault(sum[i], new LinkedList<>());
//            for (Integer idx : list) {
//                int idxCur = idx + 1;
//                ans += i - idxCur;
//            }
//            list.add(i);
//            map.put(sum[i], list);
//        }
//        return ans;
        int count = 0;
        int len = arr.length;
        for(int i = 0;i < len;i++) {
            int xorSum = 0;
            for(int j = i;j < len;j++) {
                xorSum ^= arr[j];
                if(xorSum == 0) count += j - i;
            }
        }
        return count;
    }
}
