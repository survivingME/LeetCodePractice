package LCNQ;

import java.util.HashMap;
import java.util.Map;

public class LC1711 {
    int mod = (int)1e9+7;
    int max = 1 << 22;
    public int countPairs(int[] ds) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int d : ds) map.put(d, map.getOrDefault(d, 0) + 1);
        long ans = 0;
        for (int x : map.keySet()) {
            for (int i = 1; i < max; i <<= 1) {
                int t = i - x;
                if (map.containsKey(t)) {
                    if (t == x) ans += (map.get(x) - 1) * 1L * map.get(x);
                    else ans += map.get(x) * 1L * map.get(t);
                }
            }
        }
        ans >>= 1;
        return (int)(ans % mod);
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,1,1,3,3,3,7};
        System.out.println(new LC1711().countPairs(num));
    }
}
