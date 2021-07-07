package ShopeeTest;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class S1 {
    static boolean flag = false;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int intputNumer = in.nextInt();
        int input = intputNumer;
        List<Integer> list = new LinkedList<>();
        while(input != 0) {
            list.add(0, input % 10);
            input /= 10;
        }
        Collections.sort(list);
        if(parseInt(list) == intputNumer) {
            System.out.println(0);
            return ;
        }
        int[] num = new int[list.size()];
        for (int i = 0; i < num.length; i++) num[i] = list.get(i);
        boolean[] vis = new boolean[num.length];
        findNum(num, vis, new StringBuilder(), intputNumer);
    }
    public static void findNum(int[] num, boolean[] vis, StringBuilder sb, int target) {
        if(sb.length() == num.length) {
            int i = Integer.parseInt(sb.toString());
            if(i < target) System.out.println(i);
            else flag = true;
            return ;
        }
        for(int i = 0;i < num.length;i++) {
            if(vis[i]) continue;
            sb.append(num[i]);
            vis[i] = true;
            findNum(num, vis, sb, target);
            vis[i] = false;
            sb.deleteCharAt(sb.length() - 1);
            if(flag) return ;
        }
    }

    public static int parseInt(List<Integer> list) {
        int sum = 0;
        for(int i = 0;i < list.size();i++) {
            sum = sum * 10 + list.get(i);
        }
        return sum;
    }
}
