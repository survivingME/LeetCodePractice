package newquestion;

import java.util.ArrayList;
import java.util.List;

public class LC989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        int i = A.length - 1, cur = 0;
        while(i >= 0 || K > 0) {
            if(K > 0) {
                cur += K % 10;
                K /= 10;
            }
            if(i >= 0) cur += A[i--];
            res.add(0, cur % 10);
            cur /= 10;
        }
        if(cur != 0) res.add(0, cur);
        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,0,0};
        int K = 34;
        System.out.println(new LC989().addToArrayForm(A, K));
    }
}
