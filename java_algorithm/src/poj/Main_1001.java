package poj;

import java.util.Scanner;

public class Main_1001 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String reString = in.nextBigDecimal().pow(in.nextInt()).stripTrailingZeros().toPlainString();
			if (reString.startsWith("0")) {
				System.out.println(reString.substring(1));
			} else {
				System.out.println(reString);
			}
		}
	}
}
