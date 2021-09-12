package JDExam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JDTest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();

        int[][] map = new int[128][2];
        char prev = ' ';
        for(int i = 0;i < n;i++) {
            String line = scanner.next();
            if(i == 0) prev = line.charAt(0);
            for(int j = 0;j < m;j++) {
                map[line.charAt(j)][0] = i;
                map[line.charAt(j)][1] = j;
            }
        }
        String str = scanner.next();
        int res = 0;
        for(int i = 0;i < str.length();i++) {
            char cur = str.charAt(i);
            if (prev != cur) {
                int[] from = map[prev];
                int[] to = map[cur];
                res += (Math.abs(from[0] - to[0]) + Math.abs(from[1] - to[1])) * x;
                if (from[0] != to[0] && from[1] != to[1]) res += y;
            }
            res += z;
            prev = cur;
        }
        System.out.println(res);
    }
}
