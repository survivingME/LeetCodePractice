package HwTest;

import java.util.*;

public class Q3 {
    static class Travel {
        String name;
        int from, to;
        public Travel(String name, int from, int to) {
            this.name = name;
            this.from = from;
            this.to = to;
        }
    }
    public static String[] res;
    public static int max = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Travel> list = new ArrayList<>();
        while(scan.hasNext()) {
            String line = scan.nextLine();
            String[] split = line.split(",");
            list.add(new Travel(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2])));
        }
        Collections.sort(list, (o1, o2) -> {
            if(o1.from != o2.from) return o1.from - o2.from;
            else if(o1.to != o2.to) return o1.to - o2.to;
            else return o1.name.compareTo(o2.name);
        });
        boolean[] vis = new boolean[list.size()];
        dfs(new LinkedList<>(), list, vis, 0);
        for (String name : res) System.out.print(name + " ");
    }

    public static void dfs(LinkedList<Travel> cur, ArrayList<Travel> list, boolean[] vis, int start) {
        for(int i = start; i < list.size();i++) {
            Travel t = list.get(i);
            if(cur.size() == 0) {
                cur.add(t);
                vis[i] = true;
                dfs(cur, list, vis, i + 1);
                vis[i] = false;
                cur.removeLast();
            } else {
                if(!vis[i] && cur.getFirst().to <= t.from) {
                    cur.add(t);
                    vis[i] = true;
                    dfs(cur, list, vis, i + 1);
                    vis[i] = false;
                    cur.removeLast();
                }
            }
        }
        int sum = 0;
        for (Travel travel : cur) {
            switch (travel.to - travel.from) {
                case 1 -> sum += 100;
                case 2 -> sum += 180;
                case 3 -> sum += 240;
                case 4 -> sum += 280;
            }
        }
        if(sum > max) {
            max = sum;
            res = new String[cur.size()];
            int idx = 0;
            for (Travel t : cur) res[idx++] = t.name;
            Arrays.sort(res);
        }
    }
}
