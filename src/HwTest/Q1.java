package HwTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String workSstr = scan.nextLine();
        String[] workS = workSstr.split(" ");
        int wLen = workS.length;
        int[] workStations = new int[wLen];
        for(int i = 0;i < wLen;i++) workStations[i] = Integer.parseInt(workS[i]);
        Arrays.sort(workStations);
        String sterSstr = scan.nextLine();
        String[] sterS = sterSstr.split(" ");
        int sLen = sterS.length;
        int[] sterilizers = new int[sLen];
        for(int i = 0;i < sLen;i++) sterilizers[i] = Integer.parseInt(sterS[i]);
        Arrays.sort(sterilizers);
        int[] dp = new int[wLen];
        for(int i = 0;i < wLen;i++) dp[i] = Math.abs(sterilizers[0] - workStations[i]);
        for(int i = 1;i < sLen;i++) {
            for(int j = 0;j < wLen;j++) {
                dp[j] = Math.min(Math.abs(sterilizers[i] - workStations[j]), dp[j]);
            }
        }
        System.out.println(dp[wLen - 1]);
    }
}
