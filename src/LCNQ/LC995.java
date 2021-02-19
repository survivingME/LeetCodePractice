package LCNQ;

public class LC995 {
    public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int[] diff = new int[n + 1];
        int ans = 0, revCnt = 0;
        for(int i = 0;i < n;i++) {
            revCnt ^= diff[i];
            if(A[i] == revCnt) {
                if(i + K > n) return -1;
                ans++;
                revCnt ^= 1;
                diff[i + K] ^= 1;
            }
        }
        return ans;
    }
}
