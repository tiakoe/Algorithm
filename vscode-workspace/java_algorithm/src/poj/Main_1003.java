package poj;

import java.util.Scanner;

public class Main_1003 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		Double aFloat, t;
		int i = 0;
		while (in.hasNext()) {
			aFloat = in.nextDouble();
			t = 0.00;
			i = 0;
			if (aFloat == 0.00)
				break;
			for (i = 2; t < aFloat; i++) {
				t += 1.00 / i;
			}
			System.out.println(i - 2 + " card(s)");
		}
	}

}
