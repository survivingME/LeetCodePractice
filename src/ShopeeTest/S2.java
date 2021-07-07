package ShopeeTest;

import java.util.Scanner;

public class S2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        StringBuilder sb1 = new StringBuilder(input);
        StringBuilder sb2 = new StringBuilder();
        sb1.reverse();
        int cur = 0;
        while(cur != sb1.length()) {
            sb2.append(sb1.charAt(cur++));
            if(cur % 3 == 0) {
                sb2.append(',');
            }
        }
        System.out.println(sb2.reverse().toString());
    }
}
