package 动态规划;

import java.util.Arrays;

public class 子序列问题 {

    //    最长递增子序列
    static int f1(int[] a) {
        int[] dp = new int[a.length + 1];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    //    最长连续递增子序列
    static int f2(int[] a) {
        int ans = 0, anchor = 0;
        for (int i = 0; i < a.length; ++i) {
            if (i > 0 && a[i - 1] >= a[i]) {
                anchor = i;
            }
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
    }

    //    最长公共子序列
    static void LCS(char[] a, char[] b) {
        int[][] dp = new int[a.length + 1][b.length + 1];
        for (int i = 1; i <= a.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j <= b.length; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[a.length][b.length]);
    }

    public static void main(String[] args) {
        //        int[] a = new int[]{1, 1, 1, 2, 2, 2, 16, 4, 4, 4};
        int[] a = new int[] {1, 2, 3, 8, 8, 8, 3, 2, 1, 9, 7, 5, 6};
        //        LCS("HelloWorld".toCharArray(), "loopd".toCharArray());
        //        LCS("loopd".toCharArray(), "HelloWorld".toCharArray());
        System.out.println(f1(a));
        System.out.println(f2(a));
    }
}
