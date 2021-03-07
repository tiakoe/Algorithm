package other;
import java.util.Scanner;

public class Main_GeZhi {
	static String rString, cString;
	static int rval = 0, cval = 0, count = 0, r, c, k;
	static boolean visited[][];

	static boolean visit(int r, int c) {
		visited[r][c] = true;
		rString = String.valueOf(r);
		cString = String.valueOf(c);
		rval = rString.chars().sum() - '0' * rString.length();
		cval = cString.chars().sum() - '0' * cString.length();
		if (rval + cval <= k) {
			count++;
			return true;
		} else {
			return false;
		}
	}

	static void solve(int i, int j) {
		if (i >= r || j >= c) {
			return;
		}
		if (!visited[i][j] && visit(i, j)) {
			solve(i + 1, j);
			solve(i - 1 < 0 ? 0 : i - 1, j);
			solve(i, j + 1);
			solve(i, j - 1 < 0 ? 0 : j - 1);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		r = in.nextInt();
		c = in.nextInt();
		k = in.nextInt();
		visited = new boolean[r][c];
		solve(0, 0);
		System.out.println(String.valueOf(count));
		in.close();
	}
}
