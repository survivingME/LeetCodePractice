package LCNQ;

public class LC528 {
    int total;
    int[] pre;
    public LC528(int[] w) {
        pre = new int[w.length];
        pre[0] = w[0];
        for(int i = 1;i < w.length;i++) pre[i] = pre[i - 1] + w[i];
        total = pre[pre.length - 1];
    }

    public int pickIndex() {
        int x = (int) (Math.random() * total) + 1;
        return binarySearch(x);
    }

    public int binarySearch(int x) {
        int l = 0, r = pre.length - 1;
        while(l < r) {
            int mid = (l + r) / 2;
            if(pre[mid] < x) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
