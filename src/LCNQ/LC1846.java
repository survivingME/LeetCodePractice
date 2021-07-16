package LCNQ;

import java.util.Arrays;

public class LC1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);
        if(arr[0] != 1) arr[0] = 1;
        for(int i = 1;i < len;i++) {
            if(arr[i] - arr[i - 1] > 1) arr[i] = arr[i - 1] + 1;
        }
        return arr[len - 1];
    }
}
