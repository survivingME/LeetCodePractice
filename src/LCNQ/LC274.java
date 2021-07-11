package LCNQ;

public class LC274 {
    /**
     * 能够使用计数排序，因为h指数最高不会大于数组长度len
     * 大于len的引用数放在count[len]中
     * 从高向低遍历，记录引用数sum，与可能的h指数作比较，如果大于等于，满足条件返回
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] count = new int[len + 1];
        for(int i = 0;i < len;i++) {
            if(citations[i] >= len) count[len]++;
            else count[citations[i]]++;
        }
        int sum = 0;
        for(int i = len;i >= 0;i--) {
            sum += count[i];
            if(sum >= i) return i;
        }
        return 0;
    }
}
