package LCNQ;

import java.util.LinkedList;

public class LC32 {
    public int longestValidParentheses(String s) {
        int len = s.length(), ans = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for(int i = 0;i < len;i++) {
            if(s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if(stack.isEmpty()) stack.push(i);
                else ans = Math.max(ans, i - stack.peek());
            }
        }
        return ans;
    }
}
