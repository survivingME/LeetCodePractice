package LCNQ;

public class LC832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int n = A[0].length;
        for (int[] row : A) {
            for(int i = 0;i < (n + 1)/2;i++) {
                int tmp = row[i] ^ 1;
                row[i] = row[n - i - 1] ^ 1;
                row[n - i - 1] = tmp;
            }
        }
        return A;
    }
}
