package other;
import java.util.Scanner;

/**
 * A = "HelloWorld" B = "loop" 输出lo dp[i][j]={0, A[i−1]!=B[j−1] dp[i−1][j−1]+1,
 * A[i−1]==B[j−1]
 * 
 * @author ASUS
 *
 */
public class LCS2 {

	static int deal(final char[] a, final char[] b) {
		final int m = a.length, n = b.length;
		int res = 0;
		final int[][] dp = new int[m + 1][n + 1];
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
					res = Math.max(res, dp[i][j]);
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return dp[m][n];
	}

	public static void main(final String[] args) {

		final Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			final String aString = in.nextLine();
			final String bString = in.nextLine();
			final int res = deal(aString.toCharArray(), bString.toCharArray());
			System.out.println(res);
		}
		in.close();
	}

}
