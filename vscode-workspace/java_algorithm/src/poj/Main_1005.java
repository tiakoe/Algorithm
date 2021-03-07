package poj;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_1005 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		int n = in.nextInt();
		Double a, b, d;
		int c;
		for (int i = 1; i <= n; i++) {
			a = in.nextDouble();
			b = in.nextDouble();
			c = (int) (Math.PI * (a * a + b * b) / 2 / 50);
			d = (Math.PI * (a * a + b * b) / 2 % 50);
			if (d != 0) {
				c += 1;
			}
			arrayList.add(c);
		}
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(
					"Property " + (i + 1) + ": This property will begin eroding in year " + arrayList.get(i) + ".");
		}
		System.out.println("END OF OUTPUT.");
	}

}
