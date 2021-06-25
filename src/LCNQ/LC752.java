package LCNQ;

import java.util.*;

public class LC752 {
    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> seen = new HashSet<>();
        if(set.contains("0000") || set.contains(target)) return -1;
        HashSet<String> q1 = new HashSet<>();
        HashSet<String> q2 = new HashSet<>();
        q1.add("0000");
        q2.add(target);
        int step = 0;
        while(!q1.isEmpty() && !q2.isEmpty()) {
            HashSet<String> temp = new HashSet<>();
            for (String cur : q1) {
                if(set.contains(cur)) continue;
                if(q2.contains(cur)) return step;
                seen.add(cur);
                for (String next : getAll(cur)) if(!seen.contains(next)) temp.add(next);
            }
            step++;
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }

    public List<String> getAll(String cur) {
        LinkedList<String> res = new LinkedList<>();
        char[] charArray = cur.toCharArray();
        for(int i = 0;i < 4;i++) {
            char num = charArray[i];
            charArray[i] = numPrev(num);
            res.add(new String(charArray));
            charArray[i] = numSucc(num);
            res.add(new String(charArray));
            charArray[i] = num;
        }
        return res;
    }

    public char numPrev(char x) {
        return x == '0' ? '9' : (char) (x - 1);
    }

    public char numSucc(char x) {
        return x == '9' ? '0' : (char) (x + 1);
    }

    public static void main(String[] args) {
        String[] deadends = new String[]{"0201","0101","0102","1212","2002"};
        System.out.println(new LC752().openLock(deadends, "0202"));
    }
}
