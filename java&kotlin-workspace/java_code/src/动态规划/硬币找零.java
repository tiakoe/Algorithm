package 动态规划;

import java.util.Arrays;

public class 硬币找零 {
    public static void main(String[] args) {
        int[] v = new int[] {1, 3, 6, 9};
        int n = 20;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int value : v) {
                if (i < value) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - value] + 1);
            }
            System.out.println(i + " : " + dp[i]);
        }
    }
}
