package LCNQ;

public class LCM1721 {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int lm = 0, rm = 0;
        int ans = 0;
        while(l < r) {
            lm = Math.max(lm, height[l]);
            rm = Math.max(rm, height[r]);
            if(height[l] < height[r]) {
                ans += lm - height[l];
                l++;
            } else {
                ans += rm - height[r];
                r--;
            }
        }
        return ans;
    }
}
