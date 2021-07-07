package ShopeeTest;

import java.util.*;

public class S3 {
    static boolean flag = false;
    static long intputNumer = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        intputNumer = Long.parseLong(str);
        char[] charArray = str.toCharArray();
        int[] numArr = new int[charArray.length];
        for(int i = 0;i < numArr.length;i++) {
            numArr[i] = charArray[i] - '0';
        }
        Arrays.sort(numArr);
        long sum = 0;
        for(int i = 0; i < numArr.length;i++) sum = sum * 10 + numArr[i];
        if(sum == intputNumer) {
            System.out.println(0);
            return ;
        }
        boolean[] vis = new boolean[numArr.length];
        findNum(numArr, vis, new StringBuilder());
    }
    public static void findNum(int[] num, boolean[] vis, StringBuilder sb) {
        if(sb.length() == num.length) {
            long i = Long.parseLong(sb.toString());
            if(i < intputNumer) System.out.println(i);
            else flag = true;
            return ;
        }
        for(int i = 0;i < num.length;i++) {
            if(vis[i]) continue;
            sb.append(num[i]);
            vis[i] = true;
            findNum(num, vis, sb);
            vis[i] = false;
            sb.deleteCharAt(sb.length() - 1);
            if(flag) return ;
        }
    }
}
