package HwTest;

import java.util.Arrays;
import java.util.Scanner;

public class Q2 {
    public static int[][] res;
    public static int len;
    public static boolean flag = false;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int mod = scan.nextInt();
        len = scan.nextInt();
        res = new int[len][2];
        int[] nums = new int[len * 2];
        for(int i = 0;i < len * 2;i++) nums[i] = scan.nextInt();
        Arrays.sort(nums);
        boolean[] vis = new boolean[len * 2];
        dfs(0, mod, nums, vis);
        if(flag) {
            for(int i = 0;i < len;i++) {
                System.out.print(res[i][0] + " ");
                System.out.print(res[i][1] + " ");
            }
        } else {
            System.out.println(0);
        }
    }

    public static void dfs(int cur, int mod, int[] nums, boolean[] vis) {
        if(cur == len) {
            flag = true;
            return ;
        }
        for(int i = len * 2 - 1;i >= 0;i--) {
            if(!flag && !vis[i]) {
                for(int j = i - 1;j >= 0;j--) {
                    if(!vis[j] && (nums[i] + nums[j]) % mod == 0) {
                        vis[i] = true;
                        vis[j] = true;
                        res[cur][0] = nums[i];
                        res[cur][1] = nums[j];
                        dfs(cur + 1, mod, nums, vis);
                        if(flag) return ;
                        res[cur][0] = 0;
                        res[cur][1] = 0;
                        vis[j] = false;
                        vis[i] = false;
                    }
                }
            }
        }
    }
}
