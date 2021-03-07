package other;
import java.util.Scanner;

/**
 * A = "HelloWorld" B = "loop" 输出最长公共子序列长度 dp[i][j]={ max{dp[i−1][j],dp[i][j−1]
 * A[i−1]!=B[j−1] } { dp[i−1][j−1]+1 A[i−1]==B[j−1] }
 * 
 * @author ASUS
 *
 */
public class LCS {

	static int deal(char[] a, char[] b) {
		int m = a.length, n = b.length;
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			dp[i][0] = 0;
		}
		for (int j = 0; j <= n; j++) {
			dp[0][j] = 0;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (a[i - 1] == b[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String aString = in.nextLine();
			String bString = in.nextLine();
			int res = deal(aString.toCharArray(), bString.toCharArray());
			System.out.println(res);
		}
	}

}
