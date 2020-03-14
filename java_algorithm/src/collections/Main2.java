package collections;
import java.util.Scanner;

public class Main2 {
	public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
		int res = 0;
		for (int i = 2; i <= n; i++) {
			res = (res + 3) % i;
		}
		System.out.println(res + 1);
	}
}