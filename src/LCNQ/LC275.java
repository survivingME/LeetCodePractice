package LCNQ;

public class LC275 {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int l = 0, r = len - 1;
        while(l < r) {
            int mid = (l + r) >> 1;
            if(citations[mid] >= len - mid) r = mid;
            else l = mid + 1;
        }
        return citations[r] >= len - r ? len - r : 0;
    }
}
