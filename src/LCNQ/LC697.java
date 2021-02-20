package LCNQ;

import java.util.HashMap;
import java.util.Map;

public class LC697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int len = nums.length;
        for(int i = 0;i < len;i++) {
            if(map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                int[] arr = new int[]{1, i, i};
                map.put(nums[i], arr);
            }
        }
        int maxCnt = 0, minLen = Integer.MAX_VALUE;
        for (int[] value : map.values()) {
            if(value[0] > maxCnt) {
                maxCnt = value[0];
                minLen = value[2] - value[1] + 1;
            } else if(value[0] == maxCnt) {
                minLen = Math.min(minLen, value[2] - value[1] + 1);
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,1,4,2};
        new LC697().findShortestSubArray(arr);
    }
}
