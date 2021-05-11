package LCNQ;

public class LC1734 {
    public int[] decode(int[] encoded) {
        int len = encoded.length + 1;
        int total = 0;
        for(int i = 1;i <= len;i++) total ^= i;
        int odd = 0;
        for(int i = 1;i < len - 1;i += 2) odd ^= encoded[i];
        int[] perm = new int[len];
        perm[0] = total ^ odd;
        for(int i = 1;i < len;i++) perm[i] = encoded[i - 1] ^ perm[i - 1];
        return perm;
    }
}
