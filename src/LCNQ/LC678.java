package LCNQ;

import java.util.LinkedList;

public class LC678 {
    public boolean checkValidString(String s) {
        int min = 0, max = 0;
        int len = s.length();
        for(int i = 0;i < len;i++) {
            if(s.charAt(i) == '(') {
                min++;
                max++;
            } else if(s.charAt(i) == ')') {
                min = Math.max(min - 1, 0);
                max--;
                if(max < 0) return false;
            } else {
                min = Math.max(min - 1, 0);
                max++;
            }
        }
        return min == 0;
    }

    public boolean checkValidString1(String s) {
        LinkedList<Integer> leftStack = new LinkedList<>();
        LinkedList<Integer> starStack = new LinkedList<>();
        int len = s.length();
        for(int i = 0;i < len;i++) {
            char c = s.charAt(i);
            if(c == '(') leftStack.push(i);
            else if(c == '*') starStack.push(i);
            else {
                if(!leftStack.isEmpty()) leftStack.poll();
                else if(!starStack.isEmpty()) starStack.poll();
                else return false;
            }
        }
        while(!leftStack.isEmpty() && !starStack.isEmpty()) {
            if(starStack.poll() < leftStack.poll()) return false;
        }
        return leftStack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(*))";
    }
}
