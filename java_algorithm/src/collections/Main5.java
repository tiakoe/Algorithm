package collections;
import java.util.Scanner;

//10 2 
//1 0 0 1 0 1 0 1 0 1
public class Main5 {
	static int[] a;

	static int sum(int s, int e) {
		int res = 0;
		for (int i = s; i <= e; i++) {
			res += a[i];
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int res = 0;
		a = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = in.nextInt();
		}
		int t = 0;
		for (int i = 1; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				t = sum(i, j);
				if (t < (j - i + 1)) {
					if (t + k == (j - i + 1)) {
						res = Math.max(res, t + k);
					}
				}
			}
		}
		System.out.println(res);
	}

}
