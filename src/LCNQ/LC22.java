package LCNQ;

import java.util.LinkedList;
import java.util.List;

public class LC22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        bt(res, "", n, 0, 0);
        return res;
    }

    public void bt(List<String> res, String cur, int n, int l, int r) {
        if(cur.length() == 2 * n) {
            res.add(cur);
            return ;
        }
        if(l < n) bt(res, cur + "(", n, l + 1, r);
        if(r < l) bt(res, cur + ")", n, l, r + 1);
    }

}
