package LCNQ;

public class LC896 {
    public boolean isMonotonic(int[] A) {
        if(A.length == 1) return true;
        int len = A.length;
        int idx = 1;
        while(idx < len && A[idx] == A[idx - 1]) idx++;
        if(idx >= len) return true;
        boolean c = A[idx] > A[idx - 1];
        idx++;
        while(idx < len) {
            if(A[idx] == A[idx - 1]) idx++;
            else if(A[idx] > A[idx - 1] ^ c) return false;
            else idx++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6,5,4,4};
        new LC896().isMonotonic(arr);
    }
}
