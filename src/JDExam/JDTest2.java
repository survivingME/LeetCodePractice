package JDExam;

import java.util.*;

public class JDTest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        Map<Integer, List<Integer>> depend = new HashMap<>();
        Map<Integer, List<Integer>> decide = new HashMap<>();
        for(int i = 1; i <= n;i++) {
            int num = scanner.nextInt();
            for(int j = 0;j < num;j++) {
                int e = scanner.nextInt();
                if(depend.get(i) != null) {
                    depend.get(i).add(e);
                } else {
                    List<Integer> list = new LinkedList<>();
                    list.add(e);
                    depend.put(i, list);
                }
                if(decide.get(e) != null) decide.get(e).add(i);
                else {
                    List<Integer> list = new LinkedList<>();
                    list.add(i);
                    decide.put(e, list);
                }
            }
        }
        boolean[] resArr = new boolean[n + 1];
        for(int i = 0;i < q;i++) {
            int flag = scanner.nextInt(), idx = scanner.nextInt();
            ArrayDeque<Integer> que = new ArrayDeque<>();
            if(flag == 1) {
                resArr[idx] = true;
                if(depend.containsKey(idx)) {
                    List<Integer> list = depend.get(idx);
                    que.addAll(list);
                    while(!que.isEmpty()) {
                        Integer poll = que.poll();
                        resArr[poll] = true;
                        if(depend.containsKey(poll)) que.addAll(depend.get(poll));
                    }
                }
            } else {
                resArr[idx] = false;
                if(decide.containsKey(idx)) {
                    List<Integer> list = decide.get(idx);
                    que.addAll(list);
                    while(!que.isEmpty()) {
                        Integer poll = que.poll();
                        resArr[poll] = false;
                        if(decide.containsKey(poll)) que.addAll(decide.get(poll));
                    }
                }
            }
            int res = 0;
            for (boolean b : resArr) if(b) res++;
            System.out.println(res);
        }
    }
}
