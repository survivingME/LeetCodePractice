package LCNQ;

import java.util.HashMap;
import java.util.Map;

public class LC1711 {
    int mod = (int)1e9+7;
    int max = 1 << 22;
    public int countPairs(int[] ds) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int x : ds) {
            for (int i = 1; i < max; i <<= 1) {
                int t = i - x;
                if (map.containsKey(t)) {
                    ans += map.get(t);
                    if (ans >= mod) ans -= mod;
                }
            }
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,1,1,3,3,3,7};
        System.out.println(new LC1711().countPairs(num));
    }
}
