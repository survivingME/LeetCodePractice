package review;

import java.util.LinkedList;
import java.util.List;

public class LC989B {
    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> res = new LinkedList<>();
        int i = A.length - 1, lastNum = K;
        while(i >= 0 || lastNum > 0) {
            if(i >= 0) lastNum += A[i--];
            res.addFirst(lastNum % 10);
            lastNum /= 10;
        }
        return res;
    }
}
