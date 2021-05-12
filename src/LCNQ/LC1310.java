package LCNQ;

public class LC1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] xor = new int[n + 1];
        for(int i = 0;i < n;i++) xor[i + 1] = xor[i] ^ arr[i];
        int[] res = new int[queries.length];
        for(int i = 0;i < queries.length;i++) res[i] = xor[queries[i][0]] ^ xor[queries[i][1] + 1];
        return res;

        /**
         * xor[0] = 0
         * xor[i] = xor[i - 1] ^ arr[i - 1]
         * Res(L, R)
         * L = 0; Res(L, R) = arr[0] ^ ... ^ arr[R] = xor[R + 1]
         * L != 0; Res(L, R)    = arr[L] ^ ... ^ arr[R]
         *                      = (arr[0] ^...^ arr[L-1]) ^ (arr[0] ^...^ arr[L-1]) ^ (arr[L] ^...^ arr[R])
         *                      = xor[L] ^ xor[R + 1]
         */
    }
}
