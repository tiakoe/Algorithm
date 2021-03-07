package other;
import java.util.Scanner;

/*
 * 通过；注意long；以及==在最前判断
 */
public class Main_HongBao {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] a = new long[n + 4];
		for (int i = 1; i <= n; i++) {
			a[i] = in.nextInt();
		}

		int i = 1, j = n;
		long s = a[1], e = a[n];
		long max = 0;
		while (i < j) {
			if (s == e) {
				max = s;
				s += a[++i];
			} else if (s < e) {
				s += a[++i];
			} else {
				e += a[--j];
			}
		}
		System.out.println(max);
		in.close();
	}

}
