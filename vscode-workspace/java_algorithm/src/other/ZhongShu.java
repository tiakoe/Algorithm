package other;

import java.util.Scanner;

public class ZhongShu {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int res = 0, t = 0;
		int[] arr = new int[] { 1, 2, 3, 4, 4, 4, 4, 6, 7, 7 };
		for (int num : arr) {
			if (t == 0) {
				res = num;
				t += 1;
			} else if (res == num) {
				t += 1;
			} else {
				t -= 1;
			}
		}
		System.out.println(res);
	}

}
